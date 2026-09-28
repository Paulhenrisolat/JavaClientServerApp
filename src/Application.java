public class Application
{
    static void main(String[] args)
    {
        IO.println("Hello and welcome!");

        Thread threadServer = new Thread(() -> {
           Server server = new Server();
           server.Init();
        });

        threadServer.start();

        Client client = new Client();
        client.Init();
    }

}
