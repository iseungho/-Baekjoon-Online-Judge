import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class people {
    int age;
    String name;

    public people(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.age + " " + this.name + "\n";
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        people[] arr = new people[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new people(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(arr, new Comparator<people>() {
            @Override
            public int compare(people p1, people p2) {
                return p1.age - p2.age;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}