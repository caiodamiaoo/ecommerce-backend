package com.flong.ecommerce.payment.client.pix;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PixRequest {

    private List<Item> items;
    private Customer customer;
    private List<Payment> payments;

    @Data
    @Builder
    public static class Item {
        private Integer amount;
        private String description;
        private Integer quantity;
    }

    @Data
    @Builder
    public static class Customer {
        private String name;
        private String email;
        private String type;
        private String document;
        private Phones phones;

        @Builder
        @Data
        public static class Phones {
            private HomePhone home_phone;

            @Data
            @Builder
            public static class HomePhone {
                private String country_code;
                private String number;
                private String area_code;
            }
        }
    }

    @Data
    @Builder
    public static class Payment {
        private String payment_method;
        private Pix pix;

        @Data
        @Builder
        public static class Pix {
            private String expires_in;
            private List<AdditionalInformation> additional_information;

            @Builder
            @Data
            public static class AdditionalInformation {
                private String name;
                private String value;
            }
        }
    }
}
