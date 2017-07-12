package test.pak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.pak.dao.Messages;
import test.pak.repository.MessageRepos;

import java.util.ArrayList;
import java.util.LinkedList;

@Service
public class MessageService {

    @Autowired
    private MessageRepos messageRepos;

    @Autowired
    private LoginService loginService;

    private test.pak.dao.User sender;


    //Messages pass = userRepository.findByEmail(sender_email);
    public void saveMessage(ArrayList<Messages> msg) {

        //LinkedList<Messages> receiverList = new LinkedList<>();

        for(Messages messages: msg) {
            messageRepos.save(messages);
        }

    }

}
