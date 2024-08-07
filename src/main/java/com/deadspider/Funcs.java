package com.deadspider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;
import java.util.Properties;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Funcs {

    public static void main(String[] args) {
        Function<String, Integer> parse = Integer::valueOf;
        BiFunction<Integer, Integer, Integer>  adder = (x, y)->x+y;

        Supplier<Optional<Properties>> getProperties =  ()-> {
            Properties props  = new Properties();
            try {
                props.load(Files.newInputStream
                        (new File("src/main/resources/application.properties").toPath()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return Optional.of(props);
        };

        Function<String, Optional<Object>> getProperty = s -> {
            Optional<Properties> props = getProperties.get();

            if(props.isPresent()) {
                return Optional.ofNullable(getProperties.get().get().get(s));
                // if null it will mark the optional as empty
            }
            return Optional.empty();
        };

        Function<String, String> addProp = (input)-> {
            Optional<Object> prop =  getProperty.apply("adder.value");
            int add = 0;
            if(prop.isPresent()) {
                add = parse.apply(prop.get().toString());
            }
            return String.valueOf(adder.apply(parse.apply(input), add));
        };


        System.out.println("parsed: " + addProp.apply("2110"));

    }
}
