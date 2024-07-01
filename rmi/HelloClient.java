import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

// módulo cliente 
public class HelloClient {

    public static void main(String[] args) {
        try {
            // Obtém o registro
            Registry registry = LocateRegistry.getRegistry("localhost");
            
            // Procura o objeto remoto no registro RMI
            Hello obj = (Hello) registry.lookup("Hello");
            
            // Invoca o método remoto
            String msg = obj.hello();
            
            System.out.println("Mensagem no servidor RMI: \"" + msg + "\"");
        } catch (Exception e) {
            System.out.println("Exceção no HelloClient: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 
