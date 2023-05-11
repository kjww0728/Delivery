package delivery.domain;

import delivery.domain.*;
import delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PaidForMenu extends AbstractEvent {

    private Long orderId;
    private Long foodId;
    private Long price;
    private String status;

    public PaidForMenu(Order aggregate) {
        super(aggregate);
    }

    public PaidForMenu() {
        super();
    }
}