import java.util.concurrent.*;

public class ConcurrentStudentMap {
    public static void main(String[] args) throws Exception {

        ConcurrentHashMap<String, Integer> students =
                new ConcurrentHashMap<>();

        ExecutorService pool = Executors.newFixedThreadPool(5);

        long start = System.currentTimeMillis();

        for (int i = 1; i <= 5; i++) {
            final int n = i;

            pool.submit(() -> {
                for (int j = 1; j <= 1000; j++) {
                    String name = "Student" + n + "_" + j;
                    students.put(name, j);
                    students.get(name);
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        long end = System.currentTimeMillis();

        System.out.println("Number of Threads: 5");
        System.out.println("Expected Entries: 5000");
        System.out.println("Actual Entries: " + students.size());
        System.out.println("Execution Time: " + (end - start) + " ms");
    }
}
