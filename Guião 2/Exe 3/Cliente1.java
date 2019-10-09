public class Cliente1 implements Runnable{
    public banco cr;

    public Cliente1(banco b){
        this.cr = b;
    }
    public void run() {
        int i = 0;
        while (i < 5) {
                cr.transferir(0,5,100);
                i++;
        }
    }
}
