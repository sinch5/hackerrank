import java.lang.reflect.Array;

public class MaxArraySum {

    public static void main(String[] args) {
        int[] arr = {6768, -8906, 744, 930, -5685, -3551, -4105, 2300, -8849, -1310};
        //findCrossing(arr, 0, arr.length/2, arr.length);
        maxSubsetSum(arr);
    }

    static int maxSubsetSum(int[] arr) {
        int max[] = arr.clone();
        max[1] = Math.max(max[0], arr[1]);

        for (int i = 0; i < arr.length - 2; i++) {
            max[i + 2] =  Math.max(max[i+2], Math.max(max[i+1], Math.max(max[i], max[i] + max[i + 2])));
        }

        int maxVal = Integer.MIN_VALUE;
            for (int i = 0; i< max.length; i++) {
            if (max[i] > maxVal) {
                maxVal = max[i];
            }
        }

        return maxVal;
    }
}
