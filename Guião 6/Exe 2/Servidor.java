import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Servidor{

    public static void main(String args[]) throws Exception{

        try{
            
            ServerSocket servidor = new ServerSocket(1234);
            System.out.println("Servidor iniciado");

            while(true){

                //método acept bloqueia conexão até que o servior receba um pedido de conexão
                Socket cliente = servidor.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

                PrintWriter out = new PrintWriter(cliente.getOutputStream());
                
                String input;
                while((input = in.readLine())!= null){
                  
                    System.out.println(input);
                    out.println(input);//mete no socket e envia para o cliente
                    out.flush();
                
                }
                   
                cliente.shutdownOutput();
                cliente.shutdownInput();
                cliente.close();
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
