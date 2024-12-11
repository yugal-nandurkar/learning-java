package microteam.sealed_classes.loan;

// LoanApplication.java

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoanApplication.class, args);
//        /loan?applicantName=John&amount=10000&status=approved
//        /loan?applicantName=Jane&amount=5000&status=rejected
//        /loan?applicantName=Sam&amount=2000&status=pending
    }
}

