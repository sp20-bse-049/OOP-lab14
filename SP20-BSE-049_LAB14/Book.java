
package lab14;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Book implements Serializable {
    public String name;
    public String pub;
    public String auth;

    public Book(String name, String pub, String auth) {
        this.name = name;
        this.pub = pub;
        this.auth = auth;
    }

    public String getName() {
        return name;
    }

    public String getPub() {
        return pub;
    }

    public String getAuth() {
        return auth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
    
    public String toString(){
        return "name : " + name + "author : " + auth + "publisher : " + pub;
    }
    
    public void readObjects(){
try{ 
 ObjectInputStream objectInputStream =
 new ObjectInputStream(new FileInputStream("BookStore"));

 while (true){
 Book objRead = (Book) objectInputStream.readObject();
 System.out.println(objRead.name);
 System.out.println(objRead.auth);
 System.out.println(objRead.pub);
   
}
 
}
catch (EOFException ex) { 
System.out.println("End of file reached.");
} 
catch (ClassNotFoundException ex) {
ex.printStackTrace();
} 
catch (FileNotFoundException ex) {
ex.printStackTrace();
} 
catch (IOException ex) {
ex.printStackTrace();
}

}

    
}
