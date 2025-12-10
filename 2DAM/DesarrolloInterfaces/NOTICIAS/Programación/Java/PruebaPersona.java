public class PruebaPersona {

	public static void main(String[] args) {

		Persona p1 = new Persona(55, 1.8, 85, false, "aguda");
		
		System.out.println(p1.toString());
		
		p1.setAltura(1.2);
		System.out.println(p1.toString());
		
		System.out.println("La altura de esta persona es " + p1.getAltura());
		
		Persona p2 = new Persona(99);
		
		System.out.println(p2.toString());
		
		p2.setAltura(3.5);
		p2.setPeso(55);
		p2.setPelo(true);
		p2.setVoz("METALICA");
		
		System.out.println("P2 "+ p2.toString());
		
			
	}

}
