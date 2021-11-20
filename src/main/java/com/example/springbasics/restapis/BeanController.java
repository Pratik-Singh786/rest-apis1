package com.example.springbasics.restapis;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController
{


    ApplicationContext context;

    public  BeanController()
   {
       System.out.println("Bean controller constructor");
   }

    @Autowired
    User user;

   // @Autowired
   // User user1;



    @Autowired
    MyConfiguration config;

    @Autowired
    User getMyUser;

   private static Logger logger= LoggerFactory.getLogger(BeanController.class);

   @GetMapping("/bean/test")
    public User getMyUser()
    {

        User user = (User) context.getBean("getMyUser"); //to get the bean inside the function

        return null; //this api call is not meant for working
    }




    @GetMapping("/bean/test1")
    public User getUser()
    {
        User user= config.getMyUser(); //on every api call for MyConfiguration class getMyUser() object will be same beacuse singleton scope.
        logger.debug("user id {}",user);
        System.out.println(user);
        return user;
    }

}
