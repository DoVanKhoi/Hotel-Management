import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("backup");
            ObjectInputStream ois = new ObjectInputStream(fin);
            Hotel.hotel_ob = (Holder) ois.readObject();
        } catch (Exception e) {
            System.out.println("No previous data");
        }

        Scanner sc = new Scanner(System.in);
        int choice, subchoice, rtype, rno;
        char wish;

        do {
            System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Choose room type :\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
                    subchoice = sc.nextInt();
                    Hotel.features(subchoice);
                    break;
                case 2:
                    System.out.println("Choose room type :\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
                    subchoice = sc.nextInt();
                    Hotel.availability(subchoice);
                    break;
                case 3:
                    System.out.println("Choose room type :\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
                    subchoice = sc.nextInt();
                    Hotel.bookroom(subchoice);
                    break;
                case 4:
                    System.out.print("Room Number -");
                    rno = sc.nextInt();
                    System.out.println("Choose room type :\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
                    rtype = sc.nextInt();
                    Hotel.order(rno - 1, rtype);
                    break;
                case 5:
                    System.out.print("Room Number -");
                    rno = sc.nextInt();
                    System.out.println("Choose room type :\n1.Luxury Double Room\n2.Deluxe Double Room\n3.Luxury Single Room\n4.Deluxe Single Room\n");
                    rtype = sc.nextInt();
                    Hotel.deallocate(rno - 1, rtype);
                    break;
            }

            System.out.println("\nContinue : (y/n)");
            wish = sc.next().charAt(0);
            if (!(wish == 'y' || wish == 'Y')) {
                Runnable write = new Write(Hotel.hotel_ob);
                Thread t = new Thread(write);
                t.start();
                break;
            }
        } while (true);
    }
}