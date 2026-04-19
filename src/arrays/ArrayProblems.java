package arrays;

import java.util.*;

public class ArrayProblems {

    // ---------- Utility: Print Array ----------
    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    private static void printArray(int[] arr, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(arr[i]);
            if (i < length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ================== LEVEL 1 : FOUNDATION ==================

    // 1. Find largest element
    // Brute & Optimal both are simple traversal (O(n))
    public static int largestElement(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }

    // 2. Find smallest element
    public static int smallestElement(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }

    // 3. Reverse array (Two Pointer)
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // 4. Sum of array
    public static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) sum += num;
        return sum;
    }

    // 5. Average of array
    public static double averageArray(int[] arr) {
        return (double) sumArray(arr) / arr.length;
    }

    // 6. Second largest element
    // Brute: sort O(n log n)
    public static int secondLargestBrute(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        return copy[copy.length - 2];
    }

    // Optimal: single traversal O(n)
    public static int secondLargestOptimal(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        return second;
    }

    // 7. Count even & odd
    public static void countEvenOdd(int[] arr) {
        int even = 0, odd = 0;
        for (int num : arr) {
            if (num % 2 == 0) even++;
            else odd++;
        }
        System.out.println("Even: " + even + ", Odd: " + odd);
    }

    // 8. Check if array is sorted
    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return false;
        }
        return true;
    }

    // 9. Remove duplicates from sorted array (Two Pointer, in‑place)
    // Returns new length. Brute: use HashSet; Optimal: below.
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[j]) {
                j++;
                arr[j] = arr[i];
            }
        }
        return j + 1;
    }

    // 10. Left rotate by one
    public static void leftRotateByOne(int[] arr) {
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    // ================== LEVEL 2 : CORE ARRAY LOGIC ==================

    // 11. Move zeroes to end
    // Brute: create new array O(n) space
    public static void moveZeroesBrute(int[] arr) {
        int[] temp = new int[arr.length];
        int idx = 0;
        for (int num : arr) if (num != 0) temp[idx++] = num;
        while (idx < arr.length) temp[idx++] = 0;
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }

    // Optimal: Two Pointer O(n) time, O(1) space
    public static void moveZeroesOptimal(int[] arr) {
        int nonZeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[nonZeroIndex];
                arr[nonZeroIndex] = arr[i];
                arr[i] = temp;
                nonZeroIndex++;
            }
        }
    }

    // 12. Rotate array by K (Reverse Trick)
    // Brute: rotate one by one O(n*k)
    // Optimal: reverse three parts O(n) O(1)
    public static void rotateArray(int[] arr, int k) {
        k = k % arr.length;
        if (k < 0) k += arr.length; // handle negative
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // 13. Union of two arrays (Set / Pointer)
    // Brute: HashSet
    public static int[] unionBrute(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int num : a) set.add(num);
        for (int num : b) set.add(num);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    // Optimal: Two pointer (only if arrays are sorted) – here we sort first
    public static int[] unionOptimal(int[] a, int[] b) {
        int[] sortedA = a.clone(); Arrays.sort(sortedA);
        int[] sortedB = b.clone(); Arrays.sort(sortedB);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < sortedA.length && j < sortedB.length) {
            if (sortedA[i] < sortedB[j]) {
                if (list.isEmpty() || list.get(list.size()-1) != sortedA[i]) list.add(sortedA[i]);
                i++;
            } else if (sortedA[i] > sortedB[j]) {
                if (list.isEmpty() || list.get(list.size()-1) != sortedB[j]) list.add(sortedB[j]);
                j++;
            } else {
                if (list.isEmpty() || list.get(list.size()-1) != sortedA[i]) list.add(sortedA[i]);
                i++; j++;
            }
        }
        while (i < sortedA.length) {
            if (list.isEmpty() || list.get(list.size()-1) != sortedA[i]) list.add(sortedA[i]);
            i++;
        }
        while (j < sortedB.length) {
            if (list.isEmpty() || list.get(list.size()-1) != sortedB[j]) list.add(sortedB[j]);
            j++;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // 14. Intersection of two arrays (Two Pointer for sorted)
    // Brute: nested loops O(n*m)
    public static int[] intersectionBrute(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        for (int numA : a) {
            for (int numB : b) {
                if (numA == numB && !list.contains(numA)) {
                    list.add(numA);
                    break;
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // Optimal: sort + two pointer (or HashSet)
    public static int[] intersectionOptimal(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) i++;
            else if (a[i] > b[j]) j++;
            else {
                if (list.isEmpty() || list.get(list.size()-1) != a[i]) list.add(a[i]);
                i++; j++;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // 15. Sort 0s, 1s, 2s (Dutch Flag)
    // Brute: counting sort (two pass)
    public static void sort012Brute(int[] arr) {
        int c0 = 0, c1 = 0, c2 = 0;
        for (int num : arr) {
            if (num == 0) c0++;
            else if (num == 1) c1++;
            else c2++;
        }
        int idx = 0;
        while (c0-- > 0) arr[idx++] = 0;
        while (c1-- > 0) arr[idx++] = 1;
        while (c2-- > 0) arr[idx++] = 2;
    }

    // Optimal: Dutch National Flag (one pass)
    public static void sort012Optimal(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++; mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 16. Merge two sorted arrays
    // Brute: create new array and merge O(n+m) space
    public static int[] mergeBrute(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) res[k++] = a[i++];
            else res[k++] = b[j++];
        }
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return res;
    }

    // Optimal: same as above (optimal for merging two sorted arrays)
    // For merging in-place with O(1) extra space, gap method exists but not needed here.

    // 17. Find missing number (0..n)
    // Brute: linear search for each number O(n^2)
    public static int missingNumberBrute(int[] arr, int n) {
        for (int i = 0; i <= n; i++) {
            boolean found = false;
            for (int num : arr) {
                if (num == i) {
                    found = true;
                    break;
                }
            }
            if (!found) return i;
        }
        return -1;
    }

    // Optimal: Math sum formula or XOR
    public static int missingNumberOptimal(int[] arr, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : arr) actualSum += num;
        return expectedSum - actualSum;
    }

    // 18. Find duplicate number (array size n+1, numbers 1..n)
    // Brute: sort and check adjacent O(n log n)
    public static int findDuplicateBrute(int[] arr) {
        int[] copy = arr.clone();
        Arrays.sort(copy);
        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == copy[i-1]) return copy[i];
        }
        return -1;
    }

    // Optimal: Floyd's cycle detection (or XOR, but cycle works for any)
    public static int findDuplicateOptimal(int[] arr) {
        int slow = arr[0], fast = arr[0];
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }

    // 19. Product of array except self
    // Brute: nested loops O(n^2)
    public static int[] productExceptSelfBrute(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) prod *= arr[j];
            }
            res[i] = prod;
        }
        return res;
    }

    // Optimal: Prefix and suffix product O(n) O(1) extra (output array not counted)
    public static int[] productExceptSelfOptimal(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i-1] * arr[i-1];
        }
        int suffix = 1;
        for (int i = n-1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= arr[i];
        }
        return res;
    }

    // 20. Maximum product subarray (Kadane variant)
    // Brute: check all subarrays O(n^2)
    public static int maxProductSubarrayBrute(int[] arr) {
        int maxProd = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int prod = 1;
            for (int j = i; j < arr.length; j++) {
                prod *= arr[j];
                maxProd = Math.max(maxProd, prod);
            }
        }
        return maxProd;
    }

    // Optimal: Kadane's variant with min product tracking O(n)
    public static int maxProductSubarrayOptimal(int[] arr) {
        int maxProd = arr[0], minProd = arr[0], result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }
            maxProd = Math.max(arr[i], maxProd * arr[i]);
            minProd = Math.min(arr[i], minProd * arr[i]);
            result = Math.max(result, maxProd);
        }
        return result;
    }

    // ================== MAIN DEMO ==================
    public static void main(String[] args) {
        System.out.println("====== LEVEL 1 DEMO ======");

        int[] arr1 = {5, 2, 9, 1, 7, 6};
        System.out.print("Original array: ");
        printArray(arr1);
        System.out.println("Largest: " + largestElement(arr1));
        System.out.println("Smallest: " + smallestElement(arr1));

        int[] revArr = arr1.clone();
        reverseArray(revArr);
        System.out.print("Reversed: ");
        printArray(revArr);

        System.out.println("Sum: " + sumArray(arr1));
        System.out.println("Average: " + averageArray(arr1));

        System.out.println("Second largest (brute): " + secondLargestBrute(arr1));
        System.out.println("Second largest (optimal): " + secondLargestOptimal(arr1));

        System.out.print("Count even/odd: ");
        countEvenOdd(arr1);

        int[] sorted = {1, 2, 3, 4, 5};
        System.out.println("Is {1,2,3,4,5} sorted? " + isSorted(sorted));
        System.out.println("Is {5,2,9,1,7,6} sorted? " + isSorted(arr1));

        int[] dupArr = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.print("Before remove duplicates: ");
        printArray(dupArr);
        int newLen = removeDuplicates(dupArr);
        System.out.print("After remove duplicates: ");
        printArray(dupArr, newLen);

        int[] rotOne = {1, 2, 3, 4, 5};
        leftRotateByOne(rotOne);
        System.out.print("Left rotate by one: ");
        printArray(rotOne);

        System.out.println("\n====== LEVEL 2 DEMO ======");

        // 11. Move zeroes
        int[] zeroArr = {0, 1, 0, 3, 12};
        System.out.print("Move zeroes (brute): ");
        moveZeroesBrute(zeroArr.clone());
        printArray(zeroArr);
        int[] zeroArr2 = {0, 1, 0, 3, 12};
        System.out.print("Move zeroes (optimal): ");
        moveZeroesOptimal(zeroArr2);
        printArray(zeroArr2);

        // 12. Rotate by K
        int[] rotK = {1, 2, 3, 4, 5, 6, 7};
        rotateArray(rotK, 3);
        System.out.print("Rotate by 3: ");
        printArray(rotK);

        // 13. Union
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {3, 4, 5, 6, 7};
        System.out.print("Union (brute): ");
        printArray(unionBrute(a, b));
        System.out.print("Union (optimal): ");
        printArray(unionOptimal(a, b));

        // 14. Intersection
        System.out.print("Intersection (brute): ");
        printArray(intersectionBrute(a, b));
        System.out.print("Intersection (optimal): ");
        printArray(intersectionOptimal(a, b));

        // 15. Sort 0,1,2
        int[] dutch = {2, 0, 1, 2, 1, 0};
        System.out.print("Sort 0,1,2 (brute): ");
        int[] d1 = dutch.clone(); sort012Brute(d1); printArray(d1);
        System.out.print("Sort 0,1,2 (optimal): ");
        int[] d2 = dutch.clone(); sort012Optimal(d2); printArray(d2);

        // 16. Merge sorted arrays
        int[] m1 = {1, 3, 5};
        int[] m2 = {2, 4, 6};
        System.out.print("Merge sorted (brute): ");
        printArray(mergeBrute(m1, m2));

        // 17. Missing number (0..5)
        int[] miss = {0, 1, 2, 4, 5};
        System.out.println("Missing number (brute): " + missingNumberBrute(miss, 5));
        System.out.println("Missing number (optimal): " + missingNumberOptimal(miss, 5));

        // 18. Find duplicate (numbers 1..n)
        int[] dupNum = {1, 3, 4, 2, 2};
        System.out.println("Duplicate (brute): " + findDuplicateBrute(dupNum));
        System.out.println("Duplicate (optimal): " + findDuplicateOptimal(dupNum));

        // 19. Product except self
        int[] prodArr = {1, 2, 3, 4};
        System.out.print("Product except self (brute): ");
        printArray(productExceptSelfBrute(prodArr));
        System.out.print("Product except self (optimal): ");
        printArray(productExceptSelfOptimal(prodArr));

        // 20. Max product subarray
        int[] maxProdArr = {2, 3, -2, 4};
        System.out.println("Max product subarray (brute): " + maxProductSubarrayBrute(maxProdArr));
        System.out.println("Max product subarray (optimal): " + maxProductSubarrayOptimal(maxProdArr));
    }
}