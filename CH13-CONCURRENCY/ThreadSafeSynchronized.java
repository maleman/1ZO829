
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

public class ThreadSafeSynchronized{

    private AtomicInteger contadorAtomico = new AtomicInteger(0);

    //Ejecucion del hilo
    private void incrementarContador(){
        //System.out.print(contadorAtomico.incrementAndGet()+" ");
        //Para resolver el problema del orden debemos sincronizar la ejecucion del hilo
        //No la creacion
        synchronized(this){
            System.out.print(contadorAtomico.incrementAndGet()+" ");
        }
    }

    /*
     * Lo mismo pero usando la propiedad en el metodo (Compiler enhancement)
     * private synchronized void incrementarContador(){
     *      System.out.print(contadorAtomico.incrementAndGet()+" ");
     * }
     * 
     * La version de un metodo static
     * static void incrementarContador(){
     *  synchonized(ThreadSafeSynchronized.class){
     *      System.out.print(contadorAtomico.incrementAndGet()+" ");
     *  }
     * }
     * 
     * con el modificador
     * static synchronized void incrementarContador(){
     *  System.out.print(contadorAtomico.incrementAndGet()+" ");
     * }
     */

    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(20);

        try{
            ThreadSafeSynchronized instance = new ThreadSafeSynchronized();
            for(int i = 0; i < 20; i++){
                //Creacion del hilo
                //synchronized(instance){
                service.submit(() -> instance.incrementarContador());
                //}
            }
        }finally{
            service.shutdown();
        }
    }

}