public class Main extends Thread{

    public static void main(String[] args){

        Thread t1[] = new Thread[15];
        Thread t2[] = new Thread[15];

        RWLock cr = new RWLock();

        Cliente1 c1 = new Cliente1(cr);
        Cliente2 c2 = new Cliente2(cr);

        for(int i=0; i<15; i++){
            t1[i]= new Thread(c1);
        }
        for(int i=0; i<15; i++){
            t2[i]= new Thread(c2);
        }

        for(int i=0; i<15; i++){

            t1[i].start();
        }

        for(int i=0; i<15; i++){

            t2[i].start();
        }

        try{
            for(int i=0; i<15; i++){

                t1[i].join();
            }

            for(int i=0; i<15; i++){

                t2[i].join();
            }

        }
        catch(Exception e){ System.out.println(e);}

    }
}
