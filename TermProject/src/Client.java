import java.net.*;
import java.io.*;

public class Client implements Runnable
{
    private Socket socket = null;
    private Thread thread = null;
    private ClientThread client = null;
    private BufferedReader input = null;
    //private DataInputStream input = null;
    //static BufferedWriter out = null;
    static DataOutputStream out = null;

    // constructor to put ip address and port
    public Client(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
            //start();

            // takes input from terminal
            input = new BufferedReader(new InputStreamReader(System.in));
            //input = new DataInputStream(System.in);

            // sends output to the socket
            //out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            out = new DataOutputStream(socket.getOutputStream());

            if (thread == null)
            {
                client = new ClientThread(this, socket);
                thread = new Thread(this);
                thread.start();
            }
        }
        catch(IOException i)
        {
            System.out.println("init");
            i.printStackTrace();
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        /*while (!line.equals("Over"))
        {
            try
            {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }*/

        // close the connection
    }


    public static void fromUI(String msg)
    {
        try
        {
            out.writeUTF(msg);
            out.flush();
        }
        catch(IOException ioe)
        {
            System.out.println("Sending error: " + ioe.getMessage());
            //stop();
        }
    }



    public void run()
    {
        /*
        while (thread != null)
        {

            try
            {
                System.out.println("1");
                out.writeUTF(input.readLine());
                out.flush();
            }
            catch(IOException ioe)
            {
                System.out.println("Sending error: " + ioe.getMessage());
                //stop();
            }

        }

         */
    }



    public void sendMessage(String line)
    {
        //while (UserInterface.isOpen())
        //{
        //System.out.println("6");
        line = line.concat("\n");
        UserInterface.displayMessage(line);
        //System.out.println(line);
            //try
            //{
                //out.writeUTF(line);
            //}
            //catch (IOException i)
            //{
                //i.printStackTrace();
            //}
        //}
    }

    /*
    public void start() throws IOException
    {
        input = new DataInputStream(System.in);
        out = new DataOutputStream(socket.getOutputStream());
        if (thread == null)
        {
            client = new ClientThread(this, socket);
            thread = new Thread(this);
            thread.start();
        }
    }
     */

    public static void main(String[] args)
    {
        //Server server = new Server();
        //List list = new List();
        UserInterface ui = new UserInterface();
        Client client = new Client("127.0.0.1", 5000);
        //server.writeToFile();
        //System.out.println(Server.regs.get(0));
        //System.out.println(Server.f);

        // close the connection
        /*try
        {
            client.input.close();
            out.close();
            client.socket.close();
        }
        catch(IOException i)
        {
            System.out.println("closed");
            i.printStackTrace();
        }*/
    }
}
