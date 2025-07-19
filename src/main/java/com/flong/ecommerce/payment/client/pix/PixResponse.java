package com.flong.ecommerce.payment.client.pix;

import java.util.List;
import java.util.Map;

public record PixResponse(
        String id,
        String code,
        Integer amount,
        String currency,
        Boolean closed,
        List<Item> items,
        Customer customer,
        Shipping shipping,
        String status,
        String created_at,
        String updated_at,
        String closed_at,
        String ip,
        String session_id,
        Device device,
        Location location,
        List<Charge> charges,
        List<Object> checkouts
) {

    public record Item(
            String id,
            String description,
            Integer amount,
            Integer quantity,
            String status,
            String created_at,
            String updated_at
    ) {
    }

    public record Customer(
            String id,
            String name,
            String email,
            String document,
            String type,
            Boolean delinquent,
            String created_at,
            String updated_at,
            Map<String, Object> phones
    ) {
    }

    public record Shipping(
            Integer amount,
            String description,
            String recipient_name,
            String recipient_phone,
            Address address
    ) {
        public record Address(
                String city,
                String state,
                String country,
                String zip_code,
                String line_1
        ) {
        }
    }

    public record Device(String platform) {
    }

    public record Location(
            String latitude,
            String longitude
    ) {
    }

    public record Charge(
            String id,
            String code,
            String gateway_id,
            Integer amount,
            String status,
            String currency,
            String payment_method,
            String created_at,
            String updated_at,
            Customer customer,
            LastTransaction last_transaction
    ) {
        public record LastTransaction(
                String id,
                String transaction_type,
                String gateway_id,
                Integer amount,
                String status,
                Boolean success,
                String qr_code,
                String qr_code_url,
                List<AdditionalInformation> additional_information,
                String expires_at,
                String created_at,
                String updated_at,
                Map<String, Object> gateway_response,
                Map<String, Object> antifraud_response,
                Map<String, Object> metadata
        ) {
            public record AdditionalInformation(
                    String name,
                    String value
            ) {
            }
        }
    }
}
