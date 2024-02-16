package Laba7;

import java.util.ArrayList;

public class lin_sort{


    // Сортировка подсчетом
    public void Countsort(int[] arr) {

        int n = arr.length;
        if (n == 0) {
            return;
        }

        int max = arr[0];
        int min = arr[0];

        // Находим максимальное и минимальное значения в массиве
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];

        // Подсчитываем количество каждого элемента
        for (int i = 0; i < n; i++) {
            count[arr[i] - min]++;
        }

        // Модифицируем подсчет, чтобы он отражал фактическую позицию элемента в выходном массиве
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Строим выходной массив
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        // Копируем отсортированный массив обратно в исходный
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }


    // Сортировка MDS
    public static void MSDsort(int[] arr) {
        int cnt[][] = new int[4][];
        int b[];
        int i, j;
        int a_len = arr.length;

        if (a_len < 2) {    // массив длиной 1 элемент не нужно сортировать
            return;
        }

        // инициализируем счетчик [cnt]
        for (j = 0; j < 4; j++) {
            cnt[j] = new int[257];
            for (i = 0; i < 257; i++) cnt[j][i] = 0;
        }

        // выделяем память под копию сортируемого массива
        b = new int[a_len];

        // подсчитываем количество элементов для каждого значения j-го разряда
        for (i = 0; i < a_len; i++) {
            for (j = 0; j < 4; j++) {
                cnt[j][1 + ((arr[i] >>> (8 * j)) & 0xff)]++;
            }
        }

        for (j = 0; j < 4; j++) {
		/*
		вычисляем позиции cnt[i], начиная с которых будут располаться элементы
		с соответствующим значением j-го разряда
		*/
            for (i = 1; i < 256; i++) cnt[j][i] += cnt[j][i - 1];
            // расставляем элементы из массива a в массив b в указанном порядке

            for (i = 0; i < a_len; i++) {
                b[cnt[j][(arr[i] >>> (8 * j)) & 0xff]++] = arr[i];
            }
            // копируем массив b на место массива a
            for (i = 0; i < a_len; i++) arr[i] = b[i];
        }
        while(true){
            if(arr[a_len-1] >= 0){
                return;
            }
            int g = arr[a_len-1];
            //System.out.println(arr[i]);
            for (j = a_len-1; j > 0; j--){
                    arr[j] = arr[j-1];
            }
            arr[0] = g;

        }
    }
    public static void LSDsort(int[] array) {
        for(int i = 0; i < array.length; i++){
            if(array[i] < 0){
                System.out.println("Неподходящий массив для LSD_sort");
                return;
            }
        }
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // сортируем
        boolean flag = false;
        int tmp = -1, divisor = 1;
        while (!flag) {
            flag = true;
            // разделяем ввод между списками
            for (Integer i : array) {
                tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            // пустые списки во входном массиве
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : buckets[b]) {
                    array[a++] = i;
                }
                buckets[b].clear();
            }
            // переходим к следующией цифре
            divisor *= 10;
        }
    }


    // Вывод на экран
    public void print(int[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(" " + arr[i]);

    }
}