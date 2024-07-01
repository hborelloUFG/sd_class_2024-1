import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

// Servidor 
public class HelloServer extends UnicastRemoteObject implements Hello {

    protected HelloServer() throws RemoteException {
        super();
    }

    @Override
    public String hello() throws RemoteException {
        System.out.println("Invocação do método Hello com sucesso!!!");
        return "Olá Mundo por RMI Server!";
    }

    public static void main(String[] args) {
        try {
            // Cria o registro RMI na porta padrão (1099)
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            
            // Cria uma instância do objeto remoto
            HelloServer obj = new HelloServer();
            
            // Obtém o registro
            Registry registry = LocateRegistry.getRegistry();
            
            // Associa o nome "Hello" ao objeto remoto no registro RMI
            registry.rebind("Hello", obj);
            
            System.out.println("Servidor RMI ativo!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
