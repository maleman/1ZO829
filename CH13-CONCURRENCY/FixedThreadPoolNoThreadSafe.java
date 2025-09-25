import java.util.concurrent.*;

/**
 * Executors Factory Method
 * 
 * <p><code>ExecutorService newSingleThreadExecutor()</code>
 *  Crea un ejecutor de un solo thread que opera en una cola sin limite, 
 *  los resultados son procesados de manera secuencial en el orden 
 *  que son enviados.
 * 
 * <p><code>ScheduledExecutorService newSingleThreadScheduledExecutor()</code>
 *   Crea un ejecutor de un solo thread que puede ser agendado para 
 *  correr con dado delay o para ejecutarse de manera periodica
 * 
 * <p><code>ExecutorService newCachedThreadPool()</code>
 *  Crea un pool de Thread, que crea un nuevo thread cuando es necesario
 *  y reutiliza los thread previamente construidos cunado estan disponibles
 * 
 * <p><code>ExecutorService newFixedThreadPool(int)</code>
 *  Crea un pool de Thread, que reutiliza un numero fijo de thread
 *  operando con una cola ilimitada
 * 
 * <p><code>ScheduledExecutorService newScheduledThreadPool(int)</code>
 *  Crea un pool de Thread, que puede ser agendado para ejecutarse con
 *  un delay dado o para ejecucion periodica
 */

public class FixedThreadPoolNoThreadSafe {
    
    private int contador;

    private void incrementarContador(){
        System.out.print((++contador)+" ");
    }

    public static void main(String... args){

        ExecutorService service = Executors.newFixedThreadPool(20);
        try{
            FixedThreadPoolNoThreadSafe inst = new FixedThreadPoolNoThreadSafe();
            for(int i=0; i<10; i++){
                service.submit(() -> inst.incrementarContador());
            }

        }finally{
            service.shutdown();
        }
    }
}
