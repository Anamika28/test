package test.pak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.pak.dao.User;
import test.pak.service.MainService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by anamika on 8/7/17.
 */

@RequestMapping("/api")
@RestController
public class getDetails implements Serializable {

    @Autowired
    //private UserRepository userRepository;
    private MainService mainService;

    @RequestMapping(value = "/get_users", method = RequestMethod.GET)
    public List<User> getUsers()
    {
        List<User> userList =  mainService.findAllData();
        return userList;
    }

    @RequestMapping(value = "/set_users", method = RequestMethod.POST)
    public void saveUsers(@RequestBody User userTemp) {
        mainService.saveUsers(userTemp);
    }

    @RequestMapping(value = "/edit_users", method = RequestMethod.POST)
    public void editUser(@RequestBody User user)
    {
        mainService.editUser(user);
    }

    @RequestMapping(value = "/delete_users", method = RequestMethod.POST)
    public void deleteUser(@RequestBody User user)
    {
        mainService.deleteUser(user);
    }

    //public List<User> findByuserid(int user_id) {
        //return null;
    //}
    //Optional<List<Users>> findByuserid(int user_id);
}