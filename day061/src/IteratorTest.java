import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author linlin
 * @create 2022-05-13 21:02
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1。内部的方法：hasNext()和next()
 * 2。集合对象每次调用Iterator()方法都得到一个全新的迭代器对象。
 *      默认游标都在集合的第一个元素之前。
 * 3。内部定义了remove()，可以在遍历的时候，删除集合中的元素。此方法不同于集合直接调用remove()
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        //NoSuchElementException
//        System.out.println(iterator.next());
        //方式二: 不推荐
//        for(int i = 0; i < coll.size(); i++){
//            System.out.println(iterator.next());
//        }
        //方式三：推荐
        while(iterator.hasNext()){
            //next()指针下移 将下移以后的元素返回
            System.out.println(iterator.next());
        }
        //错误方式二
        //集合对象每次调用iterator()方法者得到一个全新的迭代器对象，默认游标都在集合的第一个对象里
//        while(coll.iterator().hasNext()){
//            System.out.println(coll.iterator().next());
//        }//死循环
    }
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test//练习题
    public void test4(){
        String[] arr = new String[]{"MM","MM","MM"};
        //方式一：普通 for赋值
        for(int i = 0; i < arr.length;i++){
            arr[i] = "GG";
        }
        //方式二，增强for循环 实际是new出的一个新的对象不会影响原值
        for(String s : arr){
            s = "GG";
        }
    }

}
