import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("enter search number: ");
        int searchElement = sc.nextInt();
        Result resultLinear = linearSearch(arr, searchElement);
        Result resultBinary = binarySearch(arr, searchElement);
        System.out.printf("for linear search counter = %d, found index = %d%n", resultLinear.getCounter(), resultLinear.getIndex());
        System.out.printf("for binary search counter = %d, found index = %d%n", resultBinary.getCounter(), resultBinary.getIndex());
    }

    private static Result linearSearch(int[] arr, int searchElement) {
        int counter = 0;
        for (int i = 0; i < arr.length; i ++) {
            counter++;
            if(arr[i] == searchElement) {
                return new Result(counter, i);
            }
        }
        return new Result(counter, -1);
    }

    private static Result binarySearch(int[] arr, int searchElement) {
        int counter = 0;
        int firstIndex = 0;
        int lastIndex = arr.length - 1;

        while(firstIndex <= lastIndex) {
            counter++;

            int middleIndex = (firstIndex + lastIndex) / 2;
            if (arr[middleIndex] == searchElement) {
                return new Result(counter, middleIndex);
            }

            else if (arr[middleIndex] < searchElement)
                firstIndex = middleIndex + 1;

            else if (arr[middleIndex] > searchElement)
                lastIndex = middleIndex - 1;

        }
        return new Result(counter, -1);
    }
}
