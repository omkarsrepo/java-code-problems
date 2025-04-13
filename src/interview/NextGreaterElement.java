package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
https://www.geeksforgeeks.org/next-greater-element/

Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn’t exist, it is -1.

Input: arr[] = [6, 8, 0, 1, 3]
Output: [8, -1, 1, 3, -1]
Explanation: The next larger element to 6 is 8, for 8 there is no larger elements hence it is -1, for 0 it is 1 , for 1 it is 3 and then for 3 there is no larger element on right and hence -1.

Input: arr[] = [50, 40, 30, 10]
Output: [-1, -1, -1, -1]
Explanation: There is no greater element for any of the elements in the array, so all are -1.

TC, SC : O(n)
 */

public class NextGreaterElement {

    List<Integer> nextLargerElement(int[] arr) {
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for(int n: arr) {
            result.add(-1);
        }

        int n = arr.length;

        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                result.set(i, stack.peek());
            }

            stack.push(arr[i]);
        }

        return result;
    }
}
