import java.util.Arrays; 
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class BoundedBuffer{

    int array[];
    int ocupado;
    int tamanho;
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

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

        this.lock.lock();

        while(this.ocupado == this.tamanho){
            try { 
                this.condition.await();
            } 
            catch (InterruptedException e){
                System.out.println(e);
            }
        }

        this.array[ocupado] = x;
        this.ocupado += 1;
        this.condition.signal();
        this.lock.unlock();

    }

    public int get(){
        int valor;

        this.lock.lock();

        while(this.ocupado==0){
            try { 
                this.condition.await();
            } 
            catch (InterruptedException e){
                System.out.println(e);
            }
        }

        valor = this.array[ocupado -1];
        this.array[ocupado-1]=0;
        this.ocupado -= 1;
        this.condition.signal();
        this.lock.unlock();


        return valor;
    }

}


