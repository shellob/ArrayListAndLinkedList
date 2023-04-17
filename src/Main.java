import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class Main {
    public static void main(String[] args) {
        final List<Integer> arrayList = new ArrayList<>();
        final List<Integer> linkedList = new LinkedList<>();
        final int numberOfOperations = 1000;

        final long arrayListAddTime = testAdd(arrayList, numberOfOperations);
        final long linkedListAddTime = testAdd(linkedList, numberOfOperations);

        final long arrayListGetTime = testGet(arrayList, numberOfOperations);
        final long linkedListGetTime = testGet(linkedList, numberOfOperations);

        final long arrayListRemoveTime = testRemove(arrayList, numberOfOperations);
        final long linkedListRemoveTime = testRemove(linkedList, numberOfOperations);

        printResults(arrayListAddTime, linkedListAddTime, arrayListGetTime, linkedListGetTime, arrayListRemoveTime, linkedListRemoveTime);
    }

    public static long testAdd(List<Integer> list, int numberOfOperations) {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            list.add(i);
        }
        return System.nanoTime() - start;
    }

    public static long testGet(List<Integer> list, int numberOfOperations) {
        long start = System.nanoTime();
        for (int i = 0; i < numberOfOperations; i++) {
            list.get(i);
        }
        return System.nanoTime() - start;
    }

    public static long testRemove(List<Integer> list, int numberOfOperations) {
        long start = System.nanoTime();
        for (int i = numberOfOperations - 1; i >= 0; i--) {
            list.remove(i);
        }
        return System.nanoTime() - start;
    }

    public static void printResults(long arrayListAddTime, long linkedListAddTime, long arrayListGetTime, long linkedListGetTime, long arrayListRemoveTime, long linkedListRemoveTime) {
        System.out.printf("%-15s%-20s%-20s%n", "Method", "ArrayList", "LinkedList");
        System.out.printf("%-15s%-20d%-20d%n", "add", arrayListAddTime, linkedListAddTime);
        System.out.printf("%-15s%-20d%-20d%n", "get", arrayListGetTime, linkedListGetTime);
        System.out.printf("%-15s%-20d%-20d%n", "remove", arrayListRemoveTime, linkedListRemoveTime);
    }
}
