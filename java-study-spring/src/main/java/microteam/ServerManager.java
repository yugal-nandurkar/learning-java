package microteam;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@Component
@ManagedResource(objectName = "com.example:type=ServerManager", description = "Server Manager")
public class ServerManager {

    private String serverName = "SpringServer";
    private boolean serverRunning = true;

    @ManagedAttribute(description = "The server name")
    public String getServerName() {
        return serverName;
    }

    @ManagedAttribute(description = "The server status")
    public boolean isServerRunning() {
        return serverRunning;
    }

    @ManagedOperation(description = "Start the server")
    public void startServer() {
        serverRunning = true;
        System.out.println("Server started.");
    }

    @ManagedOperation(description = "Stop the server")
    public void stopServer() {
        serverRunning = false;
        System.out.println("Server stopped.");
    }
}

