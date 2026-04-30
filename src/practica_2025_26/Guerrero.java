package practica_2025_26;

import java.util.ArrayList;
import java.util.List;

public class Guerrero extends PersonajeBase {
    
    private int fuerza;
    
    public Guerrero(String nombre, int fuerza) {
        super(nombre);
        this.fuerza=fuerza;
        //Al ser tipo un enum, tengo que guardarlo de este modo
        this.tipo=Personaje.Tipo.GUERRERO;
    }
    
    @Override
    public Personaje clonar() {
        return new Guerrero(this.nombre, this.fuerza);
    }

    @Override
    public int getValorHabilidadEspecial() {
        return this.fuerza;
    }
}
