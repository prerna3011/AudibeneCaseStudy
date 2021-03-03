package utils;

import java.util.List;

public class DataBean {

    private static List tableOneNames;
    private static List tableTwoNames;
    private static int tableTwoLength;
    private static int tableOneLength;
    private static String inputValue;

    public static void setTableOneNames(List oneNames) {

        tableOneNames = oneNames;
    }

    public static List getTableOneNames() {

        return tableOneNames;
    }

    public static void setTableTwoNames(List twoNames) {

        tableTwoNames = twoNames;
    }

    public static List getTableTwoNames() {

        return tableTwoNames;
    }

    public static void setTableOneLength(int oneLength) {

        tableOneLength = oneLength;
    }

    public static int getTableOneLength() {

        return tableOneLength;
    }

    public static void setTableTwoLength(int twoLength) {

        tableTwoLength = twoLength;
    }

    public static int getTableTwoLength() {

        return tableTwoLength;
    }
    public static void setInputValue(String text) {

        inputValue = text;
    }

    public static String getInputValue() {

        return inputValue;
    }
}
