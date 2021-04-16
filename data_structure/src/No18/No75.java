package No18;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 */
public class No75 {

    public void sortColors(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                int temp = nums[zero];
                nums[zero] = 0;
                nums[i] = temp;
                zero++;
            }
        }

        for (int i = zero; i < nums.length ; i++) {
            if(nums[i] == 1){
                int temp = nums[zero];
                nums[zero] = 1;
                nums[i] = temp;
                zero++;
            }
        }
    }


    public void quickSort(int[] nums,int start,int end){


    }

}
