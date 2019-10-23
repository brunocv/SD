import java.util.Arrays; 

public class BoundedBuffer{

    int array[];
    int ocupado;
    int tamanho;

    public BoundedBuffer(int tm){
        
        this.array = new int[tm];
        Arrays.fill(this.array, 0);
        this.ocupado=0;
        this.tamanho = tm;
    }

    public synchronized void imprime(){
        
        int x = this.array.length;
        
        System.out.println("Next");
        for(int i=0; i<x; i++){
            System.out.println(this.array[i]);
        }

    }

    public void put(int x){
    
        synchronized(this){
    
            while(this.ocupado == this.tamanho){
                try { 
                    this.wait();
                } 
                catch (InterruptedException e){
                    System.out.println(e);
                }
            }

            this.array[ocupado] = x;
            this.ocupado += 1;

            this.notifyAll();
        }
        
    }

    public int get(){
        int valor;

        synchronized(this){

            while(this.ocupado==0){
                try { 
                    this.wait();
                } 
                catch (InterruptedException e){
                    System.out.println(e);
                }
            }

            valor = this.array[ocupado -1];
            this.array[ocupado-1]=0;
            this.ocupado -= 1;
        
            this.notifyAll();
            
            return valor;
        }
    }

}


