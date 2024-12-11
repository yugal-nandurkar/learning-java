package microteam.sealed_classes.loan;

// ApprovedLoanRequest.java

public final class ApprovedLoanRequest extends LoanRequest {
    private final double approvedAmount;

    public ApprovedLoanRequest(String applicantName, double amount, double approvedAmount) {
        super(applicantName, amount);
        this.approvedAmount = approvedAmount;
    }

    public double getApprovedAmount() {
        return approvedAmount;
    }
}

