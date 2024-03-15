package com.first_week.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;


    public static <T> Result<T> success(){
        return new Result<>(20000,"success",null);
    }
    public static <T> Result<T> success(T data){
        return new Result<>(20000,"success",data);
    }
    public static <T> Result<T> success(String msg,T data){
        return new Result<>(20000,msg,data);
    }
    public static <T> Result<T> success(String msg) {
        return new Result<>(20000,msg,null);
    }

    public static <T> Result<T> fail(){
        return new Result<>(20001,"fail",null);
    }
    public static <T> Result<T> fail(T data){
        return new Result<>(20001,"fail",data);
    }
    public static <T> Result<T> fail(String msg,T data){
        return new Result<>(20001,msg,data);
    }
    public static <T> Result<T> fail(String msg) {
        return new Result<>(20001,msg,null);
    }
}
