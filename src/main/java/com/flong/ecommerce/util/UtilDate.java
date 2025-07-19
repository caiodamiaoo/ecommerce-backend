package com.flong.ecommerce.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class UtilDate {

    private UtilDate() {
    }

    public static String formatDate(LocalDateTime date) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }
}
