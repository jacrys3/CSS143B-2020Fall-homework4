import Problem1.BinarySearch;
import Problem1.Permutation;
import Problem1.ReverseStack;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Problem1Test {

    public class PermutationTestCase {
        int[] input;
        List<List<Integer>> expect;

        public PermutationTestCase(int[] input, List<List<Integer>> expect) {
            this.input = input;
            this.expect = expect;
        }
    }

    // based on https://stackoverflow.com/questions/35761864/java-sort-list-of-lists
    class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
        @Override
        public int compare(List<T> list1, List<T> list2) {
            for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                int c = list1.get(i).compareTo(list2.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(list1.size(), list2.size());
        }
    }

    @Test
    public void testPermutation() {

        List<PermutationTestCase> testCases = getTestCases();

        for (int i = 0; i < testCases.size(); i++) {
            PermutationTestCase testCase = testCases.get(i);

            List<List<Integer>> results = Permutation.permute(testCase.input);

            assertEquals(listsToString(testCase.expect), listsToString(results));
        }
    }

    private List<PermutationTestCase> getTestCases() {
        List<PermutationTestCase> testCases = new ArrayList<>();
        //testCases.add(new PermutationTestCase(new int[]{}, Arrays.asList(Collections.emptyList())));
        testCases.add(new PermutationTestCase(new int[]{2}, Arrays.asList(Arrays.asList(2))));
        testCases.add(new PermutationTestCase(new int[]{1, 2}, Arrays.asList(Arrays.asList(1, 2), Arrays.asList(2, 1))));
        testCases.add(new PermutationTestCase(
                new int[]{1, 2, 3},
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 1, 3),
                        Arrays.asList(2, 3, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(3, 2, 1)
                )));
        testCases.add(new PermutationTestCase(
                new int[]{1, 2, 3, 4},
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4),
                        Arrays.asList(1, 2, 4, 3),
                        Arrays.asList(1, 3, 2, 4),
                        Arrays.asList(1, 3, 4, 2),
                        Arrays.asList(1, 4, 2, 3),
                        Arrays.asList(1, 4, 3, 2),
                        Arrays.asList(2, 1, 3, 4),
                        Arrays.asList(2, 1, 4, 3),
                        Arrays.asList(2, 3, 1, 4),
                        Arrays.asList(2, 3, 4, 1),
                        Arrays.asList(2, 4, 1, 3),
                        Arrays.asList(2, 4, 3, 1),
                        Arrays.asList(3, 2, 1, 4),
                        Arrays.asList(3, 2, 4, 1),
                        Arrays.asList(3, 1, 2, 4),
                        Arrays.asList(3, 1, 4, 2),
                        Arrays.asList(3, 4, 2, 1),
                        Arrays.asList(3, 4, 1, 2),
                        Arrays.asList(4, 2, 3, 1),
                        Arrays.asList(4, 2, 1, 3),
                        Arrays.asList(4, 3, 2, 1),
                        Arrays.asList(4, 3, 1, 2),
                        Arrays.asList(4, 1, 2, 3),
                        Arrays.asList(4, 1, 3, 2)
                )));
        return testCases;

    }

    private String listsToString(List<List<Integer>> lists) {
        lists.sort(new ListComparator<>());

        StringBuilder sb = new StringBuilder();

        for (List<Integer> ll : lists) {
            sb.append(ll.toString());
            sb.append(";");
        }

        return sb.toString();
    }

    @Test
    public void testListToString() {
        Integer[] list1 = new Integer[]{1, 2, 3, 4};
        Integer[] list2 = new Integer[]{6, 7, 8, 3};

        List<List<Integer>> lists1 = Arrays.asList(Arrays.asList(list1), Arrays.asList(list2));
        List<List<Integer>> lists2 = Arrays.asList(Arrays.asList(list2), Arrays.asList(list1));

        String expect = "[1, 2, 3, 4];[6, 7, 8, 3];";

        assertEquals(expect, listsToString(lists1));
        assertEquals(expect, listsToString(lists2));
    }

    public void perf() {
        int size = 11;
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = i;
        }

        Permutation.permute(input);
    }

    @Test
    public void testBinarySearch() {
        int[][] inputs = {
                {},
                {3},
                {3},
                {1, 3},
                {1, 3},
                {4, 6, 8},
                {4, 6, 8},
                {4, 6, 8},
                {3, 5, 7, 9, 20},
                {3, 5, 7, 9, 20},
        };
        int[] targets = {9, 1, 3, 1, 3, 4, 6, 8, 3, 9};
        int[] answer = {-1, -1, 0, 0, 1, 0, 1, 2, 0, 3};

        assertEquals(inputs.length, targets.length);
        assertEquals(inputs.length, answer.length);

        for (int i = 0; i < inputs.length; i++) {
            int actual = BinarySearch.binarySearch(inputs[i], targets[i]);
            int expected = answer[i];
            assertEquals(expected, actual);
        }
    }

    @Test
    public void reverseStack() {
        int[][] inputs = {
                {},
                {3},
                {1, 3},
                {4, 6, 8},
                {3, 5, 7, 9, 20},
        };
        int[][] expects = {
                {},
                {3},
                {3, 1},
                {8, 6, 4},
                {20, 9, 7, 5, 3},
        };
        for (int i = 0; i < inputs.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < inputs[i].length; j++) {
                stack.push(inputs[i][j]);
            }
            ReverseStack.reverseStack(stack);
            int[] actual = stack.stream().mapToInt(k -> k).toArray();
            assertArrayEquals(String.format("case %d", i), expects[i], actual);
        }
    }
}