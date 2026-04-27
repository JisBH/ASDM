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
    public List<Personaje> clonar(int numCopias) {
        List<Personaje> listaCopias = new ArrayList<>();
        
        for(int i = 0; i < numCopias; i++){
            Mago copia = new Mago(this.nombre, this.nivel_magia);
            listaCopias.add(copia);
        }
        return listaCopias;
    }
    
}
