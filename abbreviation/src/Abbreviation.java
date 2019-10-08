import java.io.File;
import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Abbreviation {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("input04.txt"));
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine();
            String line2 = scanner.nextLine();
            boolean res = check(
                    line1,
                    line2);
            System.out.println(res);
        }
    }

    public  static boolean check(String a, String b) {
        boolean[][] m = new boolean[a.length() + 1][b.length() + 1];
        m[0][0] = true;
        for (int i = 0; i < a.length(); i++) {
            m[i + 1][0] = Character.isLowerCase(a.charAt(i));
            if (!m[i + 1][0]) {
                break;
            }
        }

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j) || Character.toUpperCase(a.charAt(i)) == b.charAt(j)) {
                    m[i + 1][j + 1] = m[i][j] || Character.isLowerCase(a.charAt(i)) && m[i][j + 1];
                } else {
                    m[i + 1][j + 1] = Character.isLowerCase(a.charAt(i))?m[i][j + 1]:false;
                }
            }
        }

        return m[m.length - 1][m[0].length - 1];
    }
}