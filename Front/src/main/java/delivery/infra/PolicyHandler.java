package delivery.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import delivery.config.kafka.KafkaProcessor;
import delivery.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_PayForMenu(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener PayForMenu : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Order.payForMenu(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='UpdatedOrderStatus'"
    )
    public void wheneverUpdatedOrderStatus_InformToCustomerByKakao(
        @Payload UpdatedOrderStatus updatedOrderStatus
    ) {
        UpdatedOrderStatus event = updatedOrderStatus;
        System.out.println(
            "\n\n##### listener InformToCustomerByKakao : " +
            updatedOrderStatus +
            "\n\n"
        );

        // Sample Logic //
        Order.informToCustomerByKakao(event);
    }
}
