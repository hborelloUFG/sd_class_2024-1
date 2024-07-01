import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class HelloServer extends UnicastRemoteObject implements Hello {

	public HelloServer() throws RemoteException {
		super();
	}

	@Override
	public String hello() throws RemoteException {
		System.out.println("Invocacao do metodo Hello com sucesso!!!");
		return "Ola Mundo por RMI Server!";
	}

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
			Registry reg = LocateRegistry.getRegistry("localhost");
			
			HelloServer obj = new HelloServer();
			Naming.rebind("Hello", obj);
			
			System.out.println("Servidor RMI ativo!");
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage()); 
			e.printStackTrace();
		}
	}

}
