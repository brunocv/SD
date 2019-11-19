import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class Cliente1 implements Runnable{
    private RWLock cr;

    public Cliente1(RWLock b){
        this.cr = b;
    }
    
    public void run() {

        cr.writeLock();
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }

        cr.writeUnlock();
 

    }

}
