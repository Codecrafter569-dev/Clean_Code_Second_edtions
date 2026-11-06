import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FromRomanTestDrive_1_1 {

    private String roman;
    List<Integer> numbers = new ArrayList<>();

    Map<Character, Integer> values = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public FromRomanTestDrive_1_1(String roman) {
        this.roman = roman;
    }

    public static int convert(String roman) {
        return new FromRomanTestDrive_1_1(roman).doConversion();
    }

    private int doConversion() {
        if (roman == null || roman.isEmpty()) {
            throw new InvalidRomanNumeralException(roman);
        }

        checkForIllegalPrefixCombinations();
        checkForImproperRepetitions();
        convertToNumbers();
        checkNumbersAreInOrder();

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private void checkForIllegalPrefixCombinations() {

        String[] illegal = {
                "IIV",
                "IIX",
                "IL",
                "IC",
                "ID",
                "IM",

                "VX",
                "VL",
                "VC",
                "VD",
                "VM",

                "XD",
                "XM",

                "LC",
                "LD",
                "LM",

                "DM",

                "VIV",
                "IXI",
                "LXL",
                "XCX",
                "DCD",
                "CDC",
                "MCM"
        };

        for (String badCombination : illegal) {
            if (roman.contains(badCombination)) {
                throw new InvalidRomanNumeralException(roman);
            }
        }
    }

    private void checkForImproperRepetitions() {

        String[] badRepetitions = {
                "IIII",
                "VV",
                "XXXX",
                "LL",
                "CCCC",
                "DD",
                "MMMM"
        };

        for (String badRep : badRepetitions) {
            if (roman.contains(badRep)) {
                throw new InvalidRomanNumeralException(roman);
            }
        }
    }

    private void convertToNumbers() {

        char[] chars = roman.toCharArray();

        for (int i = 0; i < chars.length; i++) {

            char currentChar = chars[i];

            // Check whether the current character is a valid Roman symbol
            Integer currentValue = values.get(currentChar);

            if (currentValue == null) {
                throw new InvalidRomanNumeralException(roman);
            }

            char nextChar = i + 1 < chars.length
                    ? chars[i + 1]
                    : '\0';

            Integer nextValue = values.get(nextChar);

            if (nextChar != '\0' && nextValue == null) {
                throw new InvalidRomanNumeralException(roman);
            }

            if (nextValue != null && currentValue < nextValue) {

                // Only these subtractive combinations are legal:
                // IV, IX, XL, XC, CD, CM

                boolean validSubtraction =
                        (currentChar == 'I' &&
                                (nextChar == 'V' || nextChar == 'X'))

                        || (currentChar == 'X' &&
                                (nextChar == 'L' || nextChar == 'C'))

                        || (currentChar == 'C' &&
                                (nextChar == 'D' || nextChar == 'M'));

                if (!validSubtraction) {
                    throw new InvalidRomanNumeralException(roman);
                }

                numbers.add(nextValue - currentValue);
                i++;

            } else {
                numbers.add(currentValue);
            }
        }
    }

    private void checkNumbersAreInOrder() {

        int lastDigit = Integer.MAX_VALUE;

        for (int number : numbers) {

            if (number > lastDigit) {
                throw new InvalidRomanNumeralException(roman);
            }

            lastDigit = number;
        }
    }

    public static class InvalidRomanNumeralException
            extends RuntimeException {

        public InvalidRomanNumeralException(String roman) {
            super("Invalid Roman Numeral Exception: " + roman);
        }
    }

    public static void main(String[] args) {

        String[] testCases = {
                "I",
                "III",
                "IV",
                "V",
                "IX",
                "X",
                "XL",
                "L",
                "XC",
                "C",
                "CD",
                "D",
                "CM",
                "M",
                "MMXXVI",

                // Valid
                "VIII",
                "XIV",
                "XIX",
                "XLII",
                "XCIX",
                "CDXLIV",
                "CMXCIX",

                // Invalid
                "IIII",
                "VV",
                "XXXX",
                "IL",
                "IC",
                "ID",
                "IM",
                "IIV",
                "IIX",
                "VX",
                "XD",
                "XM",
                "ABC",
                "VIV",
                "IXI"
        };

        for (String roman : testCases) {

            try {

                int result = convert(roman);

                System.out.println(
                        roman + " = " + result
                );

            } catch (InvalidRomanNumeralException e) {

                System.out.println(
                        roman + " = Invalid Roman Numeral Exception"
                );
            }
        }
    }
}

