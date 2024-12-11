package microteam.sealed_classes.loan;

// LoanService.java

import org.springframework.stereotype.Service;

@Service
public class LoanService {

    public String processLoanRequest(LoanRequest loanRequest) {
        // Pattern matching using instanceof (available from Java 17)
        if (loanRequest instanceof ApprovedLoanRequest approved) {
            return String.format("Loan for %s approved with amount %.2f.",
                    approved.getApplicantName(), approved.getApprovedAmount());
        } else if (loanRequest instanceof RejectedLoanRequest rejected) {
            return String.format("Loan for %s rejected due to: %s.",
                    rejected.getApplicantName(), rejected.getRejectionReason());
        } else if (loanRequest instanceof PendingLoanRequest) {
            return String.format("Loan for %s is pending approval.", loanRequest.getApplicantName());
        } else {
            return "Unknown loan request status.";
        }
    }
}
