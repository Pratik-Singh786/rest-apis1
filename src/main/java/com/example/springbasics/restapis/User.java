package com.example.springbasics.restapis;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;

//1. inversion of control :=spring will create objects
//2.Dependency injection //Autowiring

@Component //singlton
//@Scope("prototype") //spring will not create it explicitly on application startup  but at the  time of autowiring
public class  User
{
    private int id;
    private int age;
    private String name;
    private String country;
  public User()  //spring will always take
    {
        this(10,10,"pratik","India");
        System.out.println("creating user object");


    }
    public User(int id, int age, String name, String country) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId
            (int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
