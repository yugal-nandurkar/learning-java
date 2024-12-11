package microteam.new_features.library;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {

    public String processTransaction(Object obj) {
        if (obj instanceof Transaction) {
            // Explicitly cast the object to Transaction
            Transaction transaction = (Transaction) obj;
            Patron patron = transaction.patron();
            Book book = transaction.book();
            String type = transaction.type();

            // Handle the transaction based on its type
            return switch (type) {
                case "borrow" -> String.format("%s borrowed \"%s\" by %s.", patron.name(), book.title(), book.author());
                case "return" -> String.format("%s returned \"%s\" by %s.", patron.name(), book.title(), book.author());
                default -> "Unknown transaction type.";
            };
        } else {
            return "Invalid transaction.";
        }
    }
}
