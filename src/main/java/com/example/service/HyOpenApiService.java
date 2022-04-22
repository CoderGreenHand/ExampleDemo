package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.bean.HyFixedPersonNum;
import com.example.util.BackEndHttpRequest;
import com.example.util.GetBlockIdList;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HyOpenApiService {
    public static void main(String[] args) throws Exception {
        Map<String,String> blockIdArray = GetBlockIdList.getBlockIdArray();
        String hyFixedPersonNumUrl="https://scudmo.baidu.com/openapi/huiyan/openapi/v2/heatmap/rtgridnumrestore?blockId=";
        String endUrl = "&outCoordType=bd09ll&ak=dYDSY6f2XJTx5XhF2txP2TXRadHPRXGh&date=";
        ExecutorService es = Executors.newCachedThreadPool();

        String startTime="202204152000";
        String endTime = "202204152200";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        SimpleDateFormat sdf1  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date beginDate = sdf.parse(startTime);
        Date finalDate = sdf.parse(endTime);
        long finalTime = finalDate.getTime();
        long startTime1 = beginDate.getTime();
        long middleTime=startTime1;
        List<HyFixedPersonNum> hyFixedPersonNumList = new ArrayList<>();
        while (middleTime<=finalTime) {
            String time = sdf1.format(middleTime);
            int hour = Integer.parseInt(time.split(" ")[1].substring(0, 2));
            Map<String, String> header = HqHeader.headers("3f77f9d822ac429c9bca60afd09a43aa", "KACDMFJPkzQVXJj3lj855t2Zk2MuA2sL");
            for (Map.Entry<String, String> entry :
                    blockIdArray.entrySet()) {
                String url = hyFixedPersonNumUrl + entry.getKey() + endUrl + sdf.format(middleTime);
                System.err.println(url);
                String returnData = BackEndHttpRequest.sendGet(url, header);
                JSONObject resultObject = JSONObject.parseObject(returnData);
                HyFixedPersonNum hyFixedPersonNum = new HyFixedPersonNum();
                if (resultObject != null) {
                    JSONObject jsonObject = resultObject.getJSONObject("result");

                    if (jsonObject != null) {
                        //获取整个区域当前的人数total_num
                        int totalNum = Integer.parseInt(jsonObject.getString("total_num"));
                        int size = Integer.parseInt(jsonObject.getString("size"));
                        hyFixedPersonNum.setNum(totalNum);
                        hyFixedPersonNum.setBlockId(entry.getKey());
                        hyFixedPersonNum.setBlockName(entry.getValue());
                        hyFixedPersonNum.setTime(time);
                        hyFixedPersonNum.setSize(size);
                        hyFixedPersonNum.setHour_time(hour);
                    }
                }
                //Thread.sleep(2000);
                hyFixedPersonNumList.add(hyFixedPersonNum);

            }
            middleTime = middleTime + 1000 * 60 * 10;
        }

        System.out.println("---------------------------------------------------------");
        for (HyFixedPersonNum hyFixedPersonNum:
        hyFixedPersonNumList) {
            System.out.println(hyFixedPersonNum);

        }

    }
}
