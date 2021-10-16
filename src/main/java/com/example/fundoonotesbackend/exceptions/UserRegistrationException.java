package com.example.fundoonotesbackend.exceptions;

import com.example.fundoonotesbackend.util.ErrorResponse;
import com.example.fundoonotesbackend.util.Response;
import lombok.Data;

import java.util.Locale;
@Data
public class UserRegistrationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private int StatusCode;
    private String Statusmessage;

    public UserRegistrationException(int statusCode, String statusmessage) {
        super(statusmessage);
        StatusCode = statusCode;
        Statusmessage = statusmessage;
    }

    public Response getErrorResponse() {
        return getErrorResponse(Locale.getDefault());
    }

    public Response getErrorResponse(Locale locale) {

        ErrorResponse errorResp = new ErrorResponse(StatusCode, Statusmessage, getStackTrace());
        errorResp.setStatusCode(getStatusCode());
        errorResp.setStatusMessage(getStatusmessage());

        return errorResp;
    }

}
