package com.example.springbasics.restapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  RestApisApplication
{
  @Autowired

	public static void main(String[] args)//after doing server.port =7000 in application.properties file when we run this  RestApisApplication
			                             //we will find that our server is now running on the port 7000
	{
		SpringApplication.run(RestApisApplication.class, args);
		System.out.println("hello!!");  //when you run this  RestApisApplication the classes that are containing @RestController spring will create
		//objects for all such classes

	}	                                // creating shared instance of  singleton bean MyController :means that singleton means only 1 object and shared means available in entire scop}

}
