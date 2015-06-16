package task1;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;
/**
 *  Если мы из корректно записанного арифметического выражения, содержащего числа, знаки операций и открывающие
 *  и закрывающие круглые скобки выбросим числа и знаки операций, а затем запишем оставшиеся в выражении скобки
 *  без пробелов между ними, то полученный результат назовем правильным скобочным
 *  выражением [скобочное выражение "(()(()))" - правильное, а "()(" и "())(" - нет].
 *  Найти число правильных скобочных выражений, содержащих N открывающихся и N закрывающихся скобок. N вводится
 *  с клавиатуры. N неотрицательное целое число.
 */
public class Brackets {

    public static void main(String [] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        int result = 0;
        // while number is not positive, loop continues
        while (true)
    {
        N = Integer.parseInt(reader.readLine());
        if (N >= 0) break;
    }
        reader.close();
        result = fact(2*N)/ (fact(N) * fact(N +1));
        System.out.println(result);
    }

    // calculation number's factorial
    public static int fact(int n)
    {
        if (n==0) return 1;
        return n * fact(n -1);
    }
}




