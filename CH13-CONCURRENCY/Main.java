// Online Java Compiler
// Use this editor to write, compile and run your Java code online
/**
 * Concurrencia Resultado es conocido solo 
 * en tiempo de ejecucion
 * 
 * Hay 3 hilos ejecutandose de manera asincrona
 * El metdo Manin no espera el resultado de 
 * la ejecucion de los nuevos hilos para 
 * continuar
 * 
 * Threads:
 *  1. Main
 *  2. new Thread(printA)
 *  3. new Thread(printB)
 * 
 */
class Main {
    public static void main(String[] args) {
        Runnable printA = () -> {
          for(var i = 0; i < 10; i++){
              System.out.println("Print A :"+ i);
          }  
        };
        
        Runnable printB = () -> {
            try{
                for(var i = 0; i < 10; i++){
                    System.out.println("Print B :"+ i);
                    Thread.sleep(1000);
                } 
            }catch(InterruptedException e){}
           
        };
        
        System.out.println("Inicio");
        new Thread(printA).start();
        var job = new Thread(printB);
        /*Una aplicación Java finaliza cuando los únicos hilos que están en ejecución son hilos daemon. 
         * Ej GarbageCollector.
        */
        //job.setDaemon(true);
        job.start();
        /*El metodo Run de la clase thread 
        * NO INICIA UN NUEVO HILO
        * se ejecutara sobre Main
        * comentar hilos y descomentar run
        * para ver el efecto
        */
        //new Thread(printB).run();
        System.out.println("Fin");
        
    }
}