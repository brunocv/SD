import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;


public class RWLock{
    private int writer; //Contador de writers
    private int reader; //Contador de Readers

    ReentrantLock lock;
    Condition waitWrite;
    Condition waitRead;

    public RWLock(){
        this.writer = 0;
        this.reader = 0;
        lock = new ReentrantLock();
        waitWrite = lock.newCondition();
        waitRead = lock.newCondition();
    }

    public void readLock(){
        this.lock.lock();
        while(writer>0){
            try{
                System.out.println("Estou a tentar ler");
                this.waitRead.await();
            }catch(InterruptedException e){
                System.out.println(e);
                this.lock.unlock();
            }
        }
        System.out.println("Estou a ler");
        this.reader++;
        this.lock.unlock();
    }

    public void readUnlock(){
        this.lock.lock();
        this.reader--;
        if(this.reader==0){

            System.out.println("Estou a dar unlock de ler");
            this.waitWrite.signal();
        }
        this.lock.unlock();
    }

    public void writeLock(){
        this.lock.lock();
        while(this.reader>0 || this.writer>0){
            try{

                System.out.println("Estou a tentar escrever");
                this.waitWrite.await();
            }
            catch(InterruptedException e){
                System.out.println(e);
                this.lock.unlock();
            }
        }
        
        System.out.println("Estou a escrever");
        this.writer = 1;
        this.lock.unlock();
    }

    public void writeUnlock(){
        this.lock.lock();
        System.out.println("Estou a dar unlock de escrever");
        this.writer = 0;
        this.waitRead.signalAll();
        this.waitWrite.signal();
        this.lock.unlock();
    }


}
