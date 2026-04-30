package practica_2025_26;

import java.util.ArrayList;

public class Agregado_Personajes implements I_Agregado_Personajes{
        private ArrayList<Personaje> personajes;
        
        Agregado_Personajes(){
            personajes = new ArrayList<>();
        }
        
    @Override
    public void agregar(Personaje personaje) {
        personajes.add(personaje);
    }
    
    @Override
    public void recorrer(){
        System.out.println("Estos son los personajes creados hasta el momento.");
        for(int i=0;i<personajes.size();i++)
            //Probar a que me diga el nivel y otros datos
            System.out.println(personajes.get(i).getNombre());
    }

    @Override
    public Personaje devuelvePersonaje(String nombre) {
        for(Personaje unPersonaje : personajes){
            if(unPersonaje.getNombre().equals(nombre))
                return unPersonaje;
            
        }
        return null;
    }
        
    
}
