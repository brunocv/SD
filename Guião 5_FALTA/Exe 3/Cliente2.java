import java.lang.Thread;
import java.util.concurrent.TimeUnit;

public class Cliente2 implements Runnable{
    private RWLock cr;

    public Cliente2(RWLock b){
        this.cr = b;
    }
    
    public void run() {

        cr.readLock();
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch(InterruptedException e){
            System.out.println(e);
        }

        cr.readUnlock();
 

    }

}
