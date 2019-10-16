import java.util.Map;
import java.util.HashMap;

public class Banco {
    
    public Map<Integer, Conta> contas;

    public Banco(){
        this.contas = new HashMap<>();
    }

    public int createAccount(float x){
        
        int i=contas.size();
        
        while(contas.containsKey(i)) i++;

        Conta nova = new Conta(x);
        contas.put(i,nova);
        return (i);
    }
    
    public float closeAccount(int id) throws InvalidAccount{
        
        if(this.contas.containsKey(id)) {
            float saldo = this.contas.get(id).consulta();
            this.contas.remove(id);
            return saldo;
        }
        
        return 0;
    }


    public float totalBalance(int accounts[]){
        
        float total=0;
        
        for(int x: accounts){
            if(contas.containsKey(x))
                total += contas.get(x).consulta();
        }
        
        return total;

    }

    public void transfer(int from, int to, float amount) throws InvalidAccount, NotEnoughFunds{
    
    }

}
