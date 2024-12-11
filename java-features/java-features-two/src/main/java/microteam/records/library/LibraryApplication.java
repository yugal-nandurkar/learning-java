package microteam.records.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApplication.class, args);
       // http://localhost:8080/transaction?patronName=John&patronId=123&bookTitle=Java+Programming&bookAuthor=John+Doe&isbn=123456789&type=borrow
    }
}

