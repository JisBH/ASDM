package practica_2025_26;


public abstract class PersonajeBase implements Personaje {

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
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public int getNivel() {
        return nivel;
    }
    
    @Override
    public Personaje.Tipo getTipo(){
        return this.tipo;
    }

    public void mostrar() {
        System.out.println("Nombre: " + nombre + ", Nivel: " + nivel + ", Armas: " + armas);
    }

}
