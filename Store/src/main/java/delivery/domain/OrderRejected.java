package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long storeId;
    private Long orderId;
    private Long foodId;
    private String status;

    public OrderRejected(Cooking aggregate) {
        super(aggregate);
    }

    public OrderRejected() {
        super();
    }
}
