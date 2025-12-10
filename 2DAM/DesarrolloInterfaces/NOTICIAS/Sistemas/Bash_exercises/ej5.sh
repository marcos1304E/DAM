dir="test5"  
for archivo in "$dir"/*
do
  
	if [[ -f "$archivo" && "$archivo" == *.jpg ]]; then
    nuevo_nombre="${archivo%.jpg}.old"
    mv "$archivo" "$nuevo_nombre"
    echo "Renombrado: $archivo -> $nuevo_nombre"
  fi
done
