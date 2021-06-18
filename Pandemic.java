package pl.sdacademy.zadanka2;

public class Pandemic {
    public static void main(String[] args) {
        long lud =  7800000000L;
        pand(lud);

    }

    public static void pand(long x) {
        long z1 = 1;
        long z2 = 0;
        long z3 = 0;
        int dayCount = 0;
        while (x > 0) {
            x = x - z3;
            z3 = z2;
            z2 = z1;
            z1 = (z1 + z2 + z3);
            dayCount++;
        }
        System.out.println("Ludzkość wymrze po " + dayCount + " dniach.");
    }

}
