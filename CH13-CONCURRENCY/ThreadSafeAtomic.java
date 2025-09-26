import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.*;

/**
 * Atomic classes
 * <p><code>AtomicBoolean</code>
 * 
 * <p><code>AtomicLong</code>
 * 
 * <p><code>AtomicInteger</code>
 *  
 */

public class ThreadSafeAtomic {

    /**
     * Atomic es la propiedad de una operacion que es efectuada como una
     * simple unidad de ejecucion sin interferencia de otro hilo, lo que 
     * conlleva a que ningun hilo acceda a la propiedad durante la operacion
     */
    private AtomicInteger contadorAtomico = new AtomicInteger(0);

    private void incrementarContador(){
        System.out.print(contadorAtomico.incrementAndGet()+" ");
    }

    public static void main(String... args){

        ExecutorService service = Executors.newFixedThreadPool(20);
        try{
            ThreadSafeAtomic instance = new ThreadSafeAtomic();
            for(int i = 0; i< 20; i++){
                //Se hace la operacion un hilo a la vez
                //Sin embargo el orden no esta garantizado 
                service.submit(()-> instance.incrementarContador());
            }
        }finally{
            service.shutdown();
        }
    }
    
}
