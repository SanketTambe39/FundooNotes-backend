package com.example.fundoonotesbackend.dto;

import com.example.fundoonotesbackend.util.Response;
import lombok.Data;

@Data
public class ResponseDTO {

    int status;
    private String message;
    private Object object;

    public ResponseDTO(int status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public ResponseDTO(String message, Object object) {
        this.message = message;
        this.object = object;
    }
}

