package delivery.domain;

import delivery.RiderApplication;
import delivery.domain.InformedToCustomer;
import delivery.domain.OrderSearched;
import delivery.domain.PickedUpFood;
import delivery.domain.PressedOkButton;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Delivery_table")
@Data
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deliveryId;

    private Long orderId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderSearched orderSearched = new OrderSearched(this);
        orderSearched.publishAfterCommit();

        PickedUpFood pickedUpFood = new PickedUpFood(this);
        pickedUpFood.publishAfterCommit();

        InformedToCustomer informedToCustomer = new InformedToCustomer(this);
        informedToCustomer.publishAfterCommit();

        PressedOkButton pressedOkButton = new PressedOkButton(this);
        pressedOkButton.publishAfterCommit();
    }

    public static DeliveryRepository repository() {
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(
            DeliveryRepository.class
        );
        return deliveryRepository;
    }

    public static void searchOrder(CookDone cookDone) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        OrderSearched orderSearched = new OrderSearched(delivery);
        orderSearched.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookDone.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            OrderSearched orderSearched = new OrderSearched(delivery);
            orderSearched.publishAfterCommit();

         });
        */

    }

    public static void pickUpFood(OrderSearched orderSearched) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        PickedUpFood pickedUpFood = new PickedUpFood(delivery);
        pickedUpFood.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderSearched.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            PickedUpFood pickedUpFood = new PickedUpFood(delivery);
            pickedUpFood.publishAfterCommit();

         });
        */

    }

    public static void informToCustomer(PickedUpFood pickedUpFood) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        InformedToCustomer informedToCustomer = new InformedToCustomer(delivery);
        informedToCustomer.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(pickedUpFood.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            InformedToCustomer informedToCustomer = new InformedToCustomer(delivery);
            informedToCustomer.publishAfterCommit();

         });
        */

    }

    public static void deliveryDone(InformedToCustomer informedToCustomer) {
        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        PressedOkButton pressedOkButton = new PressedOkButton(delivery);
        pressedOkButton.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(informedToCustomer.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);

            PressedOkButton pressedOkButton = new PressedOkButton(delivery);
            pressedOkButton.publishAfterCommit();

         });
        */

    }
}
