import java.util.Arrays;

class Solution921 {
    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
//        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left == right) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] leftArray = new int[mid + 1 - left];
        int[] rightArray = new int[right - mid];
        for (int i = left; i <= mid; i++) {
            leftArray[i - left] = nums[i];
        }
        for (int i = mid+1 ; i <= right; i++) {
            rightArray[i - mid - 1] = nums[i];
        }
        int numsIndex = left;
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        while (leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                nums[numsIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                nums[numsIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            numsIndex++;
        }

        while (leftArrayIndex < leftArray.length) {
            nums[numsIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            numsIndex++;
        }
        while (rightArrayIndex < rightArray.length) {
            nums[numsIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            numsIndex++;
        }
        System.out.println(Arrays.toString(leftArray));
        System.out.println(Arrays.toString(rightArray));
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int pivotIdx = partition(nums, low, high);
        quickSort(nums, low, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        int pivotIdx = (low + high) / 2;
        swap(nums, pivotIdx, high);
        int pivot = nums[high];
        int idx = low - 1;
        for (int i = low; i < high; i++) {
            if (nums[i] < pivot) {
                idx++;
                swap(nums, idx, i);
            }
        }
        idx++;
        swap(nums, idx, high);
        return idx;
    }

    private static void swap(int[] nums, int firstIdx, int secondIdx) {
        int temp = nums[firstIdx];
        nums[firstIdx] = nums[secondIdx];
        nums[secondIdx] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {6,9,3,4,2,5};
        int[] nums = {5, 1, 1, 2, 0, 0,3 ,4};
        System.out.println(Arrays.toString(sortArray(nums)));
    }
}