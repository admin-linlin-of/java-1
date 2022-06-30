import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author linlin
 * @create 2022-05-14 11:34
 * 1.向TreeSet中添加的数据，要求是相同类的对象
 * 2.两种排序方式：自然排序和定制排序
 * 3.自然排序中，比较两个对象是否相同的标准为：compareTo()返回0，不再是equals().
 *
 */
public class TreeSetTest {
    @Test
    public void test1(){
        TreeSet set = new TreeSet();
        //失败不能添加不同类的对象
//        set.add(123);
//        set.add(456);
//        set.add("AA");
//        set.add(new Person("Tome",12));

        //举例一：
//        set.add(34);
//        set.add(-34);
//        set.add(43);
//        set.add(11);
//        set.add(8);

        //举例二：
        set.add(new Person("Dvil",21));
        set.add(new Person("Jerry",11));
        set.add(new Person("Rake",65));
        set.add(new Person("MoDi",15));
        set.add(new Person("Summary",21));
        set.add(new Person("Summary",23));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
