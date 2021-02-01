package br.com.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.isNull;

/**
 * Given two arrays a and b write a function comp(a, b) (orcompSame(a, b)) that checks whether the two arrays have the
 * "same" elements, with the same multiplicities. "Same" means, here, that the elements in b are the elements in a
 * squared, regardless of the order.
 * <p>
 * Examples Valid arrays a = [121, 144, 19, 161, 19, 144, 19, 11] b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
 * <p>
 * comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144,
 * 361 the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of
 * squares:
 * <p>
 * a = [121, 144, 19, 161, 19, 144, 19, 11] b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19] Invalid
 * arrays If, for example, we change the first number to something else, comp may not return true anymore:
 * <p>
 * a = [121, 144, 19, 161, 19, 144, 19, 11] b = [132, 14641, 20736, 361, 25921, 361, 20736, 361] comp(a,b) returns false
 * because in b 132 is not the square of any number of a.
 * <p>
 * a = [121, 144, 19, 161, 19, 144, 19, 11] b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361] comp(a,b) returns
 * false because in b 36100 is not the square of any number of a.
 * <p>
 * Remarks a or b might be [] (all languages except R, Shell). a or b might be nil or null or None or nothing (except in
 * C++, Elixir, Haskell, PureScript, Pascal, R, Rust, Shell). If a or b are nil (or null or None), the problem doesn't
 * make sense so return false.
 * <p>
 * Note for C The two arrays have the same size (> 0) given as parameter in function comp.
 */
public class AreSame {

    public static boolean comp(int[] a, int[] b) {
        if (checkNull(a, b) || checkNotSameSize(a, b)) {
            return false;
        }

        Integer[] arrayOfSquares = new Integer[a.length];
        for (int index = 0; index < a.length; index++) {
            arrayOfSquares[index] = a[index] * a[index];
        }
        List<Integer> listOfCalculatedSquares = new ArrayList<>(Arrays.asList(arrayOfSquares));

        for (int value : b) {
            if (!listOfCalculatedSquares.contains(value)) {
                return false;
            }

            listOfCalculatedSquares.remove(Integer.valueOf(value));
        }

        return true;
    }

    private static boolean checkNull(int[] a, int[] b) {
        return isNull(a) || isNull(b);
    }

    private static boolean checkNotSameSize(int[] a, int[] b) {
        return a.length != b.length;
    }

}
