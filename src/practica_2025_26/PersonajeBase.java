package practica_2025_26;

import java.util.ArrayList;

public abstract class PersonajeBase extends EjercitoSuperior implements Personaje {

    protected String nombre;
    protected int nivel;
    protected String armas;
    //Ahora el atributo tipo pasa a ser de tipo enum en lugar de String
    protected Personaje.Tipo tipo;
    protected double precio;
    private ArrayList<Personaje> observadores;

    public PersonajeBase(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        this.armas = "Hacha de piedra";
        this.precio = 1;
        this.observadores = new ArrayList<Personaje>();
    }

    @Override
    public void subirNivel() {
        nivel++;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int getNivel() {
        return nivel;
    }

    @Override
    public Personaje.Tipo getTipo() {
        return this.tipo;
    }

    @Override
    public void mostrar() {
        System.out.println("Nombre: " + nombre + ", Tipo: " + getTipo() + ", Habilidad: " + getTipo().getHabilidadEspecial() + " " + getValorHabilidadEspecial());
    }

    //Vacío, una hoja no tiene más hojas dentro de ella
    @Override
    public void agregaSoldado(EjercitoSuperior soldado) {
        return;
    }

    //Vacío, una hoja no tiene más hojas dentro de ella
    @Override
    public void eliminaSoldado(EjercitoSuperior soldado) {
        return;
    }

    //Muestro el nombre de los soldados del ejercito
    @Override
    public void mostrarNombre() {
        System.out.println(nombre);
    }

    //Por seguridad, compruebo que un personaje no se observe a sí mismo ni que hayan duplicados
    @Override
    public void agregarObservador(Personaje p) {
        if (p != this && !this.observadores.contains(p)) {
            this.observadores.add(p);
        }
    }

    @Override
    public void eliminarObservador(Personaje p) {
        this.observadores.remove(p);
    }
    
    //Aviso de la muerte al observador
    @Override
    public void notificarMuerte(Personaje p) {
        for (Personaje o : observadores) {
            o.recibirAvisoMuerte(p);
        }
    }

    //Muestro el mensaje y paso a la víctima para que el observador pueda mostrar su nombre
    @Override
    public void matar() {
        System.out.println("El personaje " + nombre + " ha muerto");
        notificarMuerte(this);
    }

    //Muestro el nombre del observador y del sujeto que muere
    @Override
    public void recibirAvisoMuerte(Personaje p) {
        System.out.println("Soy " + nombre + " y me he enterado de que " + p.getNombre() + " ha muerto");
    }
}
