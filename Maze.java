package pl.sdacademy.zadanka2;

public class Maze {
    public static void main(String[] args) {

        int[][] tablica = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
        };

        print(tablica);
        int[][] rozwiazanie = solve(tablica);
        System.out.println("------------------------------------------");
        print(rozwiazanie);
/*
        System.out.println(tablica.length);
        System.out.println(tablica[0].length);
        System.out.println(tablica[0][0]); //1
        System.out.println(tablica[0][1]); //2
        System.out.println(tablica[0][2]); //3
        System.out.println(tablica[1][0]); //4
        System.out.println(tablica[1][1]); //5
        System.out.println(tablica[1][2]); //6
        System.out.println(tablica[2][0]); //7
        System.out.println(tablica[2][1]); //8
        System.out.println(tablica[2][2]); //9
*/

    }

    public static void print(int[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }
    }

    public static int[] start(int[][] tab) {
        /**
         * Metoda znajdująca start labiryntu
         */

        int[] sta = new int[3];


        for (int i = 1; i < tab.length; i++) {
            if (tab[i][0] == 0) {
                sta[0] = 4;
                sta[1] = i;
                sta[2] = 0;
                break;
            }
        }

        if (sta[0] == 0) {
            for (int i = 1; i < tab[0].length; i++) {
                if (tab[0][i] == 0) {
                    sta[0] = 1;
                    sta[1] = 0;
                    sta[2] = i;
                }
            }
        }

        if (sta[0] == 0) {
            for (int i = 1; i < tab.length; i++) {
                if (tab[i][tab[0].length] == 0) {
                    sta[0] = 2;
                    sta[1] = i;
                    sta[2] = tab[0].length;
                }
            }
        }
        /**
         * sta[0] = 0 - nieznaleziono wejscia, 4 = wejscie z lewej, 2 wejscie z gory, 2 wejscie z prawej
         * sta[1] - współrzędna y wejścia
         * sta[2] - współrzędna x wejścia
         */
        return sta;
    }

    public static int[] step(int d, int[][] tab, int a, int b) {
        int f = 0;
        int n = 0;
        if (a + 1 < tab.length) {
            if (tab[a + 1][b] == 7) {
                f = 1;
                a++;
            }
        }
        if (b + 1 < tab[0].length) {
            if (tab[a][b + 1] == 7) {
                f = 1;
                b++;
            }
        }
        if (a > 0){
            if (tab[a - 1][b] == 7) {
                f = 1;
                a--;
            }
        }
        if (b > 0) {
            if (tab[a][b - 1] == 7) {
                f = 1;
                b--;
            }
        }

        while (f == 0 && n == 0) {
            switch (d) {
                case 4:
                    if (tab[a + 1][b] == 0) {
                        n = 1;
                        a = a + 1;
                    } else {
                        d--;
                    }
                    break;
                case 3:
                    if (tab[a][b + 1] == 0) {
                        n = 1;
                        b = b + 1;
                    } else {
                        d--;
                    }
                    break;
                case 2:
                    if (tab[a - 1][b] == 0) {
                        n = 1;
                        a = a - 1;
                    } else {
                        d--;
                    }
                    break;
                case 1:
                    if (tab[a][b - 1] == 0) {
                        n = 1;
                        b = b - 1;
                    } else {
                        d = 4;
                    }
                    break;
                default:
                    System.out.println("Error");
            }
        }
        if (d == 4) {
            d = 1;
        } else {
            d++;
        }

        int[] out = {d, a, b, f};

        return out;

    }

    public static int[][] solve(int[][] tab) {
        int tabs[][] = new int[tab.length][tab[0].length];

        int[] opt = Maze.start(tab);
        int d = opt[0];
        int a = opt[1];
        int b = opt[2];
        int f = 0; //Czy znaleźliśmy koniec
        int[] outy = new int[4];
        tabs[a][b] = 5;

        if (d == 0) {
            System.out.println("Nie udało się znaleźć wejścia labiryntu");
            return tab;
        }

        while (f == 0) {
            outy = Maze.step(d, tab, a, b);
            d = outy[0];
            a = outy[1];
            b = outy[2];
            f = outy[3];
            tabs[a][b] = 1;
        }
        if(f == 1){
            tabs[a][b] = 7;
        }


        return tabs;
    }


}
