package practica_2025_26;

import java.util.List;

public interface Personaje {

    /*He optado por cambiar el modo de almacenar el tipo de cada personaje a un enum.
    De este modo tengo que hacer menos comparaciones de Strings y es más intuitivo
    visualmente
     */
    enum Tipo {
        /*Defino los tipos y llamo al constructor que asocia cada tipo con su habilidad.
        Así reduzco el acoplamiento ya que añadir o eliminar un tipo solo implica modificar
        una línea aquí y el case correspondiente de CreadorConcreto.
        
        También me permite no tener que establecer condionales en el main para averiguar
        el tipo que quiere crear el usuario y preguntarle por esa habilidad en específico
         */
        GUERRERO("Fuerza"),
        MAGO("Nivel de magia"),
        ARQUERO("Punteria");

        private final String habilidadEspecial;

        Tipo(String nombre) {
            this.habilidadEspecial = nombre;
        }

        public String getHabilidadEspecial() {
            return habilidadEspecial;
        }
    }

    void subirNivel();

    public String getNombre();

    public void setNombre(String nombre);

    public int getNivel();

    public Personaje.Tipo getTipo();

    public int getValorHabilidadEspecial();

    public Personaje clonar();

    public void mostrar();

    //Tanto el sujeto como el observador son de tipo Personaje, así que la interfaz debe
    //tener los métodos de ambos "roles"
    
    //Método del sujeto
    public void agregarObservador(Personaje p);

    //Método del sujeto
    public void eliminarObservador(Personaje p);

    //Método del sujeto
    public void notificarMuerte(Personaje p);

    //Método del sujeto
    public void matar();

    //Método del observador
    public void recibirAvisoMuerte(Personaje p);

}
