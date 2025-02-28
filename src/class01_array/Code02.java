package class01_array;

public class Code02 {
    /*
    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。
    元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
    假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：
    更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和
    nums 的大小并不重要。返回 k。
     */
    public static int removeElement(int[] nums, int val) {
        //
        if(nums ==null||nums.length<1){
            return 0;
        }
        int left = 0 ;
        int right = nums.length-1;
        int res = 0;
        while(left<=right){
           if(nums[left]==val){
               // 交换
               int tmp = nums[right];
               nums[right] = nums[left];
               nums[left] = tmp;
               right--;
           }else{
               res++;
               left++;
           }
        }
        return res;
    }
    static void printArray(int[]arr){
      for(int i:arr){
          System.out.print(i+" ");
      }
        System.out.println();
    }
    public static void main(String[] args) {
        int[]arr ={0,1,2,2,3,0,4,2};
        printArray(arr);
        int res = removeElement(arr,2);
        printArray(arr);
        System.out.println(res  );

    }
}
