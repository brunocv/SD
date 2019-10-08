public class Counter implements Runnable{
    private int i;

    public Counter(){
        this.i=0;
    }
    
    public int contagem(){
        return this.i;
    }
    
    //versão 1 (threads acedem diretamente a 'i')
    /*
    public synchronized void run(){
        int j = 0;
        while(j < 10000){
            this.i++;
            j++;
        }

     }
    */
    
    //versão 2 (threads usam increment)
    public void increment(){
        this.i++;
    }

    public synchronized void run(){
        int j = 0;
        while(j < 10000){
            increment();
            j++;
        }

     }
    

}


