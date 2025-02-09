   for (( i=1; i<=5; i++ ))
do
  if [ $i -eq 3 ]; then
    echo "Saltamos el número 3"
    continue
  fi
  echo "i = $i"
done
