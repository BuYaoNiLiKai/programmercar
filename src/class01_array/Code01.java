package class01_array;

public class Code01 {
    public static int search(int[] nums, int target) {
        if(nums==null||nums.length==0){
            return -1;
        }
        int left =0;
        int right = nums.length-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            int val = nums[mid];
            if(val == target){
                return mid;
            }else if(val<target){
                // 在右半部分
                left= mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {

    }
}
