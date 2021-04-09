import javax.swing.*;

/**
 * Created by lenovo on 12/07/2020.
 */
public class Customer extends Person{
   private int idCustomers;
    private String sex;
    private int age;
    private String email;
    private  int phone_number;


    public Customer(String firstName, String lastName,int idCustomers,int idcustomers,String sex, int age, String email, int phone_number) {
        super(firstName, lastName);
        this.idCustomers = idcustomers;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.phone_number = phone_number;
            }

    public Customer(String firstName, String lastName, int idCustomers, String sex, int age,
                    String email, int phone_number) {
        super(firstName, lastName);
        this.idCustomers = idCustomers;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getIdcustomers() {
        return idCustomers;
    }

    public void setIdcustomers(int idcustomers) {
        this.idCustomers = idcustomers;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }


       public String toString() {
        String s = "\nID customer: "+idCustomers+super.toString()+"\nAge: "+ age+ "\nSex: " + sex +"\nEmail: " +email+
                                    "\nphone_number: "+phone_number;
        return s;
    }


}


