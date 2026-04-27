/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;


/*Esta es la clase Creador, es abstracta para que no se pueda instanciar.
factoryMethod también es abstracto para obligar a que los creadores concretos
implementen el método, creando el tipo que les corresponda
*/
public abstract class Creador {
    //Parámetros: enum de los tipos de personaje, nombre del personaje, habilidad especial(fuerza...)
    public abstract Personaje factoryMethod(Personaje.Tipo tipo, String nombre, int valor);
}
