import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * *  |----Collection接口：单列集合，用来存储一个一个的对象
 * *      |----list接口：存储有序的、可重复的数据。 -->"动态“数组
 * *          |----ArrayList：作为List接口的主要实现类；线程不安全的，效率高，底层使用Object[] elementData存储
 *                 LinkedList：对于频繁的插入、删除操作、使用此类效率比ArrayList高；底层使用双向链表存储
 *                 Vector：作为List接口的古老实现类：线程安全的，效率低，底层使用Object[] elementData存储
 *            三者的相同点：都存储有序的，可重复的数据
 *            ArrayList的源码分析：jdk 7情况下
 *              ArrayList list = new ArrayList()；//底层创建了长度是10的Object[]数组elementData
 *              list.add(123);//elementData[0] = new Integer(123);
 *              list.add(111);//如果此次添加导致底层elementData数组容器量不够，则扩容 。
 *              默认情况下，扩容为原来的容量的1.5倍，同时需要将原有数组中的数据复制到新的数组中。
 *
 *              结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int capacity)
 *
 *           jdk8中ArrayList的变化
 *              ArrayList list = new ArrayList();//底层Object[] elementData初始化为{}，并没有创建长度为10的Object数组
 *              list.add(123)；//第一次调用add()时，底层才创建了长度10的数组，并将数据123添加到elementData中
 *              后续的添加和扩容操作与Jdk7无异
 *          2。3小结：jdk7中的ArrayList的对象的创建类似于单例的饿汉式，而jdk8的ArrayList的对象
 *                      的创建类似于单例的懒汉式，延迟了数组的创建，节省内存。
 *
 *        3。LinkedList的源码分析:
 *              LinkeList list = new LinkedList();内部声明了Node类型的first和last的属性，默认值为null
 *              list.add(123);//将123封装到Node中，创建了Node对象。
 *
 *              其中，Node定义为：体现了LinkedList的双向链表的说法
 *              private static class Node<E>{
 *                  E item;
 *                  Node<E> next;
 *                  Node<E> prev;
 *
 *                  Node(Node<E> prev, E element, Node<E> next){
 *                      this.item = element;
 *                      this.next = next;
 *                      this.prev = prev;
 *                  }
 *              }
 *            4.Vector的源码分析：jDk7和JDK8 初始化时都是创建大小为10的object[]数组
 *              扩容时是原来的两倍
 * @author linlin
 * @create 2022-05-14 9:02
 */
public class ListTest {
    @Test
    public void Test1(){
        //常用方法测试
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("java",12));
        list.add(456);
        System.out.println(list);
        list.add(1,"BB");
        System.out.println(list);

        //boolean addAll(int index,Collection eles);从index位置开始将eles中的所有元素添加到集合中
        List list1 = Arrays.asList(1,2,3);
//        list.addAll(list1);
        list.add(list1);
        System.out.println(list.size());
        System.out.println(list.get(1));
    }
    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("java",12));
        list.add(456);
        //返回obj在集合中首次出现的位置，找不到为-1
        int index = list.indexOf(456);
        System.out.println(index);
        int index1 = list.lastIndexOf(456);
        System.out.println(index1);
        //Object remove(int index)移除指定index位置的元素是重载方法
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);
        //Object set(int index,Object ele):设置指定index位置元素为ele
        list.set(1,"CC");
        System.out.println(list);
        for(Object li : list){

        }
    }


}
