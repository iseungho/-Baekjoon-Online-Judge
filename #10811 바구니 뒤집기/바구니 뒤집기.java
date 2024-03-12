import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {

            arr[i] = i + 1;
        }
        for (int x = 0; x < row; x++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            while (i < j) {
                int temp = arr[j - 1];
                arr[j - 1] = arr[i - 1];
                arr[i - 1] = temp;
                i++;
                j--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
