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
    CookingRepository cookingRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookDone'"
    )
    public void wheneverCookDone_UpdateOrderStatus(@Payload CookDone cookDone) {
        CookDone event = cookDone;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + cookDone + "\n\n"
        );

        // Sample Logic //
        Cooking.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_UpdateOrderStatus(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener UpdateOrderStatus : " + orderAccepted + "\n\n"
        );

        // Sample Logic //
        Cooking.updateOrderStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_ReceiveOrder(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener ReceiveOrder : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        Cooking.receiveOrder(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_StartCook(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener StartCook : " + orderAccepted + "\n\n"
        );

        // Sample Logic //
        Cooking.startCook(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderReceived'"
    )
    public void wheneverOrderReceived_SelectAcceptOrNot(
        @Payload OrderReceived orderReceived
    ) {
        OrderReceived event = orderReceived;
        System.out.println(
            "\n\n##### listener SelectAcceptOrNot : " + orderReceived + "\n\n"
        );

        // Sample Logic //
        Cooking.selectAcceptOrNot(event);
    }
}
