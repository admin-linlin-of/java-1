import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linlin
 * @create 2022-05-14 10:30
 */
public class ListExer {
    /*
    区分List中remove(int index)和remove(Object obj)

     */
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    private void updateList(List list){
        list.remove(2);
        list.remove(new Integer(2));
    }
}
