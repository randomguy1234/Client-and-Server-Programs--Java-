import java.io.*;
import java.net.*;
import java.util.*;

public class MyServer 
{
	public static void main(String[] args) throws IOException 
	{
	    ServerSocket serverSocket= null;
	    BufferedReader in2= null;
	    
	    try 
	    {
	      serverSocket= new ServerSocket(16790);  
	      Socket clientSocket= null;
	      clientSocket= serverSocket.accept();
	      
	      PrintWriter out= new PrintWriter(clientSocket.getOutputStream(), true);
	      out.println("Hello");
	      
	      Scanner input= new Scanner(System.in);
	      in2= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	      
	      
	      while(in2!= null)
	      {
	    	  String clientText= in2.readLine();
	    	  
	    	  if (clientText.equalsIgnoreCase("bye")) 
	    		  {
	    		  out.close();
	    		  in2= null;
	    		  }
	    	  
	    	  //1st prints input from client, asks user to enter line, sends response to client
	    	  else
	    	  {  
	    	  System.out.println(clientText);
	    	  System.out.println("Enter a line for Server:");
	    	  String response= input.nextLine();
	    	  out.println(response);
	    	  }
	    	  
	      }
	      
	      clientSocket.close();
	      serverSocket.close();
	    }
	    
	    catch (IOException e) 
	    {
	        System.out.println("Error: " + e);
	        System.exit(0);
	    }
	}
}
