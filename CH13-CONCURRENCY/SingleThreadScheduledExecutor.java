
import java.util.concurrent.*;


/**
 * Metodos ScheduledExecutorService
 * 
 * <T> ScheduledFuture<T> schedule(Callable<V> callable, long delay, TimeUnit unit)
 *      Crea y ejecuta una tarea Callable despues de un delay dado
 * 
 * <T> ScheduledFuture<T> schedule(Runnable command, long delay, TimeUnit unit)
 *      Crea y ejecuta una tarea Runnable despues de un delay dado
 * 
 * <T> ScheduledFuture<T> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
 *      Crea y ejecuta una tarea Runnable despues de un delay dado, creando una nueva tarea cada periodo dado
 * 
 * <T> ScheduledFuture<T> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)
 *      Crea y ejecuta una tarea Runnable despues de un delay dado y subsecuente mente crea una nueva tarea cuando 
 *      se cumple el periodo dado por el parametro delay
 */

public class SingleThreadScheduledExecutor {

    private static int contador;

     public static void main(String[] args){
        //System.out.println("Try programiz.pro");
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        try{
            Runnable task1 = () -> System.out.println("Tarea Runnable");
            
            Callable<String> task2 = () -> "Tarea Callable";
            
            /*
             * Ejecutara la tarea con un delay de 10 segundos
             */
            ScheduledFuture<?>r1 = service.schedule(task1, 1, TimeUnit.SECONDS);

            /*
             * Ejecutara la tarea con un delay de 30 segundos
             */
            
            ScheduledFuture<?>r2 = service.schedule(task2, 10, TimeUnit.SECONDS);

            /**
             * scheduleAtFixedRate
             * Ejecuta una tarea despues de un delay inicial 20 seg, 
             * creando una nueva tarea cada vez que se cumple el periodo 
             * suministrado via parametro period (cada 2 seg)
             */
            service.scheduleAtFixedRate(() ->{
                contador++;
                System.out.println("scheduleAtFixedRate : "+contador);
            }, 20, 2, TimeUnit.SECONDS);

            /**
             * scheduleWithFixedDelay
             * Ejecuta una tarea despues de un delay inicial 20 seg, 
             * creando una nueva despues de finalizar la anterior y
             * cumpliendose el periodo proporcionado como parametro
             * delay (cada 2 seg)
             */
            
            service.scheduleWithFixedDelay(() ->{
                contador++;
                System.out.println("scheduleWithFixedDelay : "+contador);
            }, 30, 2, TimeUnit.SECONDS);
            
            try{
                System.out.println(r2.get());
                service.awaitTermination(1, TimeUnit.MINUTES);
                if(service.isTerminated())
                    System.out.println("Todas las tareas terminaron!");
                else
                    System.out.println("No todas las tareas terminaron");
            }catch(Exception ex){}
        }finally{
            service.shutdown();
        }
    }
}
