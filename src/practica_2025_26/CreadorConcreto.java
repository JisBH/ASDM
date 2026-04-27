/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_2025_26;

/*He decidido usar la aproximación vista en clase llamada Simple Factory consistente
en que haya un único Creador Concreto para todos los Productos Concretos. Así tengo menos clases
La otra opción sería un Creador por cada Producto.

Simplemente según el tipo, instancio un objeto de la clase correspondiente y le paso el nombre
y su habilidad especial
*/
public class CreadorConcreto extends Creador {
    
    @Override
    public Personaje factoryMethod(Personaje.Tipo tipo, String nombre, int valor){
        
        switch (tipo){
            case ARQUERO:
                return new Arquero(nombre, valor);
            
            case GUERRERO:
                return new Guerrero(nombre, valor);
                
            case MAGO:
                return new Mago(nombre, valor);
                
            default:
                return null;
        }
    }
}
