/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;


//Clase abstracta que engloba a Ejercito (Compuesto) y a PersonajeBase (Hoja)
public abstract class EjercitoSuperior {
    
    public abstract void agregaSoldado(EjercitoSuperior soldado);
    public abstract void eliminaSoldado(EjercitoSuperior soldado);
    public abstract void mostrarNombre();
}
