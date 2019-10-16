public class Cliente1 implements Runnable{
    private Banco cr;

    public Cliente1(Banco b){
        this.cr = b;
    }
    
    public void run() {
    
        for(int i=0; i<5; i++){
            System.out.println(cr.createAccount(10*(i+1)));
        }
    
        int[] array = new int[]{0,1,2,3,4}; 
        System.out.println("Saldo total: "+ cr.totalBalance(array));
        
        try{
            System.out.println("Apaguei: " + cr.closeAccount(4));
        }
        catch(InvalidAccount e){
        }

    }

}
