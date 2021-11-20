package com.example.springbasics.restapis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.Logger.*;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
@Configuration
public class MyConfiguration
{

    private static Logger logger= LoggerFactory.getLogger(MyConfiguration.class);



//  @Scope("prtotype")  // when i do this for every api call a new object will be created for every api call because scope is prototype;
  // @Primary
  //  @Bean
    public  User getMyUser()
    {
       logger.info("some test log") ;//this will be printed only once if the scope is singleton and mulitiple objects will be created for mulitiple api call on prototype scope

      //  return new User(1,20,"Pratik","India");  //i am trying to create an object which is already been defined.
        User local_user=new User(1,20,"pratik","UK");
        logger.info("local user{}",local_user);
        return local_user;
    }

}
