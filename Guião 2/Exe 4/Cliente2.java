public class Cliente2 implements Runnable{
    public banco cr;

    public Cliente2(banco b){
        this.cr = b;
    }
    public synchronized void run() {
        int i = 0;
        while (i < 5) {
                cr.levantar(0,50);
                i++;
        }
    }
}
