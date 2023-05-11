package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PressedOkButton extends AbstractEvent {

    private Long deliveryId;
    private Long orderId;
    private String status;

    public PressedOkButton(Delivery aggregate) {
        super(aggregate);
    }

    public PressedOkButton() {
        super();
    }
}
