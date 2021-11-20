package com.example.springbasics.restapis;
//import com.sun.org.slf4j.internal.Logger;
//import com.sun.org.slf4j.internal.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OtherController        //when  the obj of OtherController will be deleted the obj of  User will also be deleted
{
  private static Logger logger= LoggerFactory.getLogger(OtherController.class);

    @Autowired
    ApplicationContext context; //it stores all the beans

    public OtherController()
    {
       // System.out.println("In other controller constructor"+this);
        System.out.println("In other controller constructor"+this);//in output this object will be created first then the user api will be called.
    }
    @Autowired   //spring will inject user when otherController is created
    User user;


   // @Autowired
  //  MyConfiguration config;

    @GetMapping("other/user")
    public User getUser()
    {
        System.out.println(user);
       // User user= config.getMyUser1();   line 30,31 and 37;
        return user;
    }

    @GetMapping("/test")
    public String getTestString()
    {
        return "hello";
    }

   /* @GetMapping("/get_beans")
    public List<String> getBeans()
    {

       return Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList());
    }
    //it is modified to next api.*/


   @GetMapping("/get_beans")
    public void getBeans()
    {
       OtherController controller=(OtherController)context.getBean("OtherController");
       System.out.println(controller);
       System.out.println(controller);
        //return Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList());
    }

    @GetMapping("/other/logs")
    public  void printSomeLogs()
    {
        logger.debug("hi debug");
        logger.warn("hi warn");
        logger.trace("hi trace");
        logger.error("hi error");
        logger.info(" hi info");

    }





}
