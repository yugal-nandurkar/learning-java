package microteam;

public class MessagePrinter {
    private MessageService service;

    // Constructor-based Dependency Injection
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(service.getMessage());
    }
}

