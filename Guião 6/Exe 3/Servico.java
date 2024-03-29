import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servico implements Runnable {

    private Socket cliente;

    public Servico(Socket cliente) {

        this.cliente = cliente;

    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            PrintWriter out = new PrintWriter(cliente.getOutputStream());

            while (true) {
                String s = in.readLine();   /** Le o que foi escrito no socket do cliente **/
                System.out.println(s);      /** Faz echo para o terminal do servidor **/
                out.println(s);             /** Escreve no socket do cliente o que foi lido e envia para o cliente **/
                out.flush();                /** Limpa a stream de dados **/
                if (s.equals("Quit"))       /** Se o cliente escreveu Quit fecha-se a conexao com o cliente **/
                    break;
            }

        }catch(IOException e){
            System.out.println(e);
        }

        finally{
            try{
                cliente.shutdownOutput();  /** Fecha o lado de escrita do socket do cliente **/
                cliente.shutdownInput();   /** Fecha o lado de leitura do socket do cliente **/
                cliente.close();           /** Fecha o socket do cliente **/
            }
            catch(IOException e) { System.out.println(e);}
        }
    }
}

