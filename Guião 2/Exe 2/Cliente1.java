public class Cliente1 implements Runnable{
    public banco cr;

    public Cliente1(banco b){
        this.cr = b;
    }
    public synchronized void run() {
        int i = 0;
        while (i < 100) {
                cr.debito(5);
                i++;
        }
    }
}
