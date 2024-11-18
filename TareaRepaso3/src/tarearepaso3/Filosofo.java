package tarearepaso3;

import java.util.Random;

public class Filosofo implements Runnable{
    private final RepartidorPalillos repartidorPalillos;
    private final int id;
    private final String palilloIzquierda;
    private final String palilloDerecha;
    private final Random random = new Random();

    public Filosofo(RepartidorPalillos gestorPalillos, int id, String palilloIzquierda, String palilloDerecha) {
        this.repartidorPalillos = gestorPalillos;
        this.id = id;
        this.palilloIzquierda = palilloIzquierda;
        this.palilloDerecha = palilloDerecha;
    }

    public String getPalilloIzquierda() {
        return palilloIzquierda;
    }

    public String getPalilloDerecha() {
        return palilloDerecha;
    }

    public int getId() {
        return id;
    }
    
    

    @Override
    public void run() {
        while (true) {
            try {
                pensar();
                repartidorPalillos.tomarPalillos(this.id, this.getPalilloIzquierda(), this.getPalilloDerecha());
                comer();
                repartidorPalillos.soltarPalillos(this.id, this.getPalilloIzquierda(), this.getPalilloDerecha());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void pensar() throws InterruptedException {
        System.out.printf("Filosofo %d esta pensando.\n", id);
        Thread.sleep(100 + random.nextInt(500));
    }

    private void comer() throws InterruptedException {
        System.out.printf("Filosofo %d esta comiendo.\n", id);
        Thread.sleep(100 + random.nextInt(500));
    }
}
