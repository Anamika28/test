package test.pak.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by anamika on 11/7/17.
 */
@Entity
@Table(name = "messages")
public class Messages {

    @Id
    Long id;

//    @Column(name = "email_id")
//    private String email_id;
//
//    public String getEmail_id() {
//        return email_id;
//    }
//
//    public void setEmail_id(String email_id) {
//        this.email_id = email_id;
//    }

    @Column(name = "sender_email")
    private String sender_email;

    public String getSender_email() {
        return sender_email;
    }

    public void setSender_email(String sender_email) {
        this.sender_email = sender_email;
    }

    @Column(name = "receiver_email")
    private String receiver_email;

    public String getReceiver_email() {
        return receiver_email;
    }

    public void setReceiver_email(String receiver_email) {
        this.receiver_email = receiver_email;
    }
    @Column(name = "message")
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String sender_email, String receiver_email, String message) {
        this.message = message;
    }
}
