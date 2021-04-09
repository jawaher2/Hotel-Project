
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by lenovo on 12/13/2020.
 */
public class Collection {
    ArrayList<Bookings> booking ;
    ArrayList<Rooms> roomses = new ArrayList<>();
    CircularyLinkedList<Customer> customers = new CircularyLinkedList<>();
    ArrayList<Attachments> attachmentses = new ArrayList<>();
    Connection c;
    PreparedStatement s;
    ResultSet rs;
    int num = 0;

    public Collection() {
        booking = new ArrayList<>();
        try {
            c = DriverManager.getConnection("jdbc:ucanaccess://G:\\bookingSystem.accdb");


        } catch (SQLException e) {
            e.printStackTrace();
        }


        fillcustomer();

    }

    public void fillroom() {
        try {
            Statement st;
            st = c.createStatement();
            rs = st.executeQuery("select * from room");
            while (rs.next()) {
                Rooms x = new Rooms(rs.getInt("room_no")
                        , rs.getString("type"), rs.getInt("room_size"), rs.getDouble("price"));
                roomses.add(x);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillattachment() {
        try {
            Statement st;
            st = c.createStatement();
            rs = st.executeQuery("select * from attachments");
            while (rs.next()) {
                Attachments x = new Attachments(rs.getInt("attentant_number")
                        , rs.getString("attentant_type"), rs.getInt("number_hour"),rs.getInt("hour_price"));
                attachmentses.add(x);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void fillcustomer() {
        try {
            Statement st = c.createStatement();
            rs = st.executeQuery("select * from customer");
            while (rs.next()) {
                Customer x = new Customer(rs.getString("f_name"), rs.getString("l_name"),
                        rs.getInt("id_customer"), rs.getString("sex"), rs.getInt("age"),
                        rs.getString("e_mail"), rs.getInt("ph_no"));
                customers.addLast(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addcustomer(String firstName, String lastName, int idcustomers, String sex,
                            int age, String email, int phone_number) {

        customers.addLast(new Customer(firstName, lastName,
                idcustomers, sex, age, email, phone_number));
        try {
            s = c.prepareStatement("insert into customer values('" + firstName + "','"
                    + lastName + "'," + idcustomers + ",'" + sex + "'," + age + ",'" + email + "'," + phone_number + ")");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


  public void viewcustomer() {
          int n=customers.size();
      for (int i = 0; i <n ; i++) {
          System.out.println(customers.First());
          customers.rotate();
      }
        }


   public Customer searchcustomer(int idcustomers) {

       for (Customer c : customers
               ) {
           if (c.getIdcustomers() == idcustomers){
                try {
                    s = this.c.prepareStatement("select * from customer where  id_customer=" + idcustomers + " ");

                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return c;

            } else customers.rotate();
        }
        return null;

    }

    public boolean deletcustomer(int idcustomers) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdcustomers() == idcustomers) {

                try {
                    s = c.prepareStatement("Delete from customer where  id_customer=" + idcustomers + " ");

                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                customers.removeFirst();
                return true;
            }
        }
        return false;
    }

    public boolean editcustomer(String firstName, String lastName, int idcustomers, String sex, int age, String email,
                                int phone_number) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdcustomers() == idcustomers){
                customers.First().setFirstName(firstName);
                customers.First().setLastName(lastName);
                customers.First().setSex(sex);
                customers.First().setAge(age);
                customers.First().setEmail(email);
                customers.First().setPhone_number(phone_number);
                try {
                    s = c.prepareStatement("update customer set f_name='" + firstName + "',l_name='" + lastName + "',sex='" + sex + "',age=" + age + ",e_mail='" + email + "',ph_no=" + phone_number + " where id_customer=" + idcustomers + " ");
                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return true;
            }
        }
        return false;
    }

    public void addrooms(int roomNumber, String type, int roomSize, double roomPrice) {

        roomses.add(new Rooms(roomNumber, type, roomSize, roomPrice));
        try {
            this.s = c.prepareStatement("insert into room values(" + roomNumber + ",'"
                    + type + "'," + roomSize + "," + roomPrice + ")");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String viewrooms1() {
        return roomses.toString();
    }

    public void viewrooms() {
        for (Rooms c : roomses
                ) {
            System.out.println(c);
        }
    }

    public Rooms searchrooms(int roomNumber) {
        for (Rooms c : roomses
                ) {
            if (c.getRoomNumber() == roomNumber)
                try {
                    s = this.c.prepareStatement("select * room where  room_no=" + roomNumber + " ");

                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            return c;
        }
        return null;
    }

    public boolean deletrooms(int roomNumber) {
        for (int i = 0; i < roomses.size(); i++) {
            if (roomses.get(i).getRoomNumber() == roomNumber) {
                try {
                    s = c.prepareStatement("Delete from room where room_no=" + roomNumber + " ");

                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                roomses.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editrooms(int roomNumber, String type, int roomSize, double roomPrice) {
        for (int i = 0; i < roomses.size(); i++) {
            if (roomses.get(i).getRoomNumber() == roomNumber) {
                roomses.get(i).setType(type);
                roomses.get(i).setRoomSize(roomSize);
                roomses.get(i).setRoomPrice(roomPrice);
                try {
                    s = c.prepareStatement("update room set type='" + type + "',room_size=" + roomSize + ",price=" + roomPrice + " where room_no=" + roomNumber + " ");
                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return true;
            }
        }
        return false;
    }

    public void addattachments(int attachmentNumber, String attachmentType,int hours,double price) {

        attachmentses.add(new Attachments(attachmentNumber, attachmentType,hours, price));
        try {
            s = c.prepareStatement("insert into attachments values(" + attachmentNumber + ",'"
                    + attachmentType + "',"+hours+"," + price + ")");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String viewattachments1() {
        return attachmentses.toString();
    }

    public void viewattachments() {
        for (Attachments c : attachmentses
                ) {
            System.out.println(c);
        }
    }

    public Attachments searchattachments(int attachmentNumber) {
        for (Attachments c : attachmentses
                ) {
            if (c.getAttachmentNumber() == attachmentNumber)
                try {
                    s = this.c.prepareStatement("select * attachments where  attentant_number=" + attachmentNumber + " ");

                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            return c;
        }
        return null;
    }

    public boolean deletattachments(int attachmentNumber) {
        for (int i = 0; i < attachmentses.size(); i++) {
            if (attachmentses.get(i).getAttachmentNumber() == attachmentNumber) {
                try {
                    s = c.prepareStatement("Delete from attachments where attentant_number=" + attachmentNumber + " ");

                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                attachmentses.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean editattachments(int attachmentNumber,
                                   String attachmentType,int hours , double price) {
        for (int i = 0; i < attachmentses.size(); i++) {
            if (attachmentses.get(i).getAttachmentNumber() == attachmentNumber) {
                attachmentses.get(i).setAttachmentType(attachmentType);
                attachmentses.get(i).setHours(hours);
                attachmentses.get(i).setPrice(price);
                try {
                    s = c.prepareStatement("update attachments set attentant_type='" + attachmentType + "',number_hour=" + hours + ",hour_price="+price+" where attentant_number=" + attachmentNumber + " ");
                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                return true;
            }
        }
        return false;
    }
    public void addbookings(int bookingID, int night_number,
                            String registSartDate, String registEndDate,
                            int roomNumber,String type, int roomSize,double roomPrice,int attachmentNumber, String attachmentType,
                            int hours,double price
            //,String firstName, String lastName, int idCustomers, String sex, int age,
                           // String email, int phone_number
                             ) {

        booking.add(new Bookings(bookingID, night_number, registSartDate, registEndDate,
                roomNumber, type, roomSize, roomPrice, attachmentNumber, attachmentType,
                hours, price
                //,firstName,lastName,idCustomers,sex, age,
                //email,phone_number
        ));
       /* try {
            s =c.prepareStatement("insert into booking values("+bookingID+","+night_number+",'"+registSartDate+"','"+registEndDate+"',"+roomNumber+",'"+type+"',"+roomSize+","+roomPrice+","+attachmentNumber+",'"+attachmentType+"',"+hours+","+price+"," +
                    "'"+firstName+"','"+lastName+"',"+idCustomers+",'"+sex+"',"+age+",'"+email+"',"+phone_number+")");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try {
            s = c.prepareStatement("insert into bookings values(" + bookingID + "," + night_number + ",'" + registSartDate + "','" + registEndDate + "'," + roomNumber + ",'" + type + "'," + roomSize + "," + roomPrice + "," + attachmentNumber + ",'" + attachmentType + "'," + hours + "," + price + ")");
            s.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

       public String viewbookings1() {
        return booking.toString();
    }

    public void viewbookings() {
        for (Bookings c : booking
                ) {
            System.out.println(c);
        }
    }

    public Bookings searchbookings(int bookingID) {
        for (Bookings c : booking
                ) {
            if (c.getBookingID() == bookingID)
                try {
                    s = this.c.prepareStatement("select * booking where  booking_number=" + bookingID + " ");

                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            return c;
        }
        return null;
    }

    public boolean deletbookings(int bookingID) {
        for (int i = 0; i < booking.size(); i++) {
            if (booking.get(i).getBookingID() == bookingID) {
                try {
                    s = c.prepareStatement("Delete from booking where booking_number=" + bookingID + " ");

                    s.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                booking.remove(i);
                return true;
            }
        }
        return false;
    }


}


