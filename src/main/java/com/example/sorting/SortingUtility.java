package com.example.sorting;


// AI PROMPT: Fill out the SortingUtility class with the sorting algorithms listed with TODOs
public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] a) {

        int pos = 0;
        while (pos < a.length) {
            if (pos == 0 || a[pos].compareTo(a[pos - 1]) >= 0) {
                pos++;
            } else {
                swap(a, pos, pos - 1);
                pos--;
            }
        }
    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] a) {

        boolean swapped;
        do {
            swapped = false;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }

            swapped = false;

            for (int i = a.length - 2; i >= 0; i--) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

        } while (swapped);
    }


    public static <T extends Comparable<T>> void shellSort(T[] a) {

        int n = a.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = a[i];
                int j;

                // Perform a gapped insertion sort
                for (j = i; j >= gap && a[j - gap].compareTo(temp) > 0; j -= gap) {
                    a[j] = a[j - gap];
                }

                a[j] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] a, int index1, int index2) {

        T temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;

    }
}





