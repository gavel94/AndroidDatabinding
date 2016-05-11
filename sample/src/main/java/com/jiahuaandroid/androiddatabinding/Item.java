package com.jiahuaandroid.androiddatabinding;

/**
 * Created by jhhuang on 2016/5/11.
 * 作用：测试实体类
 */
public class Item {
    private String type;
    private String location;

    public Item(String type, String location) {
        this.type = type;
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type='" + type + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
