import java.math.BigInteger;
import java.util.Random;

import static java.lang.Math.abs;

public class DH_Globals {
    public static class Publics {
        public BigInteger VAL_N, VAL_G;

        private void generate() {
            this.VAL_N = BigInteger.valueOf(getRandomPrime(16));
            this.VAL_G = BigInteger.valueOf(getRandomPrime(128, 16));
        }

        public Publics(){
            this.generate();
        }
    }


    public static String[] primes(int range_max, int range_min)
    {
        if (range_max % 2 != 1) range_max = range_max-1;
        range_max = abs(range_max);
        range_min = abs(range_min);
        int diff = range_max - range_min;
        String[] results = new String[1+diff/2];

        for (int i = 0; i < diff; i++)
        {
            if (i % 2 != 1)
            {
                continue;
            }
            results[i/2] = String.valueOf(i);
        }
        return results;
    }

    public static String[] primes(int range_max)
    {
        return primes(range_max, 1);
    }


    public static int getRandomPrime(int rmax, int rmin)
    {
        final String[] my_primes = DH_Globals.primes(rmax, rmin);
        Random random = new Random();
        int diff = rmax - rmin;
        int rand = random.nextInt(diff/2);
        return Integer.parseInt(my_primes[rand]);
    }

    public static int getRandomPrime(int rmax)
    {
        final String[] my_primes = DH_Globals.primes(rmax);
        Random random = new Random();
        int rand = random.nextInt(rmax/2);
        return Integer.parseInt(my_primes[rand]);
    }

    public static int getRandomPrime()
    {
        int range = 256;
        final String[] my_primes = DH_Globals.primes(range);
        Random random = new Random();
        int rand = random.nextInt(range/2);
        return Integer.parseInt(my_primes[rand]);
    }


}
