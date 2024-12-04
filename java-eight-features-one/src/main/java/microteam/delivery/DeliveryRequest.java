package microteam.delivery;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class DeliveryRequest {

    @NotBlank(message = "Recipient name is required")
    private String recipientName;

    @NotBlank(message = "Address is required")
    private String address;

    @Min(value = 0, message = "Delivery fee must be non-negative")
    private double deliveryFee;

    public DeliveryRequest() {
    }

    // Getters and setters
}

