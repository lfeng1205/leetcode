package com.huawei.strFenGe;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/24.
 */
public class StrFenGe {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String str = input.nextLine();
            split(str);
        }
    }

    public static void split(String str){
        while(str.length()>=8){
            System.out.println(str.substring(0,8));
            str = str.substring(8);
        }

        if(str.length()<8&&str.length()>0){
            str = str +"00000000";
            System.out.println(str.substring(0,8));
        }

    }

}
