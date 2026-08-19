package org.example.Interview.Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test8 {

    public static void main(String[] args) {

        int rateLength = 6;
        int state = 3;
        int month = 5;

        int[] ratings = {1, 4, 2, 5, 1, 6};

        int countries = rateLength / state;

        List<Country> list = new ArrayList<>();

        // Create countries
        for (int i = 0; i < countries; i++) {

            int[] countryRatings = new int[state];

            System.arraycopy(ratings, i * state, countryRatings, 0, state);

            list.add(new Country(i + 1, countryRatings));
        }

        // Sort countries based on their ratings
        list.sort((a, b) -> {

            for (int i = 0; i < state; i++) {

                if (a.ratings[i] != b.ratings[i]) {
                    return a.ratings[i] - b.ratings[i];
                }
            }

            return 0;
        });

        // Find country and state for given month
        int countryIndex = (month - 1) / state;
        int stateIndex = (month - 1) % state;

        Country country = list.get(countryIndex);

        System.out.println("Country = " + country.number);
        System.out.println("State rating = " + country.ratings[stateIndex]);
    }

    static class Country {
        int number;
        int[] ratings;

        Country(int number, int[] ratings) {
            this.number = number;
            this.ratings = ratings;
            Arrays.sort(this.ratings);
        }
    }


}
