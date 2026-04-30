package practica_2025_26;

import java.util.ArrayList;
import java.util.List;

public class Mago extends PersonajeBase {
    
    private int nivel_magia;
    
       
    public Mago(String nombre, int nivel_magia) {
        super(nombre);
        this.nivel_magia=nivel_magia;
        //Al ser tipo un enum, tengo que guardarlo de este modo
        this.tipo=Personaje.Tipo.MAGO;
    }

    @Override
    public Personaje clonar() {
        return new Mago(this.nombre, this.nivel_magia);
    }

    @Override
    public int getValorHabilidadEspecial() {
        return this.nivel_magia;
    }
    
}
