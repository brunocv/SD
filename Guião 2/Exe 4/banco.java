public class banco extends Thread {
    
    public conta conta1;
    public conta conta2;
    
    public banco(conta x, conta y){
        this.conta1=x;
        this.conta2=y;
    }

    public void transferir(conta contaOrigem, conta contaDestino, double valor){
        synchronized(contaOrigem){
            synchronized(contaDestino){
                contaOrigem.levantar(valor);
                contaDestino.depositar(valor);
            }
        }
    }
    

}
