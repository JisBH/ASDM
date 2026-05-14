package practica_2025_26;

import java.util.*;

public class Práctica_2025_26 {

    private Scanner scanner = new Scanner(System.in);
    private Scanner scanner2 = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        I_Agregado_Personajes personajes = new Agregado_Personajes();

        do {
            for (int i = 0; i < 50; ++i) {
                System.out.println();
            }

            System.out.println("\nMenú Principal:");
            System.out.println("1. Crear personaje(Factory Method)");
            System.out.println("2. Clonar personaje(Prototype)");
            System.out.println("3. Crear ejercitos(Composite)");
            System.out.println("4. Subir nivel de personaje (futura)");
            System.out.println("5. Listar personajes(Iterator)");
            System.out.println("6. Añade armas a personaje(futura)");

            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            for (int i = 0; i < 50; ++i) {
                System.out.println();
            }

            switch (opcion) {
                case 1:
                    //Personaje.Tipo.values() me devuelve un array con todos mis tipos de personaje
                    //Arrays.toString() lo convierte en un String para poder concatenarlo y mostrarlo

                    System.out.println("Introduce el tipo de personaje a crear " + Arrays.toString(Personaje.Tipo.values()));

                    //Lo paso a mayúsculas para que coincida con mi enum
                    String tipo = scanner2.nextLine().toUpperCase();

                    try {
                        //Esta primera línea hace un casting del String tipo introducido por teclado al
                        //tipo enum que tengo en la interfaz Personaje. Esto puede dar error si no coincide
                        //exactamente con como lo tengo escrito en el enum, de ahí que haya un try

                        Personaje.Tipo tipoEnum = Personaje.Tipo.valueOf(tipo);
                        System.out.println("Introduce el nombre del personaje");
                        String nombre = scanner2.nextLine();

                        //Con getHabilidadEspecial() el main se abstrae del tipo de personaje
                        //que introdujo el usuario antes
                        System.out.println("Introduce el valor de " + tipoEnum.getHabilidadEspecial());
                        int valor = scanner.nextInt();

                        //CreadorConcreto crea el personaje
                        Creador creador = new CreadorConcreto();
                        Personaje personaje = creador.factoryMethod(tipoEnum, nombre, valor);

                        //Técnicamente personaje nunca va a ser null porque con el try catch compruebo
                        //que el tipo sea válido, pero es bueno ponerlo aún así
                        if (personaje != null) {
                            personajes.agregar(personaje);
                            System.out.println("Se ha agregado el nuevo personaje");
                            personajes.recorrer();
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo de personaje no valido");
                    }

                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 2:
                    personajes.recorrer();
                    System.out.println("\nIntroduce el nombre del personaje a clonar");
                    String nombre = scanner2.nextLine();
                    Personaje original = personajes.devuelvePersonaje(nombre);

                    if (original == null) {
                        System.out.println("No se ha encontrado ningun personaje con ese nombre");

                    } else {
                        Personaje clon = original.clonar();
                        clon.setNombre(original.getNombre() + " (copia)");
                        System.out.println("Personaje clonado correctamente. Datos: ");
                        System.out.println("Nombre: " + clon.getNombre());
                        System.out.println("Nivel: " + clon.getNivel());
                        String nombreHabilidad = clon.getTipo().getHabilidadEspecial();
                        int valorHabilidad = clon.getValorHabilidadEspecial();
                        System.out.println("Habilidad Especial: " + nombreHabilidad + " (" + valorHabilidad + ")");

                        personajes.agregar(clon);

                        System.out.println("\nQuieres crear un ejercito de este personaje? [si no]");
                        String decision = scanner2.nextLine();
                        decision.toUpperCase();

                        if (decision.equalsIgnoreCase("SI")) {
                            System.out.println("Introduce el numero de copias a realizar");
                            int numeroCopias = scanner.nextInt();

                            for (int i = 0; i < numeroCopias; i++) {
                                Personaje personaje = clon.clonar();
                                personaje.setNombre(clon.getNombre() + i + 1);
                                personajes.agregar(personaje);
                            }
                            System.out.println("Ejercito creado");
                        }
                    }
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 3:
                    personajes.recorrer();
                    System.out.println("\nIntroduce el nombre del personaje a partir del cual hacer el ejercito");
                    nombre = scanner2.nextLine();
                    original = personajes.devuelvePersonaje(nombre);

                    if (original == null) {
                        System.out.println("No se ha encontrado ningun personaje con ese nombre");

                    } else {

                        Ejercito segundosHijos = new Ejercito("Segundos Hijos");
                        Ejercito inmaculados = new Ejercito("Los Inmaculados");
                        Ejercito targaryen = new Ejercito("Casa Daenerys Targaryen");

                        //Creo los clones del soldado para el ejército Segundos Hijos 
                        for (int i = 1; i <= 4; i++) {
                            Personaje soldado = original.clonar();
                            soldado.setNombre("Segundo Hijo: soldado " + i);
                            personajes.agregar(soldado);
                            segundosHijos.agregaSoldado((EjercitoSuperior) soldado);
                        }

                        //Creo los clones del soldado para el ejército Los Inmaculados
                        for (int i = 1; i <= 6; i++) {
                            Personaje soldado = original.clonar();
                            soldado.setNombre("Inmaculado: soldado " + i);
                            personajes.agregar(soldado);
                            inmaculados.agregaSoldado((EjercitoSuperior) soldado);
                        }

                        //Creo los clones del soldado para el ejército Guardia Targaryen
                        for (int i = 1; i <= 5; i++) {
                            Personaje soldado = original.clonar();
                            soldado.setNombre("Targaryen: soldado " + i);
                            personajes.agregar(soldado);
                            targaryen.agregaSoldado((EjercitoSuperior) soldado);
                        }

                        //Añado los ejércitos pequeños al ejército grande
                        targaryen.agregaSoldado(segundosHijos);
                        targaryen.agregaSoldado(inmaculados);

                        //Muestro toda la estructura de ejércitos y sus soldados
                        targaryen.mostrarNombre();
                    }

                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 4:
                    System.out.println("Subiremos el nivel de uno de los personajes, tendremos que elegir "
                            + "a uno de los añadidos por vosotros con anterioridad o de los ya existentes"
                            + " inicialmente");
                    System.out.println("Indicaremos al resto que se ha subido de nivel");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 5:
                    System.out.println("1 Listar todos los personajes");
                    System.out.println("2 Listar los magos");
                    System.out.println("3 Listar ordenados de mayor a menor valor de habilidad especial");
                    opcion = scanner.nextInt();

                    if (opcion == 1) {
                        I_Iterador itTod = personajes.crearIteradorTodos();

                        while (itTod.tieneSiguiente()) {
                            PersonajeBase p = (PersonajeBase) itTod.siguiente();

                            if (p != null) {
                                p.mostrar();
                            }
                        }

                    } else if (opcion == 2) {
                        I_Iterador itMag = personajes.crearIteradorMago();

                        while (itMag.tieneSiguiente()) {
                            PersonajeBase p = (PersonajeBase) itMag.siguiente();

                            if (p != null) {
                                p.mostrar();
                            }
                        }
                        
                    } else if (opcion == 3) {
                        I_Iterador itHab = personajes.crearIteradorHabilidad();

                        while (itHab.tieneSiguiente()) {
                            PersonajeBase p = (PersonajeBase) itHab.siguiente();

                            if (p != null) {
                                p.mostrar();
                            }
                        }
                    }

                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 6:
                    System.out.println("Se añadirán armas a alguno de "
                            + "los personajes existentes añadiéndolas "
                            + "al String armas que tiene cada personaje ");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 7:
                    System.out.println("Saliendo del programa...");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
            }

        } while (opcion != 7);
    }
}
