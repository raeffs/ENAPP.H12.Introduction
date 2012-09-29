package eatme.boundary;

import eatme.boundary.dto.Chatmessage;
import eatme.control.ChatmessageFacade;
import eatme.control.UserFacade;
import eatme.entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.inject.Inject;

/**
 *
 * @author Admin
 */
@Stateful
@LocalBean
public class ChatManager {

    @Inject
    ChatmessageFacade chatmessageFacade;
    
    @Inject
    UserFacade userFacade;
    
    private final int maxMessagesSize = 20;
    private List<Chatmessage> messages;
    
    public List<Chatmessage> getNewestChatMessages(int maxNumOfMessages) {
        if(messages == null){
            updateMessageList();
        }
        List<Chatmessage> result = new ArrayList<Chatmessage>();
        result.addAll(messages.subList((messages.size() - maxNumOfMessages) < 1 ? 0 : messages.size() - maxNumOfMessages, messages.size()));
        return result;
    }

    public boolean addChatMessage(String message, int userId) {
        try{
            User user = userFacade.getUserWithId(userId);
            
            eatme.entity.Chatmessage newMessage = new eatme.entity.Chatmessage();
            newMessage.setEnteredat(new Date(System.currentTimeMillis()));
            newMessage.setMessage(message);
            newMessage.setUser(user);
            chatmessageFacade.create(newMessage);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private void updateMessageList(){
        System.out.println("Count: " + chatmessageFacade.count());
        int count = chatmessageFacade.count();
        int start = count - maxMessagesSize < 1 && count < maxMessagesSize ? 0 : count - maxMessagesSize;
        int end = count - maxMessagesSize < 1 && count < 1 ? 0 : count;
        try {
            messages = this.mapEntitiesToDtos(chatmessageFacade.findAll().subList(start, end));
        } catch (Exception e){
            messages = new ArrayList<Chatmessage>();
        }       
    }
    
    private List<Chatmessage> mapEntitiesToDtos(List<eatme.entity.Chatmessage> entities){
        List<Chatmessage> dtos = new ArrayList<Chatmessage>();
        for (eatme.entity.Chatmessage entity : entities){
            Chatmessage dto = new Chatmessage();
            dto.setEnteredat(entity.getEnteredat());
            dto.setMessage(entity.getMessage());
            dto.setUsername(entity.getUser().getUsername());
            dtos.add(dto);
        }
        return dtos;
    }
}
