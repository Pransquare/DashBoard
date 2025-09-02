package com.pransquare.dashboard.utils;

import org.springframework.http.HttpStatus;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionUtil {

    public static void handleException(HttpServletResponse response, String message, HttpStatus status) throws IOException {
        if (!response.isCommitted()) {
            response.setStatus(status.value());
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"" + message + "\"}");
        }
    }
}
