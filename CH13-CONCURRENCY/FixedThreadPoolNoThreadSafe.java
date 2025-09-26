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
    
    /**
     * La variable al no ser thread-safe entra en race-condition
     * cada hilo puede leer un valor desactualizado de la variable 
     * contador
     */
    //private int contador;

    /**
     * El atributo <code>volatile</code> garantiza que los hilos modifiquen la variable
     * una a la vez, de esta manera obtenemos un resultado consistente pero no ordenado
     */
    private volatile int contador = 0;

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
