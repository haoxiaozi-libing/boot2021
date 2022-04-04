package com.libing.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "course")
@NoArgsConstructor
public class Course {
    private Long cid;
    private String cname;
    private Long userId;
    private String cstatus;

    public Course(String cname, Long userId, String cstatus) {
        this.cname = cname;
        this.userId = userId;
        this.cstatus = cstatus;
    }

    public Course(String cname, Long userId) {
        this.cname = cname;
        this.userId = userId;
    }

    public Course(String cname, String cstatus) {
        this.cname = cname;
        this.cstatus = cstatus;
    }
}
