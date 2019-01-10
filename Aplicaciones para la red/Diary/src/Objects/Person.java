package Objects;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Person implements Serializable{
    
    private String name, address, email;
    private int age;
    private String date;
    
    public Person(String name, String address, String email, int age, String date){
        this.name = name;
        this.address = address;
        this.email = email;
        this.age = age;
        this.date = date;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public String getDate(){
        return this.date;
    }
}
