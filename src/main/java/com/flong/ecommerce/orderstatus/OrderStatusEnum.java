package com.flong.ecommerce.orderstatus;

public enum OrderStatusEnum {

    FAILED_PAYMENT(-1, "Failed"),
    PENDING_PAYMENT(0, "Pending"),
    PROCESSING(1, "Processing"),
    SHIPPED(2, "Shipped"),
    DELIVERED(3, "Delivered"),
    CANCELED(4, "Canceled");

    private final int code;
    private final String description;

    OrderStatusEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
