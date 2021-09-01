import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class Demo {
    public static void main(String[] args) {
        Person person = new Person("name", 19);
        try {
            FileOutputStream fos = new FileOutputStream(new File("infor.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Person object = null;
        try {
            FileInputStream fis = new FileInputStream(new File("infor.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = (Person)ois.readObject();
            ois.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        object.show();
        
    }
}
