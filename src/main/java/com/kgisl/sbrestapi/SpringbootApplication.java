package com.kgisl.sbrestapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

import com.kgisl.sbrestapi.entity.Person;

// import com.kgisl.sbrestapi.entity.Person;
@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        RestClient restClient = RestClient.create("http://localhost:9090/person");

        String response = restClient.get()
                .uri("/get")
                .retrieve()
                .body(String.class);

        System.out.println("Response: " + response);
        System.out.println("-------------------------------------------------------------");
        Person article = new Person("selva@gmail.com",1, "selva");
        ResponseEntity<Void> response4 = restClient.post()
                .uri("/post")
                .contentType(APPLICATION_JSON)
                .body(article)
                .retrieve()
                .toBodilessEntity();
        System.out.println("After post Response: " + response4);
        System.out.println("-------------------------------------------------------------");
        Person article1 = new Person("hjhsj", 2, "to use  even better");
        ResponseEntity<Void> response1 = restClient.put()
                .uri("/put/2")
                .contentType(APPLICATION_JSON)
                .body(article1)
                .retrieve()
                .toBodilessEntity();

        System.out.println("Response: " + response1);
        System.out.println("-------------------------------------------------------------");
        System.out.println("After update Response: " + response);
        System.out.println("-------------------------------------------------------------");
        ResponseEntity<Void> response2 = restClient.delete()
                .uri( "/delete/1")
                .retrieve()
                .toBodilessEntity();
        System.out.println("Delete Response: " + response2);
        System.out.println("-------------------------------------------------------------");
        System.out.println("After update Response: " + response);
    }
}

//  package com.kgisl.sbrestapi;
//  import org.springframework.boot.CommandLineRunner;
//  import org.springframework.boot.SpringApplication;
//  import org.springframework.boot.autoconfigure.SpringBootApplication;
//  import org.springframework.context.annotation.Bean;
//  import org.springframework.web.client.RestTemplate;
//  import com.kgisl.sbrestapi.entity.Person;
//  @SpringBootApplication
//  public class SpringbootApplication implements CommandLineRunner {
//     @au
//      private final RestTemplate restTemplate;
//      public SpringbootApplication(RestTemplate restTemplate) {
//          this.restTemplate = restTemplate;
//      }
//      public static void main(String[] args) {
//          SpringApplication.run(SpringbootApplication.class, args);
//      }
//      @Bean
//      public RestTemplate restTemplate() {
//          return new RestTemplate();
//      }
//      @Override
//      public void run(String... args) {
//              Person response = restTemplate.getForObject("http://localhost:9090/person/get", Person.class);
//              System.out.println("Response: " + response);
//      }
//  }

