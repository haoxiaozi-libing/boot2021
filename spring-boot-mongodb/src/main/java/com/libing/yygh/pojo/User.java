package com.libing.yygh.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @author lvlibing
 * @create 2021-08-22 20:37
 */
@Data
@Document("User")
public class User {

    @Id
    private String id;
    private String name;
    private Integer age;
    private String email;
    private String createDate;
}
