package Problem1;

public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        if(data.length == 0) return -1;
        return helperSearch(data, target, 0, data.length);
    }

    private static int helperSearch(int[] data, int target, int start, int end){
        int mid = start + (end-start)/2;

        if(start <= end) {
            if (data[mid] < target) {
                start = mid + 1;
                return helperSearch(data, target, start, end);
            } else if (data[mid] > target) {
                end = mid - 1;
                return helperSearch(data, target, start, end);
            } else {
                return mid;
            }
        }
        return -1;
    }
}
