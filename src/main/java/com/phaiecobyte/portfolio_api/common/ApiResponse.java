package com.phaiecobyte.portfolio_api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonPropertyOrder({"status","message","data"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T>{
    private boolean status;
    private String message;
    private T data;

    ApiResponse (boolean status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static <T> ApiResponse<T> apiSuccessRes(boolean status,String message, T data){
        return new ApiResponse<>(status,message,data);
    }

    public static <T> ApiResponse<T> apiErrorRes(boolean status, String message, T data){
        return new ApiResponse<>(status,message,null);
    }
}
