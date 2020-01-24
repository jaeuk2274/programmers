package me.jaeuk.study;

public class 순열 {
    public static void main(String[] args) {
        String numbers = "123";

        순열 solve = new 순열();

        solve.permutation(numbers, "");
    }

    public static void permutation(String numbers, String prefix){
        String temp = "";
        if(numbers.length() == 0){
            System.out.println(prefix);
        }
        else {
            for(int i=0; i<numbers.length(); i++){
                temp = numbers.substring(0, i) + numbers.substring(i+1);
                permutation(temp, prefix + numbers.charAt(i));
            }
        }
    }
}
