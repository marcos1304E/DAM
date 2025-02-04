for ARCH in test3/*log*; do
    
	if grep -q "ERROR" "$ARCH"; then
	
	      	echo "El log $ARCH tiene errores"
      else
	      echo "El log $ARCH no tiene errores"
	  fi

	done
