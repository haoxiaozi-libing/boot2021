package com.libing.redis.Scheduled;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lvlibing
 * @create 2021-09-04 22:35
 */
@Component
@EnableScheduling
public class MyScheduled {

    @Scheduled(cron = "0/15 * * * * ?")
    private void sche(){
        System.out.println("定时任务。。。。。。");
        List
    }


}
