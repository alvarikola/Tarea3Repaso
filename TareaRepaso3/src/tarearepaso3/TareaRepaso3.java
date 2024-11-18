package tarearepaso3;

/*
3. Implementa una solución sencilla al problema de la comida de los 5 filésofos de
Dijkstra que evite el interbloqueo. Cinco filósofos pasan la vida pensando en una
mesa redonda, y solo dejan de pensar de vez en cuando para comer de un cuenco de
espaguetis. Para ello, deben tomar los palillos que tienen a ambos lados, primero uno
luego el otro. Por supuesto, no pueden coger un palillo si lo está utilizando otro fi-
lósofo. Entonces, deben esperar a que termine y lo suelte. Una vez tomado un palillo,
no lo sueltan hasta que no consiguen el otro palillo. Entonces, comen y, cuando han
terminado de comer, dejan ambos palillos de nuevo en la mesa.
Se recomienda numerar a los fiósofos de 0 a 4. El filósofo i come con los palillos
i (a su izquierda) e (i + 1) mod 5 (a su derecha).
Debe tenerse especial cuidado para que la so-
lución implementada elimine toda posibilidad de
interbloqueo. Cómo lo has hecho?
2Sería posible, con la solución que has imple-
mentado, que algún filósofo no consiguiera comer
nunca, por improbable que fuera? Si es así, explica
el escenario en que esto sucedería.
*/


public class TareaRepaso3 {

    
    public static void main(String[] args) {
        // Crear el recurso compartido (Palillos)
        RepartidorPalillos repartidorPalillos = new RepartidorPalillos();
        
        // Crear los hilos (filósofos)
        Thread filosofo1 = new Thread(new Filosofo(repartidorPalillos, 0, "Palillo 1", "Palillo 2"));
        Thread filosofo2 = new Thread(new Filosofo(repartidorPalillos, 1, "Palillo 2", "Palillo 3"));
        Thread filosofo3 = new Thread(new Filosofo(repartidorPalillos, 2, "Palillo 3", "Palillo 4"));
        Thread filosofo4 = new Thread(new Filosofo(repartidorPalillos, 3, "Palillo 4", "Palillo 5"));
        Thread filosofo5 = new Thread(new Filosofo(repartidorPalillos, 4, "Palillo 5", "Palillo 1"));
        
        // Iniciar los hilos
        filosofo1.start();
        filosofo2.start();
        filosofo3.start();
        filosofo4.start();
        filosofo5.start();
    }
    
}
