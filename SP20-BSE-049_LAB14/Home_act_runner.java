
package lab14;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Home_act_runner {
    public static void main(String[] args)
 {
try
 {
ObjectOutputStream outputStream =
new ObjectOutputStream(new FileOutputStream("D://BookStore"));

Book Object1 = new Book("harry potter" , "robert" , "bouny");
Book Object2 = new Book("harry2" , "robert" , "bouny");
Book Object3 = new Book("harry3" , "robert" , "bouny");
Book Object4 = new Book("harry4" , "robert" , "bouny");
Book Object5 = new Book("harry5" , "robert" , "bouny");
outputStream.writeObject(Object1);
outputStream.writeObject(Object2);
outputStream.writeObject(Object3);
outputStream.writeObject(Object4);
outputStream.writeObject(Object5);
     

outputStream.close(); 
System.out.println("Data sent to file.");
 }


catch(IOException e)
    

{ 
System.out.println("Problem with file output.");
 } 

 }
}





    
