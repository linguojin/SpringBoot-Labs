package cn.iocoder.springboot.lab39.skywalkingdemo.rocketmqdemo.controller;

import cn.iocoder.springboot.lab39.skywalkingdemo.rocketmqdemo.producer.DemoProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoProducer producer;

    @GetMapping("/rocketmq")
    public String echo() {
        this.sendMessage(1);
        return "rocketmq";
    }

    public void sendMessage(Integer id) {
        producer.syncSend(id);
    }

}
