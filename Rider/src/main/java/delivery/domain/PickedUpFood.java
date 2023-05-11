package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PickedUpFood extends AbstractEvent {

    private Long deliveryId;
    private Long orderId;
    private String status;

    public PickedUpFood(Delivery aggregate) {
        super(aggregate);
    }

    public PickedUpFood() {
        super();
    }
}
