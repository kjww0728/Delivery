package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderReceived extends AbstractEvent {

    private Long storeId;
    private Long orderId;
    private Long foodId;
    private String status;

    public OrderReceived(Cooking aggregate) {
        super(aggregate);
    }

    public OrderReceived() {
        super();
    }
}
