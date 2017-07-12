package test.pak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import test.pak.dao.User;

import java.util.List;

/**
 * Created by anamika on 8/7/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "select u from User u")
    List<User> findAllUsers();

    @Query(value = "select u from User u where email = ?1")
    User findByEmail(String email);

    //User findByUserId(Integer userId);

    //@Query(value = "insert into Messages(sender_email, receiver_email, message)")
    //void sendMessage(String sender_email, String receiver_email, String message);

    /*@Query(value = "update User user_name = userName where email_id = emailId")
    void EditUserName(String userName, String emailId);

    @Query(value = "update User user_addr = userAddress where email_id = emailId")
    public void EditUserAddress(String userAddress, String emailId);

    @Query(value = "update User user_cntct = userCntct where email_id = emailId")
    public void EditUserCntct(Integer userCntct, String emailId);

    @Query(value = "update User password = password where email_id = emailId")
    public void EditUserPassword(String password, String emailId);

    @Query(value = "update User user_age = age where email_id = emailId")
    public void EditUserAge(Integer age, String emailId);*/

    @Query(value = "update User u SET u.userName = userName, u.userAddress = userAddress, u.userCntct = userCntct, u.password = password, u.userAge = userAge, u.status = status where u.email_id = emailId")
    void EditUser(String userName, String userAddress, Integer userAge, String password, Integer userCntct, String emailId, Boolean status);

    //userTemp.getEmail_id(), userTemp.getPassword(), userTemp.getUserAddress(), userTemp.getUserAge(), userTemp.getUserCntct(), userTemp.getUserName()

    @Query(value = "delete from User where email_id = emailId")
    void deleteUser(String emailId);

    @Query(value = "update User u SET u.status = false where u.email_id = emailId")
    void deActivateUser(String emailId);



}
