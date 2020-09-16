package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SmartApplication {
    public static Integer selector;

    public static void main(String[] args) {
        Arrays.stream(args).forEach(arg -> {
            String[] argSplit = arg.split("=");
            if (argSplit[0].equals("selector")) {
                selector = Integer.valueOf(argSplit[1]);
            }
        });
        SpringApplication.run(SmartApplication.class, args);
    }

}
