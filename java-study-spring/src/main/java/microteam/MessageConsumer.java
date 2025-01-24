package microteam;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @JmsListener(destination = "${spring.jms.queue.name}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
