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
            System.out.println("3. Subir nivel de personaje (futura)");
            System.out.println("4. Listar personajes(futura)");
            System.out.println("5. Añade armas a personaje(futura)");

            System.out.println("6. Salir");
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
                    Personaje personaje = personajes.devuelvePersonaje(nombre);
                    System.out.println("Quieres modificar alguna de sus caracteristicas? [si no]");
                    String decision = scanner2.nextLine();
                    decision.toUpperCase();
                    
                    if(decision.equals("SI")){
                        System.out.println("Que caracteristicas quieres modificar?" + personaje.);
                    }
                    
                    System.out.println("Clonaremos un personaje ya creado "
                            + " modificando los datos que sean necesarios\n "
                            + "y se añadirá a la lista, se podría añadir "
                            + "la construcción de ejercitos, es decir,\n "
                            + "crear por ejemplo un arquero con unas "
                            + "características y después crear un número\n "
                            + "de arqueros iguales.");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 3:
                    System.out.println("Subiremos el nivel de uno de los personajes, tendremos que elegir "
                            + "a uno de los añadidos por vosotros con anterioridad o de los ya existentes"
                            + " inicialmente");
                    System.out.println("Indicaremos al resto que se ha subido de nivel");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;

                case 4:
                    System.out.println("Se mostrarán los distintos personajes"
                            + " se podrían incluir opociones de muestreo, ejemplo solo los "
                            + "magos o por orden de mayor nivel, etc. "
                            + "Con un par bastaría. ");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 5:
                    System.out.println("Se añadirán armas a alguno de "
                            + "los personajes existentes añadiéndolas "
                            + "al String armas que tiene cada personaje ");
                    System.out.println("Presiona para continuar");
                    scanner2.nextLine();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    System.out.println("Presina para continuar");
                    scanner2.nextLine();
            }

        } while (opcion != 6);
    }
}
