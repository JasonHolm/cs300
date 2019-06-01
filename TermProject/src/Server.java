import java.net.*;
import java.io.*;
import java.util.*;

public class Server implements Runnable
{
    private ServerSocket serverSoc = null;
    private Thread thread = null;
    List list = new List();
    //private ServerThread[] clients = new ServerThread[10];
    //private int clientCount = 0;

    //public ArrayList<String> regs = new ArrayList<>();
    //public static int f = 0;
    //public static Server server = new Server();
    //public static ArrayList<String> regs = new ArrayList<String>();
    //ArrayList<ServerThread> online = new ArrayList<>();
    //public static int f = 0;

    Server(int port)
    {
        try
        {
            serverSoc = new ServerSocket((port));
            System.out.println("Server started");

            if (thread == null)
            {  thread = new Thread(this);
                thread.start();
            }

            //System.out.println("Waiting for a client ...");


        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public void run()
    {
        while (thread != null)
        {
            try
            {
                System.out.println("Waiting for a client ...");
                ServerThread st = new ServerThread(this, serverSoc.accept());
                List.online.add(st);
                st.start();
                System.out.println("Client accepted");
            }
            catch (IOException i)
            {
                System.out.println("Server accept error");
                i.printStackTrace();
            }
        }
    }


    public void startServer(int port)
    {
        try
        {
            serverSoc = new ServerSocket((port));
            System.out.println("Server started");

            if (thread == null)
            {  thread = new Thread(this);
                thread.start();
            }

            //System.out.println("Waiting for a client ...");


        }
        catch(IOException i)
        {
            i.printStackTrace();
        }
    }

    public synchronized void receiveMessage(String username, String input)
    {
        //System.out.println("3");
        if (input.equals("Over"))
        {
            //clients[findClient(ID)].send("Over");
            //remove(ID);
            //System.out.println("Goodbye Client number: ");
        }
        else
        {
            for (ServerThread st : List.online)
            {
                //System.out.println("hi");
                //System.out.println(st);
                st.sendMessage(username + ": " + input);
            }
        }
    }

    public static void main(String[] args)
    {
        //List list = new List();
        //list.readFromFile();
        Server server = new Server(5000);

        //server.startServer(5000);
        //Server.server.startServer(5000);
        //System.out.println(regs.get(0));
        //System.out.println(f);
        //Server.server.readFromFile();
        //System.out.println("Closing connection");
        //writeToFile();
    }
}
