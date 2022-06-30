import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author linlin
 * @create 2022-06-25 18:29
 */
public class 数组去重 {
//    public static void main(String[] args) {
//        Object[] nums = {1,2,2,3231,4,100};
//        List<Object>  list = new ArrayList(Arrays.asList(nums));
//        for(int i = 0 ; i < nums.length ; i++){
//            for(int j = i + 1 ; j < nums.length ; j++){
//                if(nums[i] == nums[j]){
//                    list.remove(i);
//                }
//            }
//        }
//        nums = list.toArray();
//        System.out.println(nums);
//        for(Object i : nums){
//            System.out.println(i);
//        }
//    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,2,3231,4,100};
        Set<Integer> set = new HashSet<>();
        Collections.addAll(set,nums);
        System.out.println(set);
        nums = set.toArray(new Integer[set.size()]);
        for(Integer n : nums){
            System.out.print(n);
            System.out.print("  ");
        }
    }
}
