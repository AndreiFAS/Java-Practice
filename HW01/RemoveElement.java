
public class RemoveElement{

    public static void main(String[] args) {
        int[] arr = { 3,2,2,3 };
        printArray(arr);
        removeElement(arr, 3);
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 0;
            } else {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}