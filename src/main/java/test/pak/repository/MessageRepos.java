package test.pak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.pak.dao.Messages;

/**
 * Created by anamika on 11/7/17.
 */
public interface MessageRepos extends JpaRepository<Messages, String> {

//    @Query(value = "insert into Messages(sender_email, receiver_email, message)")
//    void sendMessage(String sender_email, String receiver_email, String message);
}
