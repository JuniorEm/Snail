package com.company;

public class Main {

    private static Integer[][] matriz = new Integer[8][3];
    private static Integer[] arrays = null;

    private static void populate() {

        while (hasAnyNull(arrays)) {
            if (isAllNull()) {
                arrays = fillRight();
            } else {
                arrays = fillRight(arrays);
            }


            arrays = fillDown(arrays);
            arrays = fillLeft(arrays);
            arrays = fillUp(arrays);

        }

    }

    private static boolean hasAnyNull(Integer[] array) {
        Integer counter = 0;
        for (Integer line = 0; line < matriz.length; line++) {
            for (Integer column = 0; column < matriz[0].length; column++) {
                if (matriz[line][column] == null) {
                    counter++;
                }
            }
        }
        return counter > 0;
    }

    private static Integer[] fillRight() {
        final Integer line = 0;
        Integer lastColumn = 0;
        Integer lastLine = 0;
        Integer counter = 0;

        for (Integer column = 0; column < matriz[0].length; column++) {
            if (matriz[line][column] == null) {
                matriz[line][column] = counter++;
                lastColumn = column;
                lastLine = line;
            }


        }

        return new Integer[]{lastLine, lastColumn, counter};
    }

    private static Integer[] fillRight(final Integer[] arrays) {
        final Integer line = arrays[0];
        Integer lastColumn = 0;
        Integer lastLine = 0;
        Integer counter = arrays[2];

        for (Integer column = arrays[1]; column < matriz[0].length; column++) {
            if (matriz[line][column] == null) {
                matriz[line][column] = counter++;
                lastColumn = column;
                lastLine = line;
            }

            if (column == matriz[0].length - 1) {
                break;
            }


        }

        return new Integer[]{lastLine, lastColumn, counter};
    }

    private static Integer[] fillDown(final Integer[] arrays) {
        Integer lastColumn = 0;
        Integer lastLine = 0;
        final Integer column = arrays[1];
        Integer counter = arrays[2];

        for (Integer line = arrays[0]; line < matriz.length; line++) {
            if (matriz[line][column] == null) {
                matriz[line][column] = counter++;

                lastColumn = column;
                lastLine = line;
            }


        }

        return new Integer[]{lastLine, lastColumn, counter};
    }

    private static Integer[] fillUp(final Integer[] arrays) {
        Integer lastColumn = 0;
        Integer lastLine = 0;
        final Integer column = arrays[1];
        Integer counter = arrays[2];

        for (Integer line = arrays[0]; line >= 0 ; line--) {
            if (matriz[line][column] == null) {
                matriz[line][column] = counter++;

                lastColumn = column;
                lastLine = line;
            }
        }

        return new Integer[]{lastLine, lastColumn, counter};
    }

    private static Integer[] fillLeft(final Integer[] arrays) {
        Integer lastColumn = 0;
        Integer lastLine = 0;
        final Integer line = arrays[0];
        Integer counter = arrays[2];

        for (Integer column = arrays[1]; column >= 0; column--) {
            if (matriz[line][column] == null) {
                matriz[line][column] = counter++;
                lastColumn = column;
                lastLine = line;
            }

        }

        return new Integer[]{lastLine, lastColumn, counter};
    }

    private static boolean isAllNull() {
        Integer counter = 0;
        Integer max = matriz[0].length * matriz.length;
        for (Integer line = 0; line < matriz.length; line++) {
            for (int column = 0; column < matriz[0].length; column++) {
                if(matriz[line][column] == null) {
                    counter++;
                }
            }
        }

        return counter == max;
    }



    public static void main(String[] args) {
        populate();
        print();

    }

    private static void print() {
        for (Integer line = 0; line < matriz.length; line++) {
            for (int column = 0; column < matriz[0].length; column++) {
                System.out.print(matriz[line][column] + "\t");
            }
            System.out.print("\n");
        }
    }
}
