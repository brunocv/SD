public class Main implements Runnable{
     public void run(){
            int j = 10;
            int i = 1;
            while(i < j+1) {
                System.out.println("Thread " +  Thread.currentThread().getId() + " Num: " + i);
                i++;
            }

     }

     public static void main (String[] args) {
        int n = 5;

        Thread threads[] = new Thread[n];

        for(int i=0; i < n ; i++) threads[i] = new Thread(new Main());
        
        for(int i=0; i < n ; i++) threads[i].start();

        try {
            for(int i=0; i < n ; i++) threads[i].join();
        }
         catch(Exception e) {System.out.println(e);}
    }
}
