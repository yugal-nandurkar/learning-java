package microteam.new_features.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/transaction")
    public String handleTransaction(
            @RequestParam("patronName") String patronName,
            @RequestParam("patronId") int patronId,
            @RequestParam("bookTitle") String bookTitle,
            @RequestParam("bookAuthor") String bookAuthor,
            @RequestParam("isbn") String isbn,
            @RequestParam("type") String type) {

        // Create the Book and Patron records
        Book book = new Book(bookTitle, bookAuthor, isbn);
        Patron patron = new Patron(patronName, patronId);

        // Create the Transaction record
        Transaction transaction = new Transaction(patron, book, type);

        // Process the transaction and return the result
        return libraryService.processTransaction(transaction);
    }
}
