package practica_2025_26;


public class Práctica_2025_26 {

    public static void main(String[] args) {
        int opcion;
        Fachada fachada = new Fachada();

        do {
            opcion = fachada.mostrarMenu();

            switch (opcion) {
                case 1:
                    fachada.crearPersonaje();
                    break;

                case 2:
                    fachada.clonarPersonaje();
                    break;

                case 3:
                    fachada.crearEjercitos();
                    break;

                case 4:
                    fachada.morirEnCombate();
                    break;

                case 5:
                    fachada.listarPersonajes();
                    break;

                case 6:
                    fachada.anhadeArmas();
                    break;

                case 7:
                    fachada.salir();
                    break;

                default:
                    fachada.mostrarError();
            }

        } while (opcion != 7);
    }
}
