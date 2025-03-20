public class ejemploBucleFor {
		public static void main(String[] args) {
			int n, s=0;
			boolean suspensos;
			suspensos = false;
			int notas[] =  {4,6,8,1,10};

			for(int i = 0; i < 5; i++) {
				System.out.println("Introduzca nota (de 0 a 10):");
				if(n<5)
					suspensos = true;
				s++;
			}
			if (suspensos)
				System.out.println("Hay alumnos suspensos" +s);
			else
				System.out.println("No hay suspensos");
				}
			
}
