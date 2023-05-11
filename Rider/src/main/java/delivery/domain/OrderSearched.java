package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderSearched extends AbstractEvent {

    private Long deliveryId;
    private Long orderId;
    private String status;

    public OrderSearched(Delivery aggregate) {
        super(aggregate);
    }

    public OrderSearched() {
        super();
    }
}
