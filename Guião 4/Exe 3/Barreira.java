public class Barreira{
    
    int threads;

    public Barreira(){
        this.threads=0;
    }

    public void incrementar(){
    
        this.threads += 1;
    
    }
    
    public void esperar(){
        
        synchronized(this){
            while(this.threads < 2){
                try { 
                    this.wait();
                } 
                catch (InterruptedException e){
                    System.out.println(e);
                }
            }

            this.notifyAll();
        }
    }


}
