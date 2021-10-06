import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of integers :");
        int n = Integer.parseInt(br.readLine());  // number of integers in the array
        int[] nums = new int[n];   // input int array
        System.out.println("Enter the intergers seperated with spaces :");
        String[] strNums = br.readLine().split(" ");   // reading string of inputs
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strNums[i]);  // parsing string to int
        }
        sortColors(nums);
    }

    public static void sortColors(int[] nums) {
        Hashtable<Integer, Integer> colorCount = new Hashtable<Integer, Integer>();
        for (int i : nums) {
            if(colorCount.containsKey(i)){
                int count = colorCount.get(i) + 1;  // update count of existing item
                colorCount.replace(i, count);  // replace key i value with count
            }
            else{
                colorCount.put(i, 1);  // new item, count is 1
            }
        }
        
        List<Integer> outputNums = new ArrayList<Integer>();
        colorCount.forEach((k, v) -> {  // for every key value pair
            for (int i = 0; i < v; i++) {   // looping v times
                outputNums.add(k);            // appending to the list
            }
        });

        System.out.println("Sorted array :");
        System.out.println(outputNums);
    }
}
