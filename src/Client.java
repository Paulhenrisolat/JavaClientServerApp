import java.io.*;
import java.net.*;

public class Client
{
    public void Init()
    {
        try {
            Socket socket = new Socket("localhost",1234);
            System.out.println("Connected to server !");

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("Hello server.");

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String responseServer = reader.readLine();
            System.out.println("Server response : " + responseServer);

            socket.close();
        }
        catch(IOException err)
        {
            err.printStackTrace();
        }

    }
}
