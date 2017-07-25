package test.pak.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.pak.dao.User;
import test.pak.service.MainService;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by anamika on 8/7/17.
 */

@RequestMapping("/api")
@RestController
public class getDetails implements Serializable {

    @Inject
    private MainService mainService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/get_users", method = RequestMethod.GET)
    public ResponseEntity getUsers()
    {
        List<User> userList =  mainService.findAllData();
        return new ResponseEntity(userList, HttpStatus.OK);
    }

    @RequestMapping(value = "/set_users", method = RequestMethod.POST)
    public ResponseEntity saveUsers(@RequestBody User userTemp) {

        String contact = userTemp.getUserCntct(); //TODo missing null checks
        int age = userTemp.getUserAge();

        if (contact.length()!=10) {
            //System.out.print("invalid contact");
            return new ResponseEntity("invalid contact", HttpStatus.BAD_REQUEST);
        }
        else if (age<0 || age>100) {
            return new ResponseEntity(new String("{\"msg\" : \"invalid age\"}"), HttpStatus.BAD_REQUEST);
        }
        /*
        else if(matchEmail(userTemp.getEmail_id()))
        {
            return new ResponseEntity("invalid email", HttpStatus.BAD_REQUEST);
        }*/
        else {
             mainService.saveUsers(userTemp, HttpStatus.OK);
             return new ResponseEntity(new String("Successfully Saved"), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/edit_users", method = RequestMethod.POST)
    public ResponseEntity editUser(@RequestBody User user)
    {
        int age = user.getUserAge();
        String contact = user.getUserCntct();

        if(age>=0 && age<=100 && contact.length()==10)
        {
            mainService.editUser(user);
            return new ResponseEntity("success", HttpStatus.OK);
        }
        else if(age<0 || age>100) {
            //System.out.print("invalid age");
            return new ResponseEntity("invalid age", HttpStatus.BAD_REQUEST);
        }
        else if(contact.length()!=10) {
            //System.out.print("invalid age");
            return new ResponseEntity("invaid age", HttpStatus.BAD_REQUEST);
        }

        mainService.editUser(user);
        return new ResponseEntity("Succesfully saved!", HttpStatus.OK);
    }
    public ResponseEntity showMessage()
    {
        return new ResponseEntity("Record not found", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity showMessage2() { //TODO improper method names
        return new ResponseEntity("user already exists", HttpStatus.BAD_REQUEST);
    }
    @RequestMapping(value = "/delete_users", method = RequestMethod.DELETE)
    public void deleteUser(@RequestBody User user)
    {
        String email = user.getEmail_id();
        //if(matchEmail(email))
        mainService.deleteUser(email);
    }

    @RequestMapping(value = "/deActivateUser", method = RequestMethod.POST)
    public void deActivate(@RequestBody User user)
    {
        String email = user.getEmail_id();
        //if (matchEmail(email))
        mainService.deActivate(email);
    }
    /*public boolean matchEmail(String Email)
    {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence)Email);
        return matcher.matches();
    }*/


    //public List<User> findByuserid(int user_id) {
        //return null;
    //}
    //Optional<List<Users>> findByuserid(int user_id);
}