package microteam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${spring.jms.queue.name}")
    private String queueName;

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend(queueName, message);
    }
}

