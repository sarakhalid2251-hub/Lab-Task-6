import java.util.*;
import java.util.concurrent.*;

public class SynchronizedStudentMap {
    public static void main(String[] args) throws Exception {

        Map<String, Integer> students =
                Collections.synchronizedMap(new HashMap<>());

        ExecutorService pool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            final int n = i;

            pool.submit(() -> {
                for (int j = 1; j <= 100; j++) {
                    students.put("Student" + n + "_" + j, j);
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Expected Entries: 300");
        System.out.println("Actual Entries: " + students.size());
    }
}
