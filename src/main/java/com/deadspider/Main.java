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
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Main {

    public static Function<String, Optional<List<String>>> getUrlDataInWords = (url)->{
        try {
            URL uri = new URL(url);
            return Optional.ofNullable(new BufferedReader(new InputStreamReader(uri.openConnection().getInputStream()))
                    .lines().flatMap(s-> Arrays.asList(s.split("\\ ")).stream())
                            .filter(s->!s.isBlank())
                    .toList());
        } catch (IOException e) {
        }
        return Optional.empty();
    };


    public static void main(String[] args) {
        PageManager<String> pageman = new SimplePageManager<>();

        getUrlDataInWords.apply("https://www.ietf.org/rfc/rfc2616.txt")
                        .ifPresent(s-> s.forEach(pageman::add));

        System.out.println(pageman);
    }
}