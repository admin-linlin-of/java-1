package com.atguigu.exer1;

/**
 * MyDate类包含
 * private成员变量year,month,day: 并为每一个属性定义getter ,setter 方法
 * @author linlin
 * @create 2022-05-14 14:35
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(){

    }
    public MyDate(int year ,int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
