package com.amigoscode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }    
    

    @GetMapping("/")
    public GreetResp greet(){
        GreetResp res =  new GreetResp(
                "Hello",
                List.of("Java", "JavaScript", "Phyton"),
                new Person("Ricardo", 36, 100.00)
                );
            return res;
    }

    record Person(String name, int Age, double savings){

    }



    record GreetResp(
        String greet,
        List<String> favProgrammingLanguages,
        Person person            
    ) {}

}
