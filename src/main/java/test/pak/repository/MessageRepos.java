package test.pak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.pak.dao.Messages;

/**
 * Created by anamika on 11/7/17.
 */
public interface MessageRepos extends JpaRepository<Messages, String> {

  @Query(value = "insert into Messages(email_id, sender_email, receiver_email, message) VALUES(:email_id, SELECT from User where email_id = :email_id AND status = true), (:sender_email, SELECT :email_id from User where status = true), (:receiver_email, SELECT :email_id from User where status = true),(:message, SELECT :email_id from User where status = true)")
  void sendMessage(String email_id, String sender_email, String receiver_email, String message);
}
