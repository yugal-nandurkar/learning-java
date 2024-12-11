package microteam.delivery;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Async
    public CompletableFuture<Delivery> updateDeliveryStatus(Long id, String status) {
        return CompletableFuture.supplyAsync(() -> {
            Delivery delivery = deliveryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Delivery not found"));
            delivery.setStatus(status);
            return deliveryRepository.save(delivery);
        });
    }
}
