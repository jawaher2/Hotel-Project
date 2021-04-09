import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by lenovo on 12/07/2020.
 */
public class Bookings {
    private int bookingID;
    private int night_number;
    private String registSartDate;
    private String registEndDate;
    private double total;
    private Rooms d;
    Attachments a;
    private Customer c;
    ArrayList<Bookings>booking =new ArrayList<>();

    public Bookings(int bookingID, int night_number,
                    String registSartDate, String registEndDate,
                    int roomNumber,String type, int roomSize,double roomPrice,int attachmentNumber, String attachmentType,
                    int hours,double price
            //,String firstName, String lastName, int idCustomers, String sex, int age,
                  //  String email, int phone_number
                    ) {
        this.bookingID = bookingID;
        this.night_number= night_number;
        this.registSartDate = registSartDate;
        this.registEndDate = registEndDate;
        this.d = new Rooms(roomNumber,type,roomSize,roomPrice);
        this.a =new Attachments(attachmentNumber,attachmentType,hours,price);
     //   this.c = new Customer(firstName,lastName,idCustomers,sex,age,
      //  email,phone_number);
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public int getNight_number() {
        return night_number;
    }

    public void setNight_number(int night_number) {
        this.night_number = night_number;
    }

    public String getRegistSartDate() {
        return registSartDate;
    }

    public void setRegistSartDate(String registSartDate) {
        this.registSartDate = registSartDate;
    }

    public String getRegistEndDate() {
        return registEndDate;
    }

    public void setRegistEndDate(String registEndDate) {
        this.registEndDate = registEndDate;
    }
      public double getTotal() {
        return ((night_number*d.getRoomPrice())+a.getPrice());
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isAvailable(int room_id, String start, String end) {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate d = LocalDate.parse(start, f);
        LocalDate d2 = LocalDate.parse(end, f);
        for (Bookings b : booking
                ) {
            LocalDate bs = LocalDate.parse(b.getRegistSartDate(), f);
            LocalDate be = LocalDate.parse(b.getRegistEndDate(), f);
            if (b.d.getRoomNumber()== room_id && (d.isAfter(bs) && d.isBefore(be)
                    || d.equals(bs) || d.equals(be)))
                return false;}
            return true;

    }
    public String toString(){
        String s="Number of a booking: "+bookingID+"\nNumber of nights: "+night_number+
                "\nregist SartData: "+registSartDate+"\nregist EndData: "+registEndDate
        +d.toString()+a.toString()
                //+c.toString()
         ;

        return s;
    }


}
