public class Conta extends Thread{
    
    float valor;

    public Conta(float x){
        this.valor=x;
    }

    public synchronized void levantar(float n){
        this.valor -= n;
    }

    public synchronized void depositar(float n){
        this.valor += n;
    }

    public synchronized float consulta(){
        return this.valor;
    }
}
    

