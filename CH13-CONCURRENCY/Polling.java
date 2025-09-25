// Online Java Compiler
// Use this editor to write, compile and run your Java code online

/**
 * Polling es el proceso de verificar datos de manera intermitente en algún intervalo fijo.
 */

class Polling {
    
    private static int counter = 0;
    
    public static void main(String[] args) {
        final var mainThread = Thread.currentThread();
        new Thread(() ->{
           for(var i = 0; i < 1_000_000; i++){
               counter ++;
           }
           mainThread.interrupt();
        }).start();
        
        while(counter < 1_000_000){
            System.out.println("No ha llegado ");
            try{
                Thread.sleep(10);
            }catch(InterruptedException ex){
                System.out.println("Main interrunpido");
            }    
        }
        
        System.out.println("Llegamos "+ counter);
    }
}