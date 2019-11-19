import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;

public class warehouse{
        

    private HashMap<String,item> stock;
    ReentrantLock l;
    Condition isEmpty;

    public warehouse (){
   
        this.stock = new HashMap<>();
        this.l = new ReentrantLock();
        this.isEmpty = this.l.newCondition();

    }

    //public void addItem(String s, );
    public void supply(String i, int q){
    
        this.stock.get(i).supply(q);  
    
    }

    public void consume(String[] items){
        
        for(int i=0; i<items.length; i++){
            System.out.println("Consumir " + items[i]);
            this.stock.get(items[i]).consume();
            System.out.println("Consumido");
        }
    }

}
