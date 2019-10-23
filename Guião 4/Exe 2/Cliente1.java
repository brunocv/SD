public class Cliente1 implements Runnable{
    private BoundedBuffer cr;

    public Cliente1(BoundedBuffer b){
        this.cr = b;
    }
    
    public void run() {
 
        for(int i=0; i<10; i++){
            cr.put(i+1);
            cr.imprime();
        }

    }

}
