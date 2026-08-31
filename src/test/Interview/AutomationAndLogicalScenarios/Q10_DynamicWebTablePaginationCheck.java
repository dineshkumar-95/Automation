package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Dynamic Web Table Pagination Check: Ensure a page of table values is strictly
 * sorted before clicking "Next".
 * SDET: Automated validation of UI sorting grids and data table filters.
 */
public class Q10_DynamicWebTablePaginationCheck {
    public static void main(String[] args) {
        String[] page1 = {"Apple", "Banana", "Cherry"};
        String[] page2 = {"Date", "Elderberry", "Fig"};
        Integer[] nums = {10, 20, 25, 40};

        System.out.println("Page1 alpha sorted: " + isStrictlySorted(page1));
        System.out.println("Nums sorted: " + isStrictlySorted(nums));
        System.out.println("Can go next after page1: " + validatePageThenNext(page1, true));
        System.out.println("Cross-page order ok: " + validateAcrossPages(page1, page2));
        System.out.println("Unsorted fails: " + isStrictlySorted(new String[]{"B", "A", "C"}));
    }

    // Best: single linear compare with adjacent elements — O(n)
    public static <T extends Comparable<? super T>> boolean isStrictlySorted(T[] page) {
        if (page == null || page.length <= 1) {
            return true;
        }
        for (int i = 1; i < page.length; i++) {
            if (page[i - 1].compareTo(page[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean isStrictlySorted(T[] page, Comparator<? super T> comparator) {
        if (page == null || page.length <= 1) {
            return true;
        }
        for (int i = 1; i < page.length; i++) {
            if (comparator.compare(page[i - 1], page[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    // Mimic: validate current page, then "click Next"
    public static boolean validatePageThenNext(String[] currentPage, boolean hasNext) {
        if (!isStrictlySorted(currentPage)) {
            throw new AssertionError("Page values are not sorted: " + Arrays.toString(currentPage));
        }
        return hasNext; // true => automation would click Next
    }

    // Also ensure last of page N <= first of page N+1 for global sort
    public static boolean validateAcrossPages(String[] current, String[] next) {
        if (!isStrictlySorted(current) || !isStrictlySorted(next)) {
            return false;
        }
        if (current.length == 0 || next.length == 0) {
            return true;
        }
        return current[current.length - 1].compareTo(next[0]) <= 0;
    }
}
