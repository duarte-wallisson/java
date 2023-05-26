import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 4, 5, 11, 7, 9);
        Stream<Integer> stream1 = list.stream();
        System.out.println(Arrays.toString(stream1.toArray()));

        Stream<String> stream2 = Stream.of("Eduardo", "Monica", "Wallisson");
        System.out.println(Arrays.toString(stream2.toArray()));

        Stream<Integer> stream3 = Stream.iterate(0, x -> x+2);
        System.out.println(Arrays.toString(stream3.limit(10).toArray()));

        Stream<Long> stream4 = Stream.iterate(new Long[]{0L, 1L}, p-> new Long[]{ p[1], p[0]+p[1]}).map(p-> p[0]);
        System.out.println(Arrays.toString(stream4.limit(50).toArray()));

        Integer[] integers = {1, 211, 200, 10};
        Stream<Integer> stream5 = Arrays.stream(integers);
        System.out.println(Arrays.toString(stream5.toArray()));
    }
}