package com.phaiecobyte.portfolio_api.exception;

import com.phaiecobyte.portfolio_api.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<Object> handleAppException(AppException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.apiErrorRes(false,ex.getMessage(),null));
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleAppException(SQLException ex){
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.apiErrorRes(false,ex.getMessage(),null));
    }
}
