package tarearepaso3;


public class RepartidorPalillos {
    boolean hayPalillo1 = true;
    boolean hayPalillo2 = true;
    boolean hayPalillo3 = true;
    boolean hayPalillo4 = true;
    boolean hayPalillo5 = true;
   
    
    // Método sincronizado para tomar palillos
    synchronized public void tomarPalillos(int idFilosofo, String necesitaPalillo1, String necesitaPalillo2) {

        while ((idFilosofo == 0 && (!hayPalillo1 || !hayPalillo2) ||
                idFilosofo == 1 && (!hayPalillo2 || !hayPalillo3) ||
                idFilosofo == 2 && (!hayPalillo3 || !hayPalillo4) ||
                idFilosofo == 3 && (!hayPalillo4 || !hayPalillo5) ||
                idFilosofo == 4 && (!hayPalillo5 || !hayPalillo1))) {
            System.out.printf("--- Filosofo %d espera a los palillos %s y %s.\n", idFilosofo, necesitaPalillo1, necesitaPalillo2);
            try {
                wait(); // Espera si los palillos no están disponibles
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Tomar los palillos
        if (idFilosofo == 0){
            hayPalillo1 = false;
            hayPalillo2 = false;
        }
        if (idFilosofo == 1){
            hayPalillo2 = false;
            hayPalillo3 = false;
        }
        if (idFilosofo == 2){
            hayPalillo3 = false;
            hayPalillo4 = false;
        }
        if (idFilosofo == 3){
            hayPalillo4 = false;
            hayPalillo5 = false;
        }
        if (idFilosofo == 4){
            hayPalillo5 = false;
            hayPalillo1 = false;
        }
        
        System.out.printf(">>> Filosofo %d tomo los palillos %s y %s.\n", idFilosofo, necesitaPalillo1, necesitaPalillo2);
    }

    // Método sincronizado para soltar palillos
    synchronized public void soltarPalillos(int idFilosofo, String necesitaPalillo1, String necesitaPalillo2) {
       
        if (idFilosofo == 0){
            hayPalillo1 = true;
            hayPalillo2 = true;
        }
        if (idFilosofo == 1){
            hayPalillo2 = true;
            hayPalillo3 = true;
        }
        if (idFilosofo == 2){
            hayPalillo3 = true;
            hayPalillo4 = true;
        }
        if (idFilosofo == 3){
            hayPalillo4 = true;
            hayPalillo5 = true;
        }
        if (idFilosofo == 4){
            hayPalillo5 = true;
            hayPalillo1 = true;
        }
        System.out.printf("<<< Filosofo %d devolvio los palillos %s y %s.\n", idFilosofo, necesitaPalillo1, necesitaPalillo2);
        
        notifyAll(); // Notificar a otros filósofos que los palillos están disponibles
    }
}
