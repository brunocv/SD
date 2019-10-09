public class conta extends Thread{
    
    double valor;

    public conta(){
        this.valor=1000;
    }

    public synchronized void levantar(double n){
        this.valor -= n;
    }

    public synchronized void depositar(double n){
        this.valor += n;
    }

    public double consulta(){
        return this.valor;
    }
}
    

