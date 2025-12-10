#!/bin/bash

# Función para borrar un usuario
borrar_usuario() {
	read -p "Ingresa el nombre del usuario que quieres borrar: " usuario
# Comprobamos que el campo usuario no este vacío utilizando '-Z'.
		if [ -z "$usuario" ]; then
			echo "El nombre de usuario no puede estar vacío."
				return 1
				fi
				sudo userdel -r "$usuario" && echo "Usuario $usuario borrado correctamente." || echo "Hubo un error al borrar al usuario $usuario."
}

# Función para listar los usuarios y sus grupos
listar_usuarios() {
# Comprobamos si no existe el archivo /rtc/passwd
# !(lo contrario) de -f (comprueba si un archivo existe) = comprueba si 
# no existe.
	if [ ! -f /etc/passwd ]; then
		echo "El archivo /etc/passwd no se encuentra. No se puede listar usuarios."
			return 1
			fi

			echo "Lista de usuarios y sus grupos:"
# Separa cada campo con dos puntos
			while IFS=: read -r usuario pass uid gid fullname homedir shell; do
# Obtenemos el grupo principal del usuario
				grupo=$(id -gn "$usuario")
					echo "Usuario: $usuario, Grupo: $grupo"
					done < /etc/passwd
					read -p "Presiona cualquier tecla para continuar..." cualquier_tecla
}

# Función para agregar un nuevo usuario a un grupo
crear_usuario() {
	while true; do
		read -p "Ingresa el nombre del nuevo usuario: " usuario
# Comprueba si el campo usuario esta vacío.
			if [ -z "$usuario" ]; then
				echo "El nombre de usuario no puede estar vacío."
					return 1
					fi
# Verificar si el usuario ya existe
					if id "$usuario" &>/dev/null; then
						echo "El usuario '$usuario' ya existe."
							return 1
							fi
# Ingresa la contraseña
							read -s -p "Ingresa la contraseña para el nuevo usuario: " pass

# Crear el usuario
							sudo useradd -m -s /bin/bash "$usuario" && echo "$usuario:$pass" | sudo chpasswd
							if [ $? -eq 0 ]; then
								echo "Usuario '$usuario' creado correctamente."
							else
								echo "Hubo un problema al crear el usuario."
									return 1  # Sale de la función si hay un error
									fi

# Preguntar si queremos agregar al usuario a un grupo
									read -p "¿Quieres agregar este usuario a un grupo? (s/n): " respuesta
									if [[ "$respuesta" == "s" || "$respuesta" == "S" ]]; then
										while true; do
											read -p "Ingresa el nombre del grupo al que deseas agregar al usuario: " grupo
# Comprobamos si no existe el grupo
												if [ -z "$grupo" ]; then
													echo "No se ha ingresado un nombre de grupo válido."
														continue  # Pide el nombre del grupo nuevamente
														fi

														if getent group "$grupo" &>/dev/null; then
# Si el grupo existe, agregar al usuario a ese grupo
															sudo usermod -aG "$grupo" "$usuario"
																echo "El usuario '$usuario' ha sido agregado al grupo '$grupo'."
																break  # Sale del bucle una vez que el usuario ha sido agregado al grupo
														else
															echo "El grupo '$grupo' no existe. Intenta nuevamente."
																fi
																done
																fi
																break  # Salimos del bucle cuando todo está correcto
																done
}

# Menú principal
while true; do
clear
echo "### Menú de Administración de Usuarios ###"
echo "1. Borrar un usuario"
echo "2. Listar usuarios y sus grupos"
echo "3. Crear un nuevo usuario"
echo "4. Salir"
read -p "Selecciona una opción [1-4]: " opcion

case $opcion in
1)
borrar_usuario
;;
2)
listar_usuarios
;;
3)
crear_usuario
;;
4)
echo "Saliendo..."
break
;;
*)
echo "Opción inválida, por favor selecciona una opción válida."
;;
esac

# Esperar antes de volver a mostrar el menú
read -p "Presiona cualquier tecla para continuar..." cualquier_tecla
done

