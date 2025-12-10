dir="test6"   
for archivo in "$dir"/*.txt
do

	TOTAL_LINEAS=$(grep -c '^' "$archivo")
	
	if [ "$TOTAL_LINEAS" -gt 3 ]; then
    echo "El archivo $archivo tiene más de 3 líneas."
  else
    echo "El archivo $archivo tiene 3 líneas o menos."
  fi
done

