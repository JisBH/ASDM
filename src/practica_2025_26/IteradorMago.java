/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

import java.util.ArrayList;


// Recorre la lista de personajes y solo devuelve a los magos 
public class IteradorMago implements I_Iterador {

    private ArrayList<Personaje> personajes;
    private int posicion = 0;

    public IteradorMago(ArrayList<Personaje> personajes) {
        this.personajes = personajes;
    }

    @Override
    public Object siguiente() {
        // Por si acaso en el main no se llama a tieneSiguiente() antes, me aseguro de que
        // posicion este apuntando a un mago
        if (this.tieneSiguiente()) {
            // Como en el main he hecho un while de tieneSiguiente(), se que posicion va
            // a estar apuntando al proximo mago y puedo hacer el return directamente
            return personajes.get(posicion++);
        } else {
            System.out.println("No hay mas magos");
            return null;
        }
    }

    @Override
    public boolean tieneSiguiente() {
        // Como solo tenemos que iterar por los magos, buscamos si existe un mago
        // No solo averiguamos si hay mas magos, sino que dejo posicion apuntando a un mago
        while (posicion < personajes.size()) {
            if (personajes.get(posicion) instanceof Mago) {
                return true;
            }
            posicion++;
        }
        return false;
    }
}
