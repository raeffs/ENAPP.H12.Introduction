package eatme.jsf;

import eatme.boundary.ChatManager;
import eatme.boundary.dto.Chatmessage;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Admin
 */
@Named(value = "chatViewModel")
@SessionScoped
public class ChatViewModel implements Serializable {
    
    @Inject
    private ChatManager chatManager;
    
    private List<Chatmessage> messages;
    
    private long timestamp;

    public List<Chatmessage> getMessages() {
        if (messages == null || (System.currentTimeMillis() - timestamp) > 1000){
            messages = chatManager.getNewestChatMessages(10);
            timestamp = System.currentTimeMillis();
        }
        return messages;
    }
    
}
