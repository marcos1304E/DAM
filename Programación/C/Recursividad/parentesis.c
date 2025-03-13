#include<stdio.h>
#include <stdlib.h>


int prof(char * cadena, int balance){
	static int profundidad_max = 0;
	//base, cuando va a parar la recursion
	if (* cadena == '\0')
	{
		int retval = profundidad_max; profundidad_max = 0;
		return retval;
	}
	//caso rec
	if (* cadena == '(')
	{
		//con ternario//profundidad_max = balance > profundidad_max ? balance : profundidad_max;
		if (balance > profundidad_max)
		{
			profundidad_max = balance;
		}
		return prof(cadena + 1,balance + 1);

	}else if (* cadena == ')')
	{

		return prof(cadena + 1, balance -1);
	}else{
		return prof(cadena + 1, balance);
	}

//()(())()
//(((())))
	
}

int main(){

char palabra1 [30];
char palabra2 [30];

scanf("%s", palabra1);
scanf("%s", palabra2);

int encontrado1 = prof(palabra1, 0);
int encontrado2 = prof(palabra2, 0);

printf("%d\n", encontrado1);
printf("%d\n", encontrado2);

return 0;
}