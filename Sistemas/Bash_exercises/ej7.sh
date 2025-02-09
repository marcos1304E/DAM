   
dir="test7"
for archivo in "$dir"/*.conf
do
  if [ ! -e "$archivo" ]; then
    echo "No hay archivos .conf en $dir."
    exit 1
  fi
  
  sed -i 's/localhost/127.0.0.1/g' "$archivo"
  echo "Modificado: $archivo"
done
