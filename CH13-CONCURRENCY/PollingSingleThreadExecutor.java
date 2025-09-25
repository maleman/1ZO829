// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.concurrent.*;
import java.math.BigDecimal;
/**
 * Usamos executors services para cambiar el valor de una v
 * variable estatica y retornamos su valor con el metodo 
 * <code><T> Future<T> submit(Callable<T> task)</code>
 * 
 * Si al metodo Submit se le pasa un objeto Runnable se debe
 * declarar con el comodin, submit retornara null
 * Ej: Future<?> result = service.submit(() ->{});
 *      System.out.println(result.get()); imprime null
 * 
 */
class PollingSingleThreadExecutor {
     private static BigDecimal counter = new BigDecimal("1.0");
    
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try{
            Future<?> result = service.submit(() ->{
                for(var i = 0; i < 1_000; i++){
                    counter.add(BigDecimal.ONE);
                }
            });
            System.out.println(result.get(10, TimeUnit.SECONDS));
            
            
            Future<BigDecimal> result2 = service.submit(() ->{
                for(var i = 0; i < 1_000; i++){
                    counter = counter.multiply(new BigDecimal("1.5"));
                }
                return counter;    
            });
            System.out.println("Llegamos "+ result2.get(10, TimeUnit.SECONDS));
        }catch(TimeoutException ex){
            System.out.println("No llego a tiempo");
        }finally{
            service.shutdown();
        }


        /***
         * Una alternativa de esperar que se ejecuten los resultados sin el metodo get
         * 
         * ExecutorService service = Executors.newSingleThreadExecutor();
         * try{
         *      //agregar tareas al ejecutor
         * }finally{
         *  service.shutdown();
         * }
         * 
         * service.awaitTermination(1, TimeUnit.MINUTES);
         * 
         * //check whether all task are finished
         * if(service.isTerminated())
         *  System.out.println("Terminado!");
         * else
         *  System.out.println("al menos una tarea sigue corriendo!");
         * 
         */
    }
}