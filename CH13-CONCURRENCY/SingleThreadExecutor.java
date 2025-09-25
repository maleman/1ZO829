// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.concurrent.Executors;

/**
* Executors clase de tipo Factory
* ExecutorService interfaz
* Tenemos 2 Thread:
*  1. Main
*  2. Executor -> ExecutorService -> SingleThreadExecutor
* 
* La salida de la ejecucion continua siendo inpredecible, pero hay menos variaciones
* SingleThreadExecutor las tareas son ejecutadas sequencialmente
*/
class SingleThreadExecutor {
    public static void main(String[] args) {
        
         Runnable printA = () -> {
          for(var i = 0; i < 10; i++){
              System.out.println("Print A :"+ i);
          }  
        };
        
        Runnable printB = () -> {
            for(var i = 0; i < 10; i++){
                System.out.println("Print B :"+ i);
            } 
        };
        
        var service = Executors.newSingleThreadExecutor();
        try{
            System.out.println("Inicio");
            service.execute(printA);
            service.execute(printB);
            System.out.println("Fin");
        }finally{
            /* Un Thread Ejecutor crea un Thread non-daemon en la primera tarea 
            *  que ejecuta, si no se invoca el metodo shutdown la aplicacion nunca terminara
            *
            * shutdown() no detiene ninguna tarea que ya ha sido enviada al executor 
            */
            service.shutdown();
        }
        
    }
}

/**
 * void execute(Runnable command)               Executes Runnable task at some point in future.
 * 
 * Future<?> submit(Runnable task)              Executes Runnable task at some point in future and returns Future representing task.
 * 
 * <T> Future<T> submit(Callable<T> task)       Executes Callable task at some point in future and returns Future representing pending results of task.
 * 
 * <T> T invokeAny(Collection<? extends Callable<T>> tasks)               Executes given tasks and waits for at least one to complete.
 * 
 * <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) Executes given tasks and waits for all tasks to complete. Returns List of Future instances in same order in which they were in original collection.
 */