public class Main extends Thread{

    public static void main(String[] args){
        
        BoundedBuffer cr = new BoundedBuffer(10);

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
       
    }
}
