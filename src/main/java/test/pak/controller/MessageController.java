package test.pak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.pak.dao.Messages;
import test.pak.service.MainService;
import test.pak.service.MessageService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import static test.pak.service.MessageService.*;

/**
 * Created by anamika on 11/7/17.
 */
@RestController
public class MessageController implements Serializable {

    private String sender_email;
    private String receiver_email;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value ="/send_message", method = RequestMethod.POST)
    public void sendMessage(@PathVariable Messages sender_email)
    {
        ArrayList<Messages> receiverList = new ArrayList<>();

        for(Messages messages: receiverList)
            receiverList.add(messages);

        messageService.saveMessage(receiverList);
    }

}
