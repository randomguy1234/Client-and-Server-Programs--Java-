import java.io.*;
import java.net.*;
import java.util.*;

public class MyClient 
{
	public static void main(String[] args) throws IOException 
	{
	    Socket clientSocket= null;
	    BufferedReader in= null;
	    int ip;
	    Scanner input2= new Scanner(System.in);
	    
	    
	    try
	    {
	      ip= 16790; 
	      InetAddress host= InetAddress.getByName("localhost");
	      clientSocket= new Socket(host, ip);
	      
	      in= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	      PrintWriter out2= new PrintWriter(clientSocket.getOutputStream(), true);
	      String serverText= in.readLine();
	      	   
	      
	      while(serverText!= null)
	      {
	    	  System.out.println(serverText);
	    	  System.out.println("Enter a line for Client or bye to quit:");
	    	  String response2= input2.nextLine();
	    	  //1st get input from server, then user types response
	    	  
	    	  //sends response to server, then takes input from server
	    	  out2.println(response2);
	    	  serverText= in.readLine();
	    	  if(response2.equalsIgnoreCase("bye"))
	    	  {
	    		  out2.close();
	    		  serverText= null;
	    	  }
	    	  
	      }
	      
	    }
	    
	    catch (IOException e) 
	    {
	        System.out.println("Error: " + e);
	        System.exit(0);
	    }
	
	}
}
