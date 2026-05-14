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
public class IteradorMago implements I_Iterador {

    private ArrayList<Personaje> personajes;
    private int posicion = 0;

    public IteradorMago(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public Object siguiente() {
        if (posicion < personajes.size()) {
            if (personajes.get(posicion) instanceof Mago) {
                return personajes.get(posicion++);
            } else {
                posicion++;
                return null;
            }
        } else {
            System.out.println("No hay mas personajes");
            return null;
        }
    }

    @Override
    public boolean tieneSiguiente() {
        if (posicion < personajes.size()) {
            return true;
        } else {
            return false;
        }
    }
}
