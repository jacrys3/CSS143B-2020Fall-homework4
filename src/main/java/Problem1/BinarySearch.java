package Problem1;
//start
public class BinarySearch {
    // This is to be done recursively
    // Do not change signature (return type, function name, parameter types)
    // Add a helper function for recursion calls
    public static int binarySearch(int[] data, int target) {
        return helperSearch(data, target, 0, data.length);
    }

    private static int helperSearch(int[] data, int target, int start, int end){
        if(data.length == 0 || (data.length == 1 && data[0] != target)) return -1;
        else if(data.length == 1 && data[0] == target) return 0;

        int mid = (end - start) / 2;
        if(data[mid] < target){
            end = mid;
            return helperSearch(data, target, start, end);
        } else if(data[mid] > target){
            start = mid;
            return helperSearch(data, target, start, end);
        } else{
            return mid;
        }
    }
}
