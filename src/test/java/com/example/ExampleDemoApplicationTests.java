package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ExampleDemoApplicationTests {

    @Test
    void contextLoads() {
    }
    public static  void main(String[] args) throws ParseException {
        String startTime = "202204152000";
        String endTime = "202204152200";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        SimpleDateFormat sdf1  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = sdf.parse(startTime);
        Date finalDate = sdf.parse(endTime);
        long finalTime = finalDate.getTime();
        System.out.println(beginDate);
        long startTime1 = beginDate.getTime();
        long middleTime=startTime1;
        while (middleTime<=finalTime) {
            System.out.println(sdf.format(middleTime));
            System.out.println(sdf1.format(middleTime));
             middleTime = middleTime + 1000 * 60 * 10;
        }
    }

}
