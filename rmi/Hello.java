import java.rmi.Remote;
import java.rmi.RemoteException;

// Interface
public interface Hello extends Remote {
    String hello() throws RemoteException;
}
