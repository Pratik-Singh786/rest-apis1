package com.example.springbasics.restapis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.*;


import java.util.stream.*;
//IOC container- application context
//critical section-synchronized


import java.util.*;
@RestController     //main point where the request  reaches  rest- representational state transfer;creating object+acting as collection of APIs
public class MyController
{
    public MyController()
    {
        System.out.println("my controller constructor");
    }

    @Autowired
    User user;// spring created object

    @Autowired
   User user1; //spring created object

    @GetMapping("/user")
    public User getUser()
    {
        System.out.println(user);
        User user=new User(); // my created object
       System.out.println("user="+this.user+"second user="+user1+"local user"+user);
        return user;
    }
    //user1 and user will be same and this.user will be different



    //Get -get some information from server
    //Post- insert/post something on server
    //Put -modifying something on server
    //Delete- deleting something from server
    //Patch
    //Head
    // Spring as FrameWork:
    //1.Inversion of control  Spring will create objects instead of you
    //2.Dependency injection
    private HashMap<Integer,User> users =new  HashMap<>();
  /* @GetMapping("/get_user")
    public Map<Integer,User> getUsers()
    {
        return users;
    }

    @GetMapping("/get_user")
    public User getUser(@RequestParam("my_id") int id) //my_id is thr request parameter and int id is variable for function use case
    {
        return users.get(id);

    }*/
  @GetMapping("/get_user")   //one api instead of the two above
    public List<User>  getUsers(@RequestParam(value="my_id",required=false)Integer id)
  {
      if(id==null)
      {
          if(users.values().size()>0)
          {
              return users.values().stream().collect(Collectors.toList());
          }
          return new ArrayList<>();
      }
      return Collections.singletonList(users.get(id));

  }
  @PostMapping("/insert_user")
    public void  insertUser(@RequestParam(value="id",required=true) int id, // by default required is always true
                             @RequestParam(value = "age",required=false,defaultValue = "20") int age,
                            @RequestParam(value = "name",required = false,defaultValue ="pratik") String name,
                            @RequestParam(value="country",required=false,defaultValue="India") String country)
  {
      User user=new User(id,age,name,country);
      users.put(id,user);  // storing the data in hashMap only not in d.b
      System.out.println("successfully inserted");

  }
  @RequestMapping(value="/modify_user",method= RequestMethod.PUT)
    public void modifyUser(@RequestBody User user) throws Exception   //@RequestBody ,@PathVariable can be written inside method with variable
  {                                                                   // when writing @RequestParam inside a method varibale will be outside
      if(user==null)
      {
          throw new Exception("user object is empty");
      }
      users.put(user.getId(),user);
  }

  @DeleteMapping("/delete_user")
    public void deleteUser(@PathVariable("id")int id)

  {
     users.remove(id) ;
  }

/*  @GetMapping("/save_user")
  {
      public void saveUser(@RequestBody User user)
      {
         users.putIfAbsent(users.getId(),user);
      }
  }*/










}
