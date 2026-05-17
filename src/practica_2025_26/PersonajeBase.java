package practica_2025_26;

public abstract class PersonajeBase extends EjercitoSuperior implements Personaje {

    protected String nombre;
    protected int nivel;
    protected String armas;
    //Ahora el atributo tipo pasa a ser de tipo enum en lugar de String
    protected Personaje.Tipo tipo;
    protected double precio;

    public PersonajeBase(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        this.armas = "Hacha de piedra";
        this.precio = 1;
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
}
