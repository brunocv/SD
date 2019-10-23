public class Cliente2 implements Runnable{
    private BoundedBuffer cr;

    public Cliente2(BoundedBuffer b){
        this.cr = b;
    }
    
    public void run() {
    
        for(int i=0; i<10; i++){
            System.out.println("Tirei: " + cr.get());
            cr.imprime();
        }
    }


}
