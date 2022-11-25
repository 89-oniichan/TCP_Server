import java.util.*;
import java.io.FileOutputStream; 
import java.io.BufferedOutputStream; 
import java.net.Socket;
import java.io.InputStream;
import java.net.InetAddress;

public class Client 
{
public static void main(String[] args) throws Exception
{
//Initialization of socket
Socket socket = new Socket(InetAddress.getByName("localhost"), 5001);
byte[] contents = new byte[10000];

//Initialization of output file.
Scanner sc= new Scanner(System.in);
System.out.print("Enter the path to save the file  : \n"); 
String str= sc.nextLine(); 

//The FileOutputStream to the file's complete path
FileOutputStream fos = new FileOutputStream(str); 
BufferedOutputStream bos = new BufferedOutputStream(fos);
InputStream is = socket.getInputStream(); 

//File bytes read in one read()
int bytesRead = 0; 
while((bytesRead=is.read(contents))!=-1)
bos.write(contents, 0, bytesRead); 
bos.flush();
socket.close();
System.out.println("File received and saved"); 
}
}
