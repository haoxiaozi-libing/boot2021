package com.libing.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.Objects;

/**
 * @author lvlibing
 * @create 2021-12-19 22:36
 */
@Data
@NoArgsConstructor
public class RestultResponse<T> {
    private int status = 200;
    private String message = "success";
    private T result;

    private RestultResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestultResponse(ResponseEnum responseEnum) {
        this.status = responseEnum.getStatus();
        this.message = responseEnum.getMessage();
    }


    public static RestultResponse ok() {
        return new RestultResponse();
    }

    public static <T> RestultResponse ok(T t) {
        RestultResponse restultResponse = new RestultResponse();
        if (t != null) {
            restultResponse.setResult(t);
        }
        return restultResponse;
    }

    public static RestultResponse failed() {
        return new RestultResponse(250, "失败");
    }
}
