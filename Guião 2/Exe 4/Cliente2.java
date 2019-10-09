public class Cliente2 implements Runnable{

    public banco cr;

    public Cliente2(banco b){
        this.cr = b;
    }
    
    public void run() {
        int i = 0;
        while (i < 5) {
            cr.conta2.levantar(50);
            i++;
        }
    }
}
