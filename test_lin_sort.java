package Laba7;

public class test_lin_sort {
    public static void main(String[] argv){
        int[] arr = {177, 52, 33, 52, 12, 1, 4, 6, 34, -2, -3};
        int[] arr2 = {-1, 177, 52, 33, 12, -10, 1, 4, 6, 34};
        int[] arr3 = {-1, 177, 52, 33, 12, 1, 4, 6, 34};
        
        lin_sort test = new lin_sort();

        test.Countsort(arr);
        test.print(arr);
        System.out.println(" ");

        test.MSDsort(arr2);
        test.print(arr2);

        System.out.println(" ");
    
        test.LSDsort(arr3);
        test.print(arr3);



    }
}
