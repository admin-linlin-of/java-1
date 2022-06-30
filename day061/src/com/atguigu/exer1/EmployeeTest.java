package com.atguigu.exer1;

import org.testng.annotations.Test;

import java.util.*;

/**
 * @author linlin
 * @create 2022-05-14 14:40
 * 创建该类的5个对象，并把这些对象放入TreeSet集合中（下一章：TreeSet需要使用泛型来定义）
 * 分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 * 1）使用Employee实现Comparable接口，并按name排序
 * 2）创建TreeSet时传入Comparator对象，按生日日期的先后排序
 */
public class EmployeeTest {
    //问题一：使用自然排序
    @Test
    public void test1(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    int minusYears = b1.getYear() - b2.getYear();
                    if(minusYears != 0){
                        return minusYears;
                    }
                    int minusMonth = b1.getMonth() - b2.getMonth();
                    if(minusMonth != 0){
                        return minusMonth;
                    }
                    return b1.getDay() - b2.getDay();
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });
        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("li",55,new MyDate(1966,5,4));
        Employee e3 = new Employee("li2",55,new MyDate(1967,6,4));
        Employee e4 = new Employee("li3",55,new MyDate(1968,5,4));
        Employee e5 = new Employee("li4",55,new MyDate(1968,5,5));
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        set.forEach(o -> System.out.println(o));
    }
    //去掉List中的重复数据
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for(Object integer : list2){
            System.out.println(integer);
        }
    }
    public static List duplicateList(List list){
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
    @Test
    public void test3(){
        HashSet set = new HashSet();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);
//        [Person{id=1002, name='BB'}, Person{id=1001, name='AA'}]
        p1.setName("CC");//虽然改变了值，但仍是在AA计算出hashcode的位置
        set.remove(p1);//删除时根跟"CC"计算hashcode寻找数据中对应位置，所以没能删除通过AA计算出位置的p1
        System.out.println(set);
        set.add(new Person(1001,"CC"));//计算出CC对应的hashCode所在的位置
        System.out.println(set);
        set.add(new Person(1001,"AA"));//equals双不一样了所以加上了
        System.out.println(set);
    }
//    [Person{id=1002, name='BB'}, Person{id=1001, name='CC'}]
//    [Person{id=1002, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='CC'}]
//    [Person{id=1002, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='CC'}, Person{id=1001, name='AA'}]
    @Test
    public void test5(){
        Map map = new HashMap();
        map.put("AA",123);
        map.put(45,1233);
        map.put("BB",56);
        //遍历所有的key集：keySet()
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();
        //遍历所有的value集：values();
        Collection values = map.values();
        for(Object obj : values){
            System.out.println(obj);
        }
        //遍历所有的key-value
        //entrySet();
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
        //方式二
        Set keySet = map.keySet();
        Iterator iterator2 = set.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
        }
    }
    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序、定制排序
    @Test
    public void test11(){
        Person p1 = new Person(11,"div");
        Person p2 = new Person(12,"miv");
        Person p3 = new Person(32,"sucmmerv");
        Person p4 = new Person(55,"linux");

        TreeMap map = new TreeMap();
        map.put(p1,98);
        map.put(p2,88);
        map.put(p3,78);
        map.put(p4,8);

        Set entrySet = map.entrySet();
        Iterator iterator3 = entrySet.iterator();
        while(iterator3.hasNext()){
            Object obj = iterator3.next();
            Map.Entry entry = (Map.Entry) obj;
            System.out.println(entry.getKey()+"----->"+entry.getValue());
        }
    }

}






















