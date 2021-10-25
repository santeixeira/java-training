package hotel.models.entities;


import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private Double roomPrice;
    
    

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut, Double roomPrice) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomPrice = roomPrice;
    }


    public Integer getRoomNumber() {
        return roomNumber;
    }


    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }


    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    

    public Double getRoomPrice() {
        return roomPrice;
    }


    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }


    //long method
    public long duration(Date checkIn, Date checkOut) {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public double count(Date checkIn, Date checkOut) {
        return roomPrice*duration(checkIn, checkOut);
    }

    @Override
    public String toString() {
        return "Reservation [checkIn=" + checkIn + ", checkOut=" + checkOut + ", roomNumber=" + roomNumber + "]";
    }


    
}
