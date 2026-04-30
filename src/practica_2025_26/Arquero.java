package practica_2025_26;

import java.util.List;
import java.util.ArrayList;

public class Arquero extends PersonajeBase {
    
    private int puntería;
    
    public Arquero (String nombre, int punteria) {
        super(nombre);
        this.puntería=punteria;
        //Al ser tipo un enum, tengo que guardarlo de este modo
        this.tipo=Personaje.Tipo.ARQUERO;
    }

    @Override
    public Personaje clonar() {
        return new Arquero(this.nombre, this.puntería);
    }

    @Override
    public int getValorHabilidadEspecial() {
        return this.puntería;
    }
}
