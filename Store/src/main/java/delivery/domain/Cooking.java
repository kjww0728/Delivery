package delivery.domain;

import delivery.StoreApplication;
import delivery.domain.CookDone;
import delivery.domain.OrderAccepted;
import delivery.domain.OrderReceived;
import delivery.domain.OrderRejected;
import delivery.domain.UpdatedOrderStatus;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cooking_table")
@Data
public class Cooking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;

    private Long orderId;

    private Long foodId;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderReceived orderReceived = new OrderReceived(this);
        orderReceived.publishAfterCommit();

        CookDone cookDone = new CookDone(this);
        cookDone.publishAfterCommit();

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        UpdatedOrderStatus updatedOrderStatus = new UpdatedOrderStatus(this);
        updatedOrderStatus.publishAfterCommit();
    }

    public static CookingRepository repository() {
        CookingRepository cookingRepository = StoreApplication.applicationContext.getBean(
            CookingRepository.class
        );
        return cookingRepository;
    }

    public static void updateOrderStatus(CookDone cookDone) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        UpdatedOrderStatus updatedOrderStatus = new UpdatedOrderStatus(cooking);
        updatedOrderStatus.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookDone.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            UpdatedOrderStatus updatedOrderStatus = new UpdatedOrderStatus(cooking);
            updatedOrderStatus.publishAfterCommit();

         });
        */

    }

    public static void updateOrderStatus(OrderAccepted orderAccepted) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        UpdatedOrderStatus updatedOrderStatus = new UpdatedOrderStatus(cooking);
        updatedOrderStatus.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            UpdatedOrderStatus updatedOrderStatus = new UpdatedOrderStatus(cooking);
            updatedOrderStatus.publishAfterCommit();

         });
        */

    }

    public static void receiveOrder(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        OrderReceived orderReceived = new OrderReceived(cooking);
        orderReceived.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            OrderReceived orderReceived = new OrderReceived(cooking);
            orderReceived.publishAfterCommit();

         });
        */

    }

    public static void startCook(OrderAccepted orderAccepted) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        CookDone cookDone = new CookDone(cooking);
        cookDone.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            CookDone cookDone = new CookDone(cooking);
            cookDone.publishAfterCommit();

         });
        */

    }

    public static void selectAcceptOrNot(OrderReceived orderReceived) {
        /** Example 1:  new item 
        Cooking cooking = new Cooking();
        repository().save(cooking);

        OrderAccepted orderAccepted = new OrderAccepted(cooking);
        orderAccepted.publishAfterCommit();
        OrderRejected orderRejected = new OrderRejected(cooking);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderReceived.get???()).ifPresent(cooking->{
            
            cooking // do something
            repository().save(cooking);

            OrderAccepted orderAccepted = new OrderAccepted(cooking);
            orderAccepted.publishAfterCommit();
            OrderRejected orderRejected = new OrderRejected(cooking);
            orderRejected.publishAfterCommit();

         });
        */

    }
}
