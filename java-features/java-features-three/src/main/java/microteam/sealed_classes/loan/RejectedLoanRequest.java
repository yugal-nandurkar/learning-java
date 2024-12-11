package microteam.sealed_classes.loan;

// RejectedLoanRequest.java
public final class RejectedLoanRequest extends LoanRequest {
    private final String rejectionReason;

    public RejectedLoanRequest(String applicantName, double amount, String rejectionReason) {
        super(applicantName, amount);
        this.rejectionReason = rejectionReason;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }
}
