package microteam.sealed_classes.loan;

// PendingLoanRequest.java

public final class PendingLoanRequest extends LoanRequest {

    public PendingLoanRequest(String applicantName, double amount) {
        super(applicantName, amount);
    }
}

