import java.io.*;
import java.net.*;

public class Server
{
    public void Init()
    {
        try {
            // 1. New server
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server waiting for connection...");

            // 2. Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected !");

            // 3. Read client send data
            InputStream clientInput = clientSocket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientInput));
            String messageClient = reader.readLine();
            System.out.println("Client msg : " + messageClient);

            // 4. Send response to client
            OutputStream output = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello, client !");

            // 5. Close connections
            clientSocket.close();
            serverSocket.close();
            System.out.println("Server Closed");
        }
        catch (IOException err)
        {
            err.printStackTrace();
        }
    }
}

