package microteam.sealed_classes.loan;

// LoanController.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/loan")
    public String handleLoanRequest(@RequestParam("applicantName") String applicantName,
                                    @RequestParam("amount") double amount,
                                    @RequestParam("status") String status) {

        LoanRequest loanRequest;

        switch (status.toLowerCase()) {
            case "approved":
                loanRequest = new ApprovedLoanRequest(applicantName, amount, amount * 0.9); // Example approved amount
                break;
            case "rejected":
                loanRequest = new RejectedLoanRequest(applicantName, amount, "Insufficient credit score");
                break;
            case "pending":
                loanRequest = new PendingLoanRequest(applicantName, amount);
                break;
            default:
                return "Invalid status.";
        }

        return loanService.processLoanRequest(loanRequest);
    }
}

