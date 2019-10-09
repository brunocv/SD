public class Main extends Thread{

    public static void main(String[] args){
        conta conta1= new conta();
        conta conta2= new conta();
        banco cr = new banco(conta1,conta2);

        System.out.println("saldo conta1: " + cr.conta1.consulta());
        System.out.println("saldo conta2: " + cr.conta2.consulta());

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
        
        System.out.println("saldo final conta1: "+ conta1.consulta());
        System.out.println("saldo final conta2: "+ conta2.consulta());

    }
}
