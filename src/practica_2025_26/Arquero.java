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
    public List<Personaje> clonar(int numCopias) {
        List<Personaje> listaCopias = new ArrayList<>();
        
        for(int i = 0; i < numCopias; i++){
            Arquero copia = new Arquero(this.nombre, this.puntería);
            listaCopias.add(copia);
        }
        return listaCopias;
    }
}
