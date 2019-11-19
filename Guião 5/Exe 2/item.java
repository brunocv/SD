import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class item{
    
    ReentrantLock l;
    Condition isEmpty;
    int quantity;
    
    public item(int q){
        
        this.l = new ReentrantLock();
        this.isEmpty = this.l.newCondition();
        this.quantity = q;
    
    }

    public void supply(int x){
        
        this.l.lock();
        this.quantity += x;
        this.isEmpty.signalAll();
        this.l.unlock();

    }

    public void consume(){

        this.l.lock();
            
        while(this.quantity <= 0){
            try {
                this.isEmpty.await();
            }
            catch (InterruptedException e){
                System.out.println(e);
                this.l.unlock();    
            }
        }

        this.quantity--;
        this.isEmpty.signal();        
        this.l.unlock();
    }

}
