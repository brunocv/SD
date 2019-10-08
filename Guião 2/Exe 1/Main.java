public class Main{


     public static void main (String[] args) {
        int n = 5;

        Thread threads[] = new Thread[n];
        Counter teste = new Counter();
        
        for(int i=0; i < n ; i++) threads[i] = new Thread(teste);
        
        for(int i=0; i < n ; i++) threads[i].start();

        try {
            for(int i=0; i < n ; i++) threads[i].join();
        }
        catch(Exception e) {System.out.println(e);}
       
        System.out.println("Tem de dar: " + 5 * 10000);
        System.out.println("Contagem final: " + teste.contagem());
     }
}
