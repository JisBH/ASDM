/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

import java.util.ArrayList;
import java.util.List;

//Compuesto, formado por PersonajeBase (Hojas)
public class Ejercito extends EjercitoSuperior {

    private String nombre;
    protected List<EjercitoSuperior> ejercito = new ArrayList<>();

    public Ejercito(String nombre) {
        this.nombre = nombre;
    }

    /*Compruebo que el soldado sea un Personaje y no otro Ejercito
    Si es un Personaje, recorro la lista y, para cada uno de los soldados del ejército,
    hago que el nuevo soldado observe a los que ya había en él y que los que ya estaban
    observen al nuevo */
    @Override
    public void agregaSoldado(EjercitoSuperior soldado) {
        if (soldado instanceof Personaje) {
            for (EjercitoSuperior soldado2 : ejercito) {
                if (soldado2 instanceof Personaje) {
                    ((Personaje) soldado).agregarObservador(((Personaje) soldado2));
                    ((Personaje) soldado2).agregarObservador(((Personaje) soldado));
                }
            }

        }
        this.ejercito.add(soldado);
    }

    @Override
    public void eliminaSoldado(EjercitoSuperior soldado) {
        this.ejercito.remove(soldado);
    }

    //Si mi elemento de tipo EjercitoSuperior es un Ejercito, me llamo a mí mismo (recursión).
    //Si mi elemento es un PersonajeBase (Arquero, Guerrero, Mago) llamo a mostrarNombre() de la clase
    //del tipo de personaje concreto que sea, y me muestra el nombre de ese personaje.
    @Override
    public void mostrarNombre() {
        System.out.println("\nEjercito: " + this.nombre);
        for (EjercitoSuperior ej : ejercito) {
            ej.mostrarNombre();
        }
    }
}
