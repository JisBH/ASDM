/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class IteradorHabilidad implements I_Iterador {

    private ArrayList<Personaje> personajes;

    public IteradorHabilidad(ArrayList<Personaje> personajes) {
        this.personajes = new ArrayList<>(personajes);
    }

    @Override
    public Object siguiente() {
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
