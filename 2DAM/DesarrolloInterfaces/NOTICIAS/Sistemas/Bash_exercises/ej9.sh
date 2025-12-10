    dir="test9"
if [ ! -d "$dir" ]; then
  echo "El directorio $dir no existe."
  exit 1
fi

for SUBDIR in "$dir"/*
do
  if [ -d "$SUBDIR" ]; then
    echo "Explorando directorio: $SUBDIR"
    
    for archivo in "$SUBDIR"/*.txt
    do
      if [ -f "$archivo" ]; then
        echo "Primera línea de $archivo:"
        head -n 1 "$archivo"
      fi
    done
  fi
done
