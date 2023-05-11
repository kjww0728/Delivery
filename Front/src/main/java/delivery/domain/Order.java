package delivery.domain;

import delivery.FrontApplication;
import delivery.domain.OrderCanceled;
import delivery.domain.OrderPlaced;
import delivery.domain.PaidForMenu;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    private Long foodId;

    private Long price;

    private String status;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        PaidForMenu paidForMenu = new PaidForMenu(this);
        paidForMenu.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {
        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void payForMenu(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        PaidForMenu paidForMenu = new PaidForMenu(order);
        paidForMenu.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            PaidForMenu paidForMenu = new PaidForMenu(order);
            paidForMenu.publishAfterCommit();

         });
        */

    }

    public static void informToCustomerByKakao(
        UpdatedOrderStatus updatedOrderStatus
    ) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(updatedOrderStatus.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
