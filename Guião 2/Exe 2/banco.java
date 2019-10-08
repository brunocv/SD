public class banco extends Thread {

    private int saldo;

    public banco(){
        this.saldo=0;
    }


    public synchronized int consulta(){
        return this.saldo;
    }

    public synchronized void credito(int n){
        this.saldo -= n;
    }

    public synchronized void debito(int n){
        this.saldo += n;
    }

}
