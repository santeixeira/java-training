package hotel.application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hotel.models.entities.Reservation;

public class Program {
    public static void main(String[] args) throws ParseException{
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat datef = new SimpleDateFormat("dd/MM/yyyy");
        List<Reservation> list = new ArrayList<>(); 

        System.out.print("How many rooms was reserved: ");
        int numQuartos = sc.nextInt();

        try {
            for(int i=1; i<=numQuartos; i++) {
                
                System.out.println(i+"º Room");
                
                System.out.print("Which room was occupied: ");
                int roomNumber = sc.nextInt();
                
                System.out.print("Check-in date: ");
                Date checkIn = datef.parse(sc.next());
                
                System.out.print("Check-out date: ");
                Date checkOut = datef.parse(sc.next());

                System.out.print("Room Price: ");
                Double roomPrice = sc.nextDouble(); 

                if (!checkOut.after(checkIn)){
                    System.out.println("Error: Invalid Check-out date, must be after check-in date");
                    break;
                }

                else {
                    list.add(new Reservation(roomNumber, checkIn, checkOut, roomPrice));
                }
            }

            for (Reservation r : list) {

                System.out.println("Room #"+ r.getRoomNumber() +
                " Check In date: " + r.getCheckIn() +
                " Check Out date: " + r.getCheckOut());

                System.out.println("Passed " + r.duration(r.getCheckIn(),
                r.getCheckOut()) + " nights" +
                "Total Cost: " + r.count(r.getCheckIn(), r.getCheckOut()));

            }
        }

        catch (ParseException e) {
            System.out.println("Invalid date format");

        }
    
        sc.close();
    }
}