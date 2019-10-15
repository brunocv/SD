public class Main extends Thread{

    public static void main(String[] args){
        
        Banco cr = new Banco();

        System.out.println("Contas no início: " + cr.contas.size());

        Cliente1 c1 = new Cliente1(cr);
        Cliente2 c2 = new Cliente2(cr);

        Thread t1= new Thread(c1);
        Thread t2= new Thread(c2);
        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch(Exception e){ System.out.println(e);}
        
        System.out.println("Contas final: "+ cr.contas.size());
        System.out.println("Valores: ");
    
        for (Conta c : cr.contas.values()) {
            System.out.println(c.consulta());
        }
    
    }
}
