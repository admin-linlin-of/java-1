/**
 * @author linlin
 * @create 2022-06-25 15:25
 */
public class 二分查询 {

    public static int search(int[] nums, int target) {
        // int[] nums = {-1,0,3,5,9,12};
        int first = 0;
        int last = nums.length;

        while(first < last){
            System.out.println("执行一次");
            int middle = first+(last - first)/2;
            if(target == nums[middle]){
                System.out.println(nums[middle]+" "+"出现在nums中并且下标为"+middle);
                return middle;
            }else if(target < nums[middle]){
                last = middle;
            }else if(target > nums[middle]){
                first = middle;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] nums, int target) {
        // 在区间[left,right)中查找元素，左闭右开
        int left = 0;
        int right = nums.length;

        // 由于是在区间[left,right)中查找
        // 当left=right时，区间[left,right)不存在
        while (left <= right) {
            // 计算中间点
            int mid = left + (right-left)/2;

            // 如果target == nums[mid]则表示已经找到，返回mid
            if (target == nums[mid]) {
                return mid;
                // 如果target < nums[mid]，表示目标值可能在左半边
            } else if (target < nums[mid]){
                // 由于是在左闭右开的区间[left,right)中查找
                // 而target < nums[mid]，因此mid不再需要考虑
                // 但nums[mid-1]还需考察，所以right = mid
                // 即在[left,mid)中继续查找 klljh
                right = mid;
                int i ;
                // 如果target > nums[mid]，表示目标值可能在右半边
            } else if (target > nums[mid]){
                // 由于是在左闭右开的区间[left,right)中查找
                // 而target > nums[mid]，因此mid不再需要考虑
                // 所以left = mid + 1,即在[mid+1,right)中继续查找
                left = mid + 1;
            }
        }

        // 未找到返回-1
        return -1;
    }
    public static void main(String[] args){
        int[] nums = {-1,0,3,5,9,12};
        search(nums,9);
        System.out.println(binarySearch(nums,9));
        searchInsert(nums,2);
    }
    public static void isBadVersion(){

    }
    public static void searchInsert(int nums[] ,int integer){
//        考虑这个插入的位置 pos\textit{pos}pos，它成立的条件为：
//        nums[pos−1]<target≤nums[pos]\textit{nums}[pos-1]<\textit{target}\le \textit{nums}[pos] nums[pos−1]<target≤nums[pos]
//        其中 nums\textit{nums}nums 代表排序数组。由于如果存在这个目标值，我们返回的索引也是 pos\textit{pos}pos，因此我们可以将两个条件合并得出最后的目标：「在一个有序数组中找第一个大于等于 target\textit{target}target 的下标」。
//        问题转化到这里，直接套用二分法即可，即不断用二分法逼近查找第一个大于等于 target\textit{target}target 的下标 。下文给出的代码是笔者习惯的二分写法，ans\textit{ans}ans 初值设置为数组长度可以省略边界条件的判断，因为存在一种情况是 target\textit{target}target 大于数组中的所有数，此时需要插入到数组长度的位置。
        int left = 0;
        int right = nums.length;
        int result = 0;
        while(left <= right){

            int mid = ((right - left) >> 1)+left;
            System.out.println("left"+left+"  "+"right"+right+"  "+"mid"+mid+" "+"result"+result);
            if(integer  <=  nums[mid]){
                result = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
            System.out.println("left"+left+"  "+"right"+right+"  "+"mid"+mid+" "+"result"+result);
        }
        System.out.println("输入"+integer+"位置在"+result);
    }

}
