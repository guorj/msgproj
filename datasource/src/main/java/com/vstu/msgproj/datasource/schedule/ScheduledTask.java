package com.vstu.msgproj.datasource.schedule;

import com.vstu.msgproj.datasource.service.KafkaProducerService;
import com.vstu.msgproj.datasource.utils.DataGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduledTask {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Scheduled(fixedRate = 5000) // 每5秒发送一次
    public void scheduleFixedRateTask() {
        List<String> messages = DataGenerate.genMessage();
        for (String message : messages){
            kafkaProducerService.sendMessage(message);
            System.out.println("Sent message: " + message);
        }
        messages.clear();
    }
}