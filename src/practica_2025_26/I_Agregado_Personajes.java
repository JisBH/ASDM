package practica_2025_26;

public interface I_Agregado_Personajes {

    void agregar(Personaje personaje);

    void recorrer();

    Personaje devuelvePersonaje(String nombre);

    I_Iterador crearIteradorMago();

    I_Iterador crearIteradorTodos();

    I_Iterador crearIteradorHabilidad();
}
