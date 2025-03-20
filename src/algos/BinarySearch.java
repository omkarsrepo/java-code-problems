package algos;

// T: O(log n) S: O(1)

public class BinarySearch {

    private static int binarySearchRecursively(int[] arr, int key, int l, int r) {
        if(l > r) return l;
        int mid = (l + r) / 2;

        if(arr[mid] == key) return mid;
        else if (arr[mid] > key) return binarySearchRecursively(arr, key, l, mid - 1);
        else if (arr[mid] < key) return binarySearchRecursively(arr, key, mid + 1, r);

        return l;
    }

    private static int binarySearch(int[] arr, int key) {
        int l = 0, r = arr.length - 1;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                r = mid - 1;
            } else if (arr[mid] < key) {
                l = mid + 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int idxR = binarySearchRecursively(list, 7, 0, list.length - 1);
        int idx = binarySearch(list, 7);

        System.out.println(idxR);
        System.out.println(idx);
    }
}
