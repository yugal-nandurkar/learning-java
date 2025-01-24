package microteam;

public class EmailService implements MessageService {
    @Override
    public String getMessage() {
        return "You've got mail!";
    }
}

