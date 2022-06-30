/**
 * @author linlin
 * @create 2022-06-28 7:16
 */
public class 有序数组平方 {
    public static int[] sortedSquares(int[] nums) {
        int left = nums[0];
        int right = nums[nums.length - 1];
        int[] newnums = new int[nums.length];
        for(int i=0,j=nums.length - 1,pos = nums.length - 1;i <= j;pos--){
            if(left * left > right * right){
                newnums[pos] = left * left;
                i++;
                left = nums[i];
            }else{
                newnums[pos] = right * right;
                j--;
                right = nums[j];
            }
        }
        return newnums;
    }

    public static void main(String[] args) {
        int[] n = sortedSquares(new int[]{-11,-2,0,2,5});
        for(int n1 : n){
            System.out.println(n1);
        }
    }
}
