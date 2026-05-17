/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

import java.util.ArrayList;

// Recorre los personajes de mayor a menor valor de habilidad especial 
public class IteradorHabilidad implements I_Iterador {

    private ArrayList<Personaje> personajes;

    public IteradorHabilidad(ArrayList<Personaje> personajes) {
        // Copia de la lista de personajes
        this.personajes = new ArrayList<>(personajes);
    }

    @Override
    public Object siguiente() {
        // Hago la típica búsqueda de qué personaje tiene mayor valor de habilidad, empezando
        // por 0 y comparando entre todos. También obtengo la posición del mayor
        if (!personajes.isEmpty()) {
            int mayorHabEsp = 0;
            int posMayorHabEsp = 0;
            int i;
            
            for (i = 0; i < personajes.size(); i++) {
                if (personajes.get(i).getValorHabilidadEspecial() > mayorHabEsp) {
                    mayorHabEsp = personajes.get(i).getValorHabilidadEspecial();
                    posMayorHabEsp = i;
                }
            }
            // Una vez tengo al mayor, lo elimino de la copia de la lista. Así cuando
            // vuelva a llamar al método, buscará el segundo mayor (porque el primero ya 
            // no existe) y así sucesivamente hasta que no queden más
            return personajes.remove(posMayorHabEsp);
            
        } else {
            System.out.println("No hay mas personajes");
            return null;
        }
    }

    @Override
    public boolean tieneSiguiente() {
        if (!personajes.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
