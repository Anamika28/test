package test.pak.service;

import com.sun.jndi.cosnaming.IiopUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import test.pak.controller.getDetails;
import test.pak.dao.User;
import test.pak.repository.UserRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anamika on 10/7/17.
 */

@Service
public class MainService {

    @Inject
    private UserRepository userRepository;
    @Inject
    private getDetails details;

    public List<test.pak.dao.User> findAllData()
    {
        List<test.pak.dao.User> userList =  userRepository.findAllUsers();
        return userList;
    }

    public void saveUsers(User userTemp, HttpStatus ok) {
        User u = userRepository.findByEmail(userTemp.getEmail_id());
        if(u!= null) {
            details.showMessage2(); //TODO remove controller dependency
        }
        else if(u==null) { //TODO no need of if, can use else only
            userRepository.save(userTemp);
        }
    }

    @Transactional
    public void editUser(User user) {

        User u = userRepository.findByEmail(user.getEmail_id());
        if(u!= null) {
            userRepository.editUser(user.getUserName(), user.getUserAddress(), user.getUserAge(), user.getPassword(), user.getUserCntct(), user.getEmail_id(), user.getStatus());
        } else {
            details.showMessage();
        }

    }
    public void deleteUser(String email)
    {
        User u = userRepository.findByEmail(email);
        if(u!= null) {
            userRepository.deleteUser(email);
        }
        else
            if(u==null)
            {
                //System.out.print("user does not exist");
                details.showMessage();
            }
    }
    @Transactional
    public void deActivate(String email)
    {
        User u = userRepository.findByEmail(email);
        if(u!=null)
        {
            userRepository.deActivateUser(email);
        }
        else if(u==null)
        {
            //System.out.print("user does not exist");
            details.showMessage();
        }

    }

}
