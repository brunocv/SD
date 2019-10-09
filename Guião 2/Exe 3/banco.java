public class banco extends Thread {
    private double[] contas;

    public banco(){
        contas = new double[10];
        for (int i=0; i<10; i++) contas[i]=1000;
    }

    public synchronized void levantar(int conta, double valor){
        contas[conta] -= valor;
    }

    public synchronized void depositar(int conta,double valor){
        contas[conta] += valor;
    }
    
    public synchronized void transferir(int contaOrigem, int contaDestino, double valor){
        this.levantar(contaOrigem,valor);
        this.depositar(contaDestino,valor);
    }
    
    public double consulta(int conta){
        return this.contas[conta];
    }

}
