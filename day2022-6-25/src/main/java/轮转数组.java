/**
 * @author linlin
 * @create 2022-06-28 8:06
 */
public class 轮转数组 {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            int[] newArr = new int[n];
            for (int i = 0; i < n; ++i) {
                newArr[(i + k) % n] = nums[i];
            }
            System.arraycopy(newArr, 0, nums, 0, n);
        }


}
