package tests;

import helpers.arrayHelper;
import helpers.constants;

public class useArrays {

    public static void main(String[] args) {

        arrayHelper.listNumbers(constants.number);
        arrayHelper.sortNumbers(constants.number);
        arrayHelper.removeDuplicates(constants.number);
        arrayHelper.addAll(constants.number);
        arrayHelper.add(999.99, 444.44);
        arrayHelper.minus(999.99, 444.44);
        arrayHelper.minus(999, 78);
        arrayHelper.multiply(40.1, 33.2);
        arrayHelper.divide(33, 3);
    }
}
