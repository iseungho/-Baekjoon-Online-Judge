import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        Integer[] arr = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            arr[i] = (int) N.charAt(i);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] - 48);
        }
    }
}