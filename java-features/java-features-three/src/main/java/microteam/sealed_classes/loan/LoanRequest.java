package microteam.sealed_classes.loan;

// LoanRequest.java

public sealed class LoanRequest permits ApprovedLoanRequest, RejectedLoanRequest, PendingLoanRequest {
    private final String applicantName;
    private final double amount;

    public LoanRequest(String applicantName, double amount) {
        this.applicantName = applicantName;
        this.amount = amount;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public double getAmount() {
        return amount;
    }
}

