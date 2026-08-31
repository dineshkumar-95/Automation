package org.example.Interview.Sample;

import java.util.*;

public class Test9 {

    public static void main(String[] args) {

        int rateLength = 9;
        int state = 3;
        int month = 5;

        int[] ratings = {1, 4, 2,     5, 1, 6    ,1,2,7};
//        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        
        int country = 1;
        Map<Integer, List<Integer>> countryAndRatings = new HashMap<>();
        for (int i =0; i<rateLength;i++){

            list.add(ratings[i]);
            if (list.size()==state){
                Collections.sort(list);
                countryAndRatings.put(country,list);
                list = new ArrayList<>();
                country++;
            }
        }

// --- 2. Extract country keys into a list for manual ranking ---
        List<Integer> orderedCountryIds = new ArrayList<>(countryAndRatings.keySet());
        int totalCountries = orderedCountryIds.size();

        // --- 3. Manual Bubble Sort to rank the countries ---
        for (int i = 0; i < totalCountries - 1; i++) {
            for (int j = 0; j < totalCountries - i - 1; j++) {

                int countryA = orderedCountryIds.get(j);
                int countryB = orderedCountryIds.get(j + 1);

                List<Integer> profileA = countryAndRatings.get(countryA);
                List<Integer> profileB = countryAndRatings.get(countryB);

                // Determine if profileA is greater than profileB element-by-element
                boolean shouldSwap = false;
                for (int k = 0; k < state; k++) {
                    if (profileA.get(k) > profileB.get(k)) {
                        shouldSwap = true; // Country A has worse ratings; needs to be moved down
                        break;
                    } else if (profileA.get(k) < profileB.get(k)) {
                        break; // Country A is already smaller/better; no swap needed
                    }
                    // If equal, continue loop to check the next element
                }

                // Perform the swap if Country A's profile is worse than Country B's
                if (shouldSwap) {
                    orderedCountryIds.set(j, countryB);
                    orderedCountryIds.set(j + 1, countryA);
                }
            }
        }

        // --- 4. Print Results ---
        System.out.println("Countries sorted from least to highest rating profile:");
        System.out.println(orderedCountryIds);

        System.out.println("\nDetailed Ranking Breakdown:");
        for (int cid : orderedCountryIds) {
            System.out.println("Country " + cid + ": " + countryAndRatings.get(cid));
        }



    }



}
