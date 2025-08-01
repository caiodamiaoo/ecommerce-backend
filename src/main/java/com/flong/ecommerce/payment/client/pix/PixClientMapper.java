package com.flong.ecommerce.payment.client.pix;

import com.flong.ecommerce.order.Order;
import com.flong.ecommerce.payment.PaymentMethodEnum;
import com.flong.ecommerce.payment.PaymentResponseDTO;

import java.util.List;

public class PixClientMapper {

    public static PixRequest paymentRequestDtoToPixRequest(Order order) {
        List<PixRequest.Item> item = order.getOrderItem()
                .stream()
                .map(i -> PixRequest.Item.builder()
                        .amount(i.getPrice().intValue())
                        .description(i.getProduct().getDescription())
                        .quantity(i.getQuantity())
                        .build())
                .toList();

        PixRequest.Customer.Phones.HomePhone homePhone = PixRequest.Customer.Phones.HomePhone
                .builder()
                .country_code("")
                .area_code("")
                .number("")
                .build();

        PixRequest.Customer.Phones phones = PixRequest.Customer.Phones
                .builder()
                .home_phone(homePhone)
                .build();

        PixRequest.Customer customer = PixRequest.Customer
                .builder()
                .name(order.getUser().getName())
                .email(order.getUser().getEmail())
                .type("individual")
                .document("")
                .phones(phones)
                .build();

        PixRequest.Payment.Pix.AdditionalInformation additionalInformation =
                PixRequest.Payment.Pix.AdditionalInformation
                        .builder()
                        .name("order_id")
                        .value(order.getId().toString())
                        .build();

        PixRequest.Payment.Pix pix = PixRequest.Payment.Pix
                .builder()
                .expires_in("3600")
                .additional_information(List.of(additionalInformation))
                .build();

        List<PixRequest.Payment> payments =
                List.of(PixRequest.Payment
                        .builder()
                        .payment_method("pix")
                        .pix(pix)
                        .build());

        return PixRequest
                .builder()
                .items(item)
                .customer(customer)
                .payments(payments)
                .build();
    }

    public static PaymentResponseDTO pixResponseToPaymentResponseDTO(PixResponse pixResponse) {
        return new PaymentResponseDTO(
                pixResponse.amount().longValue(),
                pixResponse.status(),
                PaymentMethodEnum.PIX.name()
        );
    }
}
