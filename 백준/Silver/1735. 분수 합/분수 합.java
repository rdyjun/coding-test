import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        IO.init();
        calculateSumOfFractions();
        IO.close();
    }

    private static void calculateSumOfFractions() {
        int numerator;
        int denominator;

        StringTokenizer input = new StringTokenizer(IO.read());
        numerator = Integer.parseInt(input.nextToken());
        denominator = Integer.parseInt(input.nextToken());
        Fraction a = new Fraction(numerator, denominator);

        input = new StringTokenizer(IO.read());
        numerator = Integer.parseInt(input.nextToken());
        denominator = Integer.parseInt(input.nextToken());
        Fraction b = new Fraction(numerator, denominator);

        Fraction sumResult = a.sum(b);
        IO.write(sumResult.getNumerator() + " " + sumResult.getDenominator());
    }

    static class Fraction {
        private int numerator;
        private int denominator;

        public Fraction(int numerator, int denominator) {
            int gcd = gcd(numerator, denominator);
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
        }

        public Fraction sum(Fraction targetFraction) {
            int gcd = gcd(this.denominator, targetFraction.denominator);
            int lcm = this.denominator * targetFraction.denominator / gcd;

            int numeratorA = this.numerator * (lcm / this.denominator);
            int numeratorB = targetFraction.numerator * (lcm / targetFraction.denominator);

            int numerator = numeratorA + numeratorB;
            return new Fraction(numerator, lcm);
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int tmp = a % b;
                a = b;
                b = tmp;
            }
            return a;
        }

        public int getNumerator() {
            return this.numerator;
        }

        public int getDenominator() {
            return this.denominator;
        }
    }
}

class IO {
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void init() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() {
        try {
            writer.flush();
            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String read() {
        try {
             return reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void write(Object message) {
        try {
            writer.write(String.valueOf(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
