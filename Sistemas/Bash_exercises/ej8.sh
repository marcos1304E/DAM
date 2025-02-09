  archivo="test8/usuarios.txt"

while IFS= read -r USUARIO; do
  if [ "$USUARIO" == "maria" ]; then
    echo "Hola maria"
  else
    echo "Hola, $USUARIO"
  fi
done < "$archivo"

