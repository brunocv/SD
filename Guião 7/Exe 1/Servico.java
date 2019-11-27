import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Servico implements Runnable {

    private Socket cliente;
    private Banco banco;

    public Servico(Socket cliente,Banco c) {

        this.cliente = cliente;
        this.banco = c;

    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

            PrintWriter out = new PrintWriter(cliente.getOutputStream());

            while (true) {
                
                String s = in.readLine();   /** Le o que foi escrito no socket do cliente **/
                if (s==null || s.equals("Quit"))       /** Se o cliente escreveu Quit fecha-se a conexao com o cliente **/
                    break;
                servCriarConta(s,out);
                servApagarConta(s,out);
                //out.println(s);             /** Escreve no socket do cliente o que foi lido e envia para o cliente **/
                //out.flush();                /** Limpa a stream de dados **/
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
    
    public void servCriarConta(String x, PrintWriter out1){
        
        if (x.contains("criar conta")){
            try{
                float saldo=Float.parseFloat(x.substring(11,x.length()));
                int id= this.banco.createAccount(saldo);
                System.out.println("Conta Criada com ID:"+id);
                out1.println("Conta Criada com ID:" +id + " com saldo:" +saldo);
                out1.flush();
            }
            catch(Exception e){
                System.out.println("Ardeu");
                out1.println("Ardeu");
                out1.flush();
 
            }
        }


    }

    public void servApagarConta(String x, PrintWriter out1){

        if(x.contains("apagar conta")){
            try{
                int id= Integer.parseInt(x.substring(13,x.length()));
                float saldo = this.banco.closeAccount(id);
                System.out.println("Conta Apagada com ID:" + id);
                out1.println("Conta Apagada com ID:" + id + " com saldo:" +saldo);
                out1.flush();
            }
            catch(Exception e){ 
                System.out.println("Não existe a conta");
                out1.println("Não existe");
                out1.flush();
            }
        }
    }


}

