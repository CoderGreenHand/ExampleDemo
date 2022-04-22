package com.example.bean;

public class HyFixedPersonNum {
    private int num;
    private String time;

    private String blockId;
    private String blockName;
    private int size;
    private int hour;
    private int hour_time;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getHour_time() {
        return hour_time;
    }

    public void setHour_time(int hour_time) {
        this.hour_time = hour_time;
    }




    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "insert into hy_fixed_person_num(total_num,g_date,time,block_id,size,hour,block_name)" +
                "values("+"\""+num + "\","+"\""+time + "\","+"\""+hour_time+ "\","
                + "\""+blockId + "\","+ "\""+size + "\","+"\""+ 0+  "\","+ "\""+blockName+"\");";
    }

}
