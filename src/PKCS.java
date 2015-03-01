import java.math.BigInteger;

/**
 * Created by Gennadiy on 01.03.2015.
 */
public class PKCS {

    public static String getPlainText(String p, String q, String e, String ct) {
        BigInteger pBi = new BigInteger(p);
        BigInteger qBi = new BigInteger(q);
        BigInteger fi = pBi.subtract(BigInteger.ONE).multiply(qBi.subtract(BigInteger.ONE));
        BigInteger d = new BigInteger(e).modInverse(fi);
        BigInteger m = new BigInteger(ct).modPow(d, pBi.multiply(qBi));


        return new String(m.toByteArray());

    }
}
