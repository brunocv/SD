public class Cliente1 implements Runnable{
    private banco cr;

    public Cliente1(banco b){
        this.cr = b;
    }
    
    public void run() {
        int i = 0;
        while (i < 5) {
            cr.transferir(cr.conta1,cr.conta2,100);
            i++;
        }
    }
}
