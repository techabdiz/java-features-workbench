package com.deadspider;

import com.deadspider.managers.PageManager;
import com.deadspider.managers.SimplePageManager;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static final String LINE_DELEMTER = "\\ ";

    public static Function<String, Stream<String>> delimitString =
                (string)->Arrays.asList(string.split(LINE_DELEMTER)).stream();

    public static Function<Stream<String>, List<String>> flatMapList =
                (s)-> s.flatMap(delimitString).toList();

    public static Function<String, Optional<List<String>>> getUrlDataInWords = (url)->{
        try {
            URL uri = new URL(url);
            return Optional.ofNullable(flatMapList.apply(new BufferedReader(new InputStreamReader(uri.openConnection().getInputStream())).lines()));
        } catch (IOException e) {
        }
        return Optional.empty();
    };

    public static Supplier<Stream<String>> getData = ()-> getUrlDataInWords.apply("https://www.ietf.org/rfc/rfc2616.txt").get().stream();



    public static void main(String[] args) {
        PageManager<String> pageman = new SimplePageManager<>();

        Consumer<String> consumer = pageman::add;
        Consumer<Stream<String>> streamConsumer = s -> s.forEach(consumer::accept);
        streamConsumer.accept(getData.get());


        System.out.println(pageman.has("aziz"));
        System.out.println(pageman.has("http"));
        System.out.println(pageman);
    }
}