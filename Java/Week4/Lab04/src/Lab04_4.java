class ArrayUtil {
    public static int[] concat(int[] arr1, int[] arr2) {
        int[] newArr = new int[arr1.length+arr2.length];

        for(int i=0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }
        for (int i=0; i < arr2.length; i++) {
            newArr[arr1.length+i] = arr2[i];
        }
        return newArr;
    }

    public static void print(int[] arr) {
        System.out.print("[");
        for(int elem : arr) {
            System.out.print(" " + elem);
        }
        System.out.print(" ]");
    }
}

public class Lab04_4 {
    public static void main(String[] args) {
        int[] array1 = {1993, 0, 5, 1, 6};
        int[] array2 = {1990, 0, 2, 1, 2};
        int[] array3 = {};

        array3 = ArrayUtil.concat(array1, array2);
        ArrayUtil.print(array3);
    }
}
