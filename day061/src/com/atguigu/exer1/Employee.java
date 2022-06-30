package com.atguigu.exer1;

/**
 * @author linlin
 * @create 2022-05-14 14:37
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(){

    }
    public Employee(String name, int age , MyDate birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        }
//        return 0;
        throw new RuntimeException("传入的类型不一致");
    }

}
