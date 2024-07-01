import java.rmi.Naming;
import java.rmi.RemoteException;

public class HelloClient {
	
	static String msg = "Branco";
	
	static Hello obj = null;
	
	public static void main(String[] args) {
		try {
			obj = (Hello)Naming.lookup("rmi://localhost/Hello");
			msg = obj.hello();
			
			System.out.println("Mensagem no servidor RMI de \"" + msg + "\"");
		} catch (Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
