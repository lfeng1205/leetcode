package com.leetcode.letterCombinations;

import java.util.ArrayList;

/**
 * Created by Feng on 2016/12/26.
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LetterCombinations {
    public static void main(String[] args) {
        String digits = "23";
        ArrayList<String> result = letterCombinations(digits);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> list = new ArrayList<>();

        char[] chars = new char[digits.length()];
        helper(digits, chars, 0, list);
        return list;
    }

    public static void helper(String digits, char[] chars, int index, ArrayList<String> res) {
        if (index == digits.length()) {
            res.add(String.valueOf(chars));
            return;
        }
        int n = Integer.parseInt(digits.charAt(index) + "");
        for (char ch : strs[n - 2].toCharArray()) {
            chars[index] = ch;
            helper(digits, chars, index + 1, res);
        }
    }
}
