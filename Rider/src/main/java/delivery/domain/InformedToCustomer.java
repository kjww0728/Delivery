package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class InformedToCustomer extends AbstractEvent {

    private Long deliveryId;
    private Long orderId;
    private String status;

    public InformedToCustomer(Delivery aggregate) {
        super(aggregate);
    }

    public InformedToCustomer() {
        super();
    }
}
