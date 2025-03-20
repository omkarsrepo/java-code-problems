import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Basics {
    private static boolean Anagram(String x, String y) {
        if(x.length() != y.length()) {
            return false;
        }

        int[] chars = new int[256];

        for(int i = 0; i < x.length(); i++) {
            chars[x.charAt(i) - 'a']++;
            chars[y.charAt(i) - 'a']--;
        }

        for(int j : chars) {
            if(j != 0) {
                return false;
            }
        }

        return true;
    }

    private static boolean isArmstrong(int num) {
        int m = num, n = num;
        int totalDigits = 0, sum = 0;

        while(m != 0) {
            totalDigits++;
            m = m / 10;
        }

        while(n != 0) {
            int digit = n % 10;
            sum = sum + (int) Math.pow(digit, totalDigits);
            n = n / 10;
        }

        return sum == num;
    }

    private static double degToFar(double degrees) {
        return ((degrees * 9) / 5) + 32;
    }

    private static double farToDeg(double far) {
        return ((far - 32) * 5) / 9;
    }

    private static int fibonacciSeriesRecursive(int num) {
        if(num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }

        return (fibonacciSeriesRecursive(num - 1) + fibonacciSeriesRecursive(num - 2));
    }

    private static int fibonacciSeries(int n) {
        int result = 0, firstNum = 0, secondNum = 1;

        for(int i = 0; i < n; i++) {
            if(i <= 1) {
                result = i;
            } else {
                result = firstNum + secondNum;
                firstNum = secondNum;
                secondNum = result;
            }
        }

        return result;
    }

    private static int getGcd(int n, int m) {
        int max = Math.max(n, m);

        for(int i = max; i > 1; i--) {
            if(n % i == 0 && m % i == 0) {
                return i;
            }
        }

        return 1;
    }

    private static int getLcm(int n, int m) {
        return (n / getGcd(n, m)) * m;
    }

    private static int getMaxOccurrencesInArray(int[] arr, int max) {
        int[] occurrences = new int[max + 1];

        for(int i = 0; i < arr.length; i++) {
            occurrences[arr[i]]++;
        }

        int highest = Integer.MIN_VALUE;
        int occurred = 0;
        for(int i = 0; i < occurrences.length; i++) {
            if(occurrences[i] > highest) {
                highest = occurrences[i];
                occurred = i;
            }
        }

        return occurred;
    }

    private static int[] mergeAndSortArrays(int[] arrX, int[] arrY) {
        int[] result = new int[arrX.length + arrY.length];
        int m = 0, n = 0, k = 0;

        while(m < arrX.length) {
            result[k] = arrX[m];
            m++;
            k++;
        }

        while(n < arrY.length) {
            result[k] = arrY[n];
            n++;
            k++;
        }

        Arrays.sort(result);

        return result;
    }

    private static int missingNumSeries(int[] arr) {
        int n = arr.length + 1;
        int sum = (n * (n + 1)) / 2;
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }

        return sum - total;
    }

    private static void printPairSum(int[] arr, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(sum - arr[i]) && map.get(sum - arr[i]) == 0) {
                map.replace(sum - arr[i], 1);
                System.out.println(arr[i] + ":" + (sum - arr[i]));
            } else {
                map.put(arr[i], 0);
            }
        }
    }

    private static void printPairSumIteration(int[] arr, int sum) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    System.out.println(arr[i] + ":" + arr[j]);
                }
            }
        }
    }

    private static boolean isPerfectNumber(int num) {
        int sum = 0;

        // addition of divisible number == input number

        for(int i = 1; i <= num / 2; i++) {
            if(num % i == 0) {
                sum = sum + i;
            }
        }

        return sum == num;
    }

    private static void primeFactors(int num) {

        // factorials

        while(num % 2 == 0) {
            System.out.println(2);
            num = num / 2;
        }

        for (int i = 3; i <= Math.sqrt(num); i = i + 2) {
            while(num % i == 0) {
                System.out.println(i);
                num = num / i;
            }
        }

        if (num > 2) System.out.println(num);
    }

    private static boolean isPrimeNumber(int num) {
        if(num == 0) {
            return false;
        } else if (num == 1) {
            return false;
        }

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void reverseArray(int[] arr) {
        int m = 0, n = arr.length - 1;
        while (m < n) {
            arr[m] = arr[m] + arr[n];
            arr[n] = arr[m] - arr[n];
            arr[m] = arr[m] - arr[n];
            m++;
            n--;
        }
    }

    private int reverseNumber(int x) {
        int reversed = 0;

        while(x != 0) {
            reversed = reversed * 10 + x % 10;
            x = x / 10;
        }

        return  reversed;
    }

    private int secondLargestInteger(int[] arr) {
        if(arr.length < 2) {
            return arr[0];
        }

        Arrays.sort(arr);

        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] != arr[arr.length - 1]) {
                return arr[i];
            }
        }

        return arr[0];
    }

    private boolean isPalindrome(String str) {
        int m = 0, n = str.length() - 1;
        while(m < n) {
            if(str.charAt(m) != str.charAt(n)) {
                return false;
            }
            m++;
            n--;
        }

        return true;
    }

    private int sumWithoutOperator(int x, int y) {
        while(y != 0) {
            int temp = x & y;
            x = x ^ y;
            y = temp << 1;
        }

        return x;
    }

    private void swapWithoutVar(int numX, int numY) {
        numX= numX + numY;
        numY = numX - numY;
        numX = numX - numY;

        System.out.println(numX + ":" + numY);
    }

    private static int[] rotateArrLeft(int[] arr, int d) {
        int[] rotated = new int[arr.length];
        int k = 0;

        for(int i = d; i < arr.length; i++) {
            rotated[k] = arr[i];
            k++;
        }

        for(int i = 0; i < d; i++) {
            rotated[k] = arr[i];
            k++;
        }

        return rotated;
    }

    private static int[] rotateArrRight(int[] arr, int d) {
        int[] rotated = new int[arr.length];
        int l = arr.length - d;
        int k = 0;

        for(int i = l; i < arr.length; i++) {
            rotated[k] = arr[i];
            k++;
        }

        for (int i = 0; i < l; i++) {
            rotated[k] = arr[i];
            k++;
        }

        return rotated;
    }

    private static String removeVowels(String str) {
        return str.replaceAll("[aeiouAEIOU]", "");
    }

    private static int binarySearchR(int[] arr, int k, int l, int r) {
        if(l > r) return l;
        int mid = (l + r) / 2;

        if (arr[mid] == k) return mid;
        else if (arr[mid] > k) return binarySearchR(arr, k, l, mid - 1);
        else if (arr[mid] < k) return binarySearchR(arr, k, mid + 1, r);
        return l;
    }

    private static int binarySearch(int[] arr, int k) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == k)  return mid;
            else if (arr[mid] > k) r = mid - 1;
            else if (arr[mid] < k) l = mid + 1;
        }

        return l;
    }
}
