package delivery;

//package microteam.delivery;

import microteam.delivery.Delivery;
import microteam.delivery.DeliveryController;
import microteam.delivery.DeliveryRepository;
import microteam.delivery.DeliveryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DeliveryControllerTest {

    @Mock
    private DeliveryRepository deliveryRepository;

    @Mock
    private DeliveryService deliveryService;

    @InjectMocks
    private DeliveryController deliveryController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllDeliveries() {
        // Arrange
        Delivery delivery1 = new Delivery("John Doe", "123 Main St", 10.0, "Pending");
        Delivery delivery2 = new Delivery("Jane Smith", "456 Elm St", 20.0, "Completed");
        when(deliveryRepository.findAll()).thenReturn(Arrays.asList(delivery1, delivery2));

        // Act
        ResponseEntity<List<Delivery>> response = deliveryController.getAllDeliveries();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        assertEquals("John Doe", response.getBody().get(0).getRecipientName());
        verify(deliveryRepository, times(1)).findAll();
    }

    @Test
    void testGetDeliveryById_Found() {
        // Arrange
        Long deliveryId = 1L;
        Delivery delivery = new Delivery("John Doe", "123 Main St", 10.0, "Pending");
        when(deliveryRepository.findById(deliveryId)).thenReturn(Optional.of(delivery));

        // Act
        ResponseEntity<Delivery> response = deliveryController.getDeliveryById(deliveryId);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals("John Doe", response.getBody().getRecipientName());
        verify(deliveryRepository, times(1)).findById(deliveryId);
    }

    @Test
    void testGetDeliveryById_NotFound() {
        // Arrange
        Long deliveryId = 1L;
        when(deliveryRepository.findById(deliveryId)).thenReturn(Optional.empty());

        // Act & Assert
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> deliveryController.getDeliveryById(deliveryId));
        assertEquals("Delivery not found", exception.getMessage());
        verify(deliveryRepository, times(1)).findById(deliveryId);
    }

    @Test
    void testUpdateStatus() {
        // Arrange
        Long deliveryId = 1L;
        String newStatus = "Completed";
        Delivery updatedDelivery = new Delivery("John Doe", "123 Main St", 10.0, newStatus);
        when(deliveryService.updateDeliveryStatus(deliveryId, newStatus))
                .thenReturn(CompletableFuture.completedFuture(updatedDelivery));

        // Act
        CompletableFuture<ResponseEntity<Delivery>> futureResponse =
                deliveryController.updateStatus(deliveryId, newStatus);

        // Assert
        ResponseEntity<Delivery> response = futureResponse.join();
        assertEquals(200, response.getStatusCodeValue());
        assertNotNull(response.getBody());
        assertEquals(newStatus, response.getBody().getStatus());
        verify(deliveryService, times(1)).updateDeliveryStatus(deliveryId, newStatus);
    }

    @Test
    void testDeleteDelivery() {
        // Arrange
        Long deliveryId = 1L;
        doNothing().when(deliveryRepository).deleteById(deliveryId);

        // Act
        ResponseEntity<Void> response = deliveryController.deleteDelivery(deliveryId);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(deliveryRepository, times(1)).deleteById(deliveryId);
    }
}
