package com.eren.practice.stream;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamBasic {

    public static void main(String[] args) {
        IntStream s = new Random().ints(20, 3,10);
        s.map(a -> a + 2).forEach(a -> {
                System.out.println(a);
        });
        //System.out.println(count);

        //Reducers examples
        OptionalInt reduced =
                IntStream.range(1, 6).parallel().reduce((a, b) -> {
                    System.out.println("reduced " + "a:" + a + " b:" + b);
                    return a + b;
                });
        System.out.println("reduced result:" + reduced);

        int reducedParams = Stream.of(1, 2,3,4,5)
                .reduce(10, (a, b) -> {
                    System.out.println("reducedParams " + "a:" + a + " b:" + b);
                    return a + b;
                });
        System.out.println("reducedParams result:" + reducedParams);

        int reducedParamsWithCombiner = Arrays.asList(1, 2,3,4,5).parallelStream()
                .reduce(10, (a, b) -> {
                    System.out.println("reducedParamsWithCombiner " + "a:" + a + " b:" + b);
                    return a + b;
                },(a, b) -> {
                    System.out.println("combiner was called " + "a:" + a + " b:" + b);
                    return a + b;
                });
        System.out.println("reducedParamsWithCombiner result:" + reducedParamsWithCombiner);

        Optional<Integer> max = Arrays.asList(1, 2,3,4,5).stream().reduce((a, b) -> Math.max(a,b));
        System.out.println("max: " + max.get());

        //Collectors examples
        IntStream.range(1, 5 ).mapToObj(i -> (new Product(i, "product" + i))).forEach(p -> {
            System.out.println("Product " + p);
        });

        List<Product> products = IntStream.range(1, 5 ).mapToObj(i -> (new Product(i, "product" + i))).collect(Collectors.toList());

        String stringJoin =
                products.stream().map(Product::getName).collect(Collectors.joining("," ,"(", ")"));
        System.out.println("stringJoin: " + stringJoin);

        IntSummaryStatistics intSummaryStatistics =
                products.stream().collect(Collectors.summarizingInt(Product::getId));
        System.out.println("intSummaryStatistics: " + intSummaryStatistics);

        Map map = products.stream().collect(Collectors.partitioningBy(p -> p.getId() > 2));
        Map<Integer, List<Product>> map2 = products.stream().collect(Collectors.groupingBy(Product::getId));
        Map<Integer, Map<String, List<Product>>> map3 = products.stream().collect(Collectors.groupingBy(Product::getId, groupingBy(Product::getName)));
        System.out.println("map: " + map);

        Set set = products.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::synchronizedSet));
        System.out.println("set: " + set);

        Collector<Product, ?, LinkedList<Product>> linkedListCollector =  Collector.of(LinkedList::new, LinkedList::add, (a, b) -> {
            a.addAll(b);
            return a;
        } );
        List linkedList = products.stream().collect(linkedListCollector);
        System.out.println("linkedList: " + linkedList);
    }

    private static final String REGEX = "\\s+";

    public Map<String, Long> count(URI uri) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(uri));
        Stream<String[]> streamArray = lines.map(line -> line.split(REGEX));
        Stream<String> streamLine = streamArray.flatMap(a -> Arrays.stream(a));
        Map<String, Long> wordMap = streamLine.map(word -> word.toLowerCase()).collect(Collectors.groupingBy(
                Function.identity(), TreeMap::new, Collectors.counting()));

        Set<Set<String>> set = new HashSet<Set<String>>();
        Stream<Set<String>> stream = set.stream();
        stream.flatMap(s -> s.stream());

        return Files.lines(Paths.get(uri))
                .map(line -> line.split(REGEX))
                .flatMap(Arrays::stream)
                .map(word -> word.toLowerCase())
                .collect(groupingBy(
                        identity(), TreeMap::new, counting()));
    }
}
