import java.util.Map;
import java.util.HashMap;

public class Banco {
    
    public Map<Integer, Conta> contas;

    public Banco(){
        this.contas = new HashMap<>();
    }

    public int createAccount(float x){
        
        Conta nova = new Conta(x);
        contas.put(contas.size(),nova);
        return (contas.size() - 1);
    }
    
    public float closeAccount(int id) throws InvalidAccount{
        return 0;
    }
}
