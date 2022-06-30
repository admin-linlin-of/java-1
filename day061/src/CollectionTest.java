import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author linlin
 * @create 2022-05-13 19:52
 * 集合框架
 *  |----Collection接口：单列集合，用来存储一个一个的对象
 *      |----list接口：存储有序的、可重复的数据。 -->"动态“数组
 *          |----ArrayList、LinkedList、Vector
 *      |----Set接口：存储无序的、不可重复的数据。 --->高中讲的集合
 *          |----HashSet、LinkedHashSet、TreeSet
 *   |----Map接口：双列集合，用来存储一对（key - value)一对的数据
 *      |----HasMap、LinkedHasMap、TreeMap、Hashtable、Properties
 *
 *      向Collection接口的实现类的对象中添加数据时obj时，要求obj所在类要重写equals().
 */
public class CollectionTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry",20);
        coll.add(p);
        coll.add(new Person("jerry",20));
        //contains(Object obj);判断当前集合中是否包含obj
        //每次contains都会去调用比较对象的equals()方法
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(p));//true
        System.out.println(coll.contains(new Person("Jerry",20)));//false
        //2。containsAll(Conllection coll1)判断形参colll1中的所有元素是否都存在于当前集合中
        Collection coll1 = Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));
    }
    @Test
    public void Test2(){
        //3.remove(Object obj):从当前集合中移除obj元素,也调用了equals方法
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jerry",20));
        boolean is = coll.remove(1234);
        System.out.println(is);
        coll.remove(new Person("jerry",20));
        System.out.println(coll);
        //4.removeAll(Collection coll1):(差集）从当前集合中移除coll1中所有的元素
        Collection coll1 = Arrays.asList(123,4567);
        coll.removeAll(coll1);
        System.out.println(coll);
    }
    @Test
    public void Test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jerry",20));
        //retainAll(Collection coll1)交集：获取当前集合和coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123,456,789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //equals(Object obj);要想返回true，需要当前集合和形参集合的元素都相同
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(new Person("jerry",20));
        System.out.println(coll.equals(coll1));

    }
    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        coll.add(new Person("jerry",20));

        //7.hashCode()返回当前对象的哈希值
        System.out.println(coll.hashCode());
        //8.集合----》数组：toArray()
        Object[] arr = coll.toArray();
        for(int i = 0 ; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        //拓展。数组-->集合,调用Arrays类的静态方法asList()
        List<String> list = Arrays.asList(new String[]{"AA","BB","CC"});
        System.out.println(list);

        List arr1 = Arrays.asList(new int[]{123,456});
        System.out.println(arr1.size());//1

        List arr2 = Arrays.asList(new Integer[]{123,456});
        System.out.println(arr2.size());//2

        //iterator()：返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试
    }
}
