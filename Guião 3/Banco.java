import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;

public class Banco {
    
    public Map<Integer, Conta> contas;
    ReentrantLock l = new ReentrantLock();
    
    public Banco(){
        this.contas = new HashMap<>();
    }

    public int createAccount(float x){
        
        l.lock();
        
        int i=contas.size();
            
        while(contas.containsKey(i)) i++;

        Conta nova = new Conta(x);
        contas.put(i,nova);
        
        l.unlock();
        
        return (i);
    }
    
    public float closeAccount(int id) throws InvalidAccount{
        
        float saldo=0; 
        
        l.lock();

        if(this.contas.containsKey(id)) {
            saldo = this.contas.get(id).consulta();
            this.contas.remove(id);

            l.unlock();
            
            return saldo;
        }
        else{

            l.unlock();
            
            throw new InvalidAccount("Conta não existe  " + id );
        }


    }


    public float totalBalance(int accounts[]){
        
        float total=0;
       
        l.lock();

        for(int x: accounts){
            if(contas.containsKey(x))
                total += contas.get(x).consulta();
        }
        
        l.unlock();

        return total;

    }

    public void transfer(int from, int to, float amount) throws InvalidAccount, NotEnoughFunds{
           
        l.lock();

        if(this.contas.containsKey(from) && this.contas.containsKey(to)) {
         
            if( this.contas.get(from).consulta() >= amount){
                synchronized (this.contas.get(from)){
                    this.contas.get(from).levantar(amount);
                    synchronized(this.contas.get(to)){
                        this.contas.get(to).depositar(amount);
                    }
                }

                l.unlock();

            }
            else{

                l.unlock();

                throw new NotEnoughFunds("Conta não tem dinheiro suficiente");
            }

            l.unlock();
        
        }
        else{

            l.unlock();

            throw new InvalidAccount("Uma das contas não existe");
        }
    
    }

}
