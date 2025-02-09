  ps aux >> processes.txt

echo "Procesos guardados en processes.txt"

while IFS= read -r PROC; do
  if ps aux | grep -q "$PROC"; then
    echo "El proceso $PROC está en ejecución"
  else
    echo "El proceso $PROC no está en ejecución"
  fi
done < processes.txt
