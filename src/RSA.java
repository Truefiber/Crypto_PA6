import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Created by Gennadiy on 01.03.2015.
 */
public class RSA {

    public static BigInteger getSmallerFactor1(String chal) {
        BigInteger chalInteger = new BigInteger(chal);
        BigInteger average = BigIntegerMath.sqrt(chalInteger, RoundingMode.CEILING);
        BigInteger x = BigIntegerMath.sqrt(average.pow(2).subtract(chalInteger), RoundingMode.CEILING);
        boolean isFactorFound = false;

        while (!isFactorFound) {
            if (isCorrect(chalInteger, average, x)) {
                isFactorFound = true;
            } else {
                average = average.add(BigInteger.ONE);
                x = BigIntegerMath.sqrt(average.pow(2).subtract(chalInteger), RoundingMode.CEILING);

            }
        }
        System.out.println(average.add(x));
        return average.subtract(x);
    }

    private static boolean isCorrect(BigInteger n, BigInteger a, BigInteger x) {
        if (a.subtract(x).multiply(a.add(x)).equals(n)) {
            return true;
        } else {
            return false;
        }
    }

    public static BigInteger getSmallerFactorChal3(String chal) {
        BigInteger chalInteger = new BigInteger(chal).multiply(new BigInteger("24"));
        BigInteger average = BigIntegerMath.sqrt(chalInteger, RoundingMode.CEILING);
        BigInteger x = BigIntegerMath.sqrt(average.pow(2).subtract(chalInteger), RoundingMode.CEILING);

        BigInteger p = average.add(x).divide(new BigInteger("4"));

        BigInteger q = average.subtract(x).divide(new BigInteger("6"));

        if (p.compareTo(q) == -1) {
            return p;
        } else {
            return q;
        }



    }


}
