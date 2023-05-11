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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookDone'"
    )
    public void wheneverCookDone_SearchOrder(@Payload CookDone cookDone) {
        CookDone event = cookDone;
        System.out.println(
            "\n\n##### listener SearchOrder : " + cookDone + "\n\n"
        );

        // Sample Logic //
        Delivery.searchOrder(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderSearched'"
    )
    public void wheneverOrderSearched_PickUpFood(
        @Payload OrderSearched orderSearched
    ) {
        OrderSearched event = orderSearched;
        System.out.println(
            "\n\n##### listener PickUpFood : " + orderSearched + "\n\n"
        );

        // Sample Logic //
        Delivery.pickUpFood(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PickedUpFood'"
    )
    public void wheneverPickedUpFood_InformToCustomer(
        @Payload PickedUpFood pickedUpFood
    ) {
        PickedUpFood event = pickedUpFood;
        System.out.println(
            "\n\n##### listener InformToCustomer : " + pickedUpFood + "\n\n"
        );

        // Sample Logic //
        Delivery.informToCustomer(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InformedToCustomer'"
    )
    public void wheneverInformedToCustomer_DeliveryDone(
        @Payload InformedToCustomer informedToCustomer
    ) {
        InformedToCustomer event = informedToCustomer;
        System.out.println(
            "\n\n##### listener DeliveryDone : " + informedToCustomer + "\n\n"
        );

        // Sample Logic //
        Delivery.deliveryDone(event);
    }
}
