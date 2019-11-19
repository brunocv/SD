import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Servidor{

    public static void main(String args[]){
        
        try{
            ServerSocket sSock = new ServerSocket(1234);

        while(true){
            
            Socket clSock = sSock.accept();
            
            BufferedReader in = new BufferedReader(new InputStreamReader(clSock.getInputStream()));

            PrintWriter out = new PrintWriter(clSock.getOutputStream());
/*
            While(...){
                ... = in.readLine();
                out.println(...);
                out.flush();
            }
*/
            clSock.shutdownOutput();
            clSock.shutdownInput();
            clSock.close();
        }
    
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
