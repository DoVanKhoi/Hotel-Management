import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Write implements Runnable{
    public Holder hotel_ob;

    public Write(Holder hotel_ob) {
        this.hotel_ob = hotel_ob;
    }

    public void run() {
        try {
            FileOutputStream fout = new FileOutputStream("backup");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        } catch (Exception e) {
            System.out.println("Error in writing");
        }
    }
}
