package com.huawei.shaizi;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/24.
 */
public class ShaiZi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String start = sc.nextLine();
            String word = sc.nextLine();
            System.out.println(getResult(start, word));
        }
    }

    public static String getResult(String start, String word) {
        char temp = ' ';
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            switch (ch) {
                case 'L':
                    start = start.charAt(4) + "" + start.charAt(5) + "" + start.charAt(2) + ""
                            + start.charAt(3) + "" + start.charAt(1) + "" + start.charAt(0);
                    break;
                case 'R':
//                    builder.append(start.charAt(5)).append(start.charAt(4)).append(start.charAt(2)).
//                            append(start.charAt(3)).append(start.charAt(0)).append(start.charAt(1));

                    start = start.charAt(5) + "" + start.charAt(4) + "" + start.charAt(2) + ""
                            + start.charAt(3) + "" + start.charAt(0) + "" + start.charAt(1);
                    break;
                case 'F':
                    start = start.charAt(0) + "" + start.charAt(1) + "" + start.charAt(4) + ""
                            + start.charAt(5) + "" + start.charAt(3) + "" + start.charAt(2);
                    break;
                case 'B':
                    start = start.charAt(0) + "" + start.charAt(1) + "" + start.charAt(5) + ""
                            + start.charAt(4) + "" + start.charAt(2) + "" + start.charAt(3) + "";
                    break;
                case 'A':
//                    builder.append(start.charAt(3)).append(start.charAt(2)).append(start.charAt(0)).
//                            append(start.charAt(1)).append(start.charAt(4)).append(start.charAt(5));

                    start = start.charAt(3) + "" + start.charAt(2) + "" + start.charAt(0) + ""
                            + start.charAt(1) + "" + start.charAt(4) + "" + start.charAt(5);
                    break;
                case 'C':
                    start = start.charAt(2) + "" + start.charAt(3) + "" + start.charAt(1) + ""
                            + start.charAt(0) + "" + start.charAt(4) + "" + start.charAt(5);
                    break;
            }
        }
        return start;
    }
}
