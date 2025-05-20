import java.util.Scanner;

public class Main {

    private static final int MAX = 100;

    private static Administracion[] administracionArr = new Administracion[MAX];
    private static int administracionCount = 0;

    private static Profesor[] profesorArr = new Profesor[MAX];
    private static int profesorCount = 0;

    private static Directivo[] directivoArr = new Directivo[MAX];
    private static int directivoCount = 0;

    private static Modulo[] moduloArr = new Modulo[MAX];
    private static int moduloCount = 0;

    private static Alumnos[] alumnoArr = new Alumnos[MAX];
    private static int alumnoCount = 0;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n------ MENÚ PRINCIPAL ------");
            System.out.println("1. Agregar Usuario Administración");
            System.out.println("2. Mostrar Usuarios Administración");
            System.out.println("3. Agregar Alumno");
            System.out.println("4. Mostrar Alumnos");
            System.out.println("5. Agregar Directivo");
            System.out.println("6. Mostrar Directivos");
            System.out.println("7. Agregar Profesor");
            System.out.println("8. Mostrar Profesores");
            System.out.println("9. Agregar Módulo");
            System.out.println("10. Mostrar Módulos");
            System.out.println("11. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                case 1:
                	agregarAdministracion(entrada);
                	break;
                case 2:
                	mostrarAdministracion();         
                	break;
                case 3:
                	agregarAlumno(entrada);         
                	break;
                case 4:
                	mostrarAlumnos();               
                	break;
                case 5:
                	agregarDirectivo(entrada);      
                	break;
                case 6:
                	mostrarDirectivos();            
                	break;
                case 7:
                	agregarProfesor(entrada);       
                	break;
                case 8:
                	mostrarProfesores();            
                	break;
                case 9:
                	agregarModulo(entrada);         
                	break;
                case 10: 
                	mostrarModulos();              
                	break;
                case 11:
                	System.out.println("Saliendo...");
                	break;
                default:
                	System.out.println("Opción no válida.");
            }

        } while (opcion != 11);

        entrada.close();
    }

    public static void agregarAdministracion(Scanner entrada) {
        if (administracionCount >= MAX) {
            System.out.println("Límite de administradores alcanzado.");
            return;
        }
        System.out.print("DNI: ");
        String dni = entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = entrada.nextLine();
        System.out.print("Salario: ");
        int salario = entrada.nextInt(); entrada.nextLine();
        System.out.print("Estudios: ");
        String estudios = entrada.nextLine();
        System.out.print("Antigüedad (años): ");
        int antiguedad = entrada.nextInt(); entrada.nextLine();

        administracionArr[administracionCount++] =
            new Administracion(dni, nombre, apellidos, salario, estudios, antiguedad);

        System.out.println("Administración agregada.");
    }

    public static void mostrarAdministracion() {
        if (administracionCount == 0) {
            System.out.println("No hay usuarios de administración.");
            return;
        }
        for (int i = 0; i < administracionCount; i++) {
            System.out.println(administracionArr[i]);
        }
    }

    public static void agregarAlumno(Scanner entrada) {
        if (alumnoCount >= MAX) {
            System.out.println("Límite de alumnos alcanzado.");
            return;
        }
        if (moduloCount == 0) {
            System.out.println("— Antes, añade al menos un módulo (opción 9).");
            return;
        }
        System.out.print("DNI: ");
        String dni = entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Apellido: ");
        String apellido = entrada.nextLine();
        System.out.print("Fecha nacimiento (DD/MM/AAAA): ");
        String fecha = entrada.nextLine();
        System.out.print("Sexo (H/M): ");
        String sexo = entrada.nextLine();
        System.out.print("¿Repetidor? (true/false): ");
        boolean rep = entrada.nextBoolean(); entrada.nextLine();

        Modulo[] mods = new Modulo[moduloCount];
        for (int i = 0; i < moduloCount; i++) {
            mods[i] = moduloArr[i];
        }

        alumnoArr[alumnoCount++] =
            new Alumnos(dni, nombre, apellido, fecha, sexo, rep, mods);

        System.out.println("Alumno agregado.");
    }

    public static void mostrarAlumnos() {
        if (alumnoCount == 0) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        for (int i = 0; i < alumnoCount; i++) {
            System.out.println(alumnoArr[i]);
        }
    }

    public static void agregarDirectivo(Scanner entrada) {
        if (directivoCount >= MAX) {
            System.out.println("Límite de directivos alcanzado.");
            return;
        }
        System.out.print("DNI: ");
        String dni = entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = entrada.nextLine();
        System.out.print("Salario: ");
        int salario = entrada.nextInt();
        System.out.print("¿Salesiano? (true/false): ");
        boolean sale = entrada.nextBoolean();
        System.out.print("¿Turno? (true/false): ");
        boolean turno = entrada.nextBoolean(); entrada.nextLine();

        directivoArr[directivoCount++] =
            new Directivo(dni, nombre, apellidos, salario, sale, turno);

        System.out.println("Directivo agregado.");
    }

    public static void mostrarDirectivos() {
        if (directivoCount == 0) {
            System.out.println("No hay directivos registrados.");
            return;
        }
        for (int i = 0; i < directivoCount; i++) {
            System.out.println(directivoArr[i]);
        }
    }

    public static void agregarProfesor(Scanner entrada) {
        if (profesorCount >= MAX) {
            System.out.println("Límite de profesores alcanzado.");
            return;
        }
        System.out.print("DNI: ");
        String dni = entrada.nextLine();
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Apellidos: ");
        String apellidos = entrada.nextLine();
        System.out.print("Salario: ");
        int salario = entrada.nextInt();
        System.out.print("Asignaturas: ");
        int nAsig = entrada.nextInt();
        System.out.print("¿Tutor? (true/false): ");
        boolean tutor = entrada.nextBoolean(); entrada.nextLine();

        profesorArr[profesorCount++] =
            new Profesor(dni, nombre, apellidos, salario, nAsig, tutor);

        System.out.println("Profesor agregado.");
    }

    public static void mostrarProfesores() {
        if (profesorCount == 0) {
            System.out.println("No hay profesores registrados.");
            return;
        }
        for (int i = 0; i < profesorCount; i++) {
            System.out.println(profesorArr[i]);
        }
    }

    public static void agregarModulo(Scanner entrada) {
        if (moduloCount >= MAX) {
            System.out.println("Límite de módulos alcanzado.");
            return;
        }
        if (profesorCount == 0) {
            System.out.println("— Añade primero un profesor (opción 7).");
            return;
        }
        System.out.print("Nombre módulo: ");
        String nombre = entrada.nextLine();
        System.out.print("Horas: ");
        int horas = entrada.nextInt();
        System.out.print("¿Convalidable? (true/false): ");
        boolean conv = entrada.nextBoolean(); entrada.nextLine();

        System.out.println("Profesores disponibles:");
        for (int i = 0; i < profesorCount; i++) {
            System.out.printf("%d) %s %s%n", i, profesorArr[i].getNombre(), profesorArr[i].getApellidos());
        }
        System.out.print("Selecciona índice: ");
        int idx = entrada.nextInt(); entrada.nextLine();

        moduloArr[moduloCount++] =
            new Modulo(nombre, horas, profesorArr[idx], conv);

        System.out.println("Módulo agregado.");
    }

    public static void mostrarModulos() {
        if (moduloCount == 0) {
            System.out.println("No hay módulos registrados.");
            return;
        }
        for (int i = 0; i < moduloCount; i++) {
            System.out.println(moduloArr[i]);
        }
    }
}

