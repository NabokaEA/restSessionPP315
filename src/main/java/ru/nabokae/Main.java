package ru.nabokae;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

/*..........................В первом запросе получаем session id через cookie.........................................................*/
        RestTemplate template = new RestTemplate();
        String url = "http://94.198.50.185:7081/api/users";

        ResponseEntity<String> responseEntity = template.getForEntity(url, String.class);
        System.out.println(responseEntity);
        String cookies = responseEntity.getHeaders().get("Set-Cookie").toString();
        System.out.println(cookies);

        /*..........................Второй запрос.........................................................*/
        User user = new User(3L,"James","Brown", (byte) 45);
        RestTemplate restTemplate2 = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Cookie",cookies);
        headers2.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity2 = new HttpEntity(user, headers2);
        ResponseEntity<String> responseEntity2 = restTemplate2.exchange(url, HttpMethod.POST, requestEntity2, String.class);
        System.out.println(responseEntity2.getBody());

        /*..........................Третий запрос.........................................................*/
        user.setName("Thomas");
        user.setLastName("Shelby");
        RestTemplate restTemplate3 = new RestTemplate();
        HttpHeaders headers3 = new HttpHeaders();
        headers3.add("Cookie",cookies);
        headers3.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity3 = new HttpEntity(user, headers3);
        ResponseEntity<String> responseEntity3 = restTemplate3.exchange(url, HttpMethod.POST, requestEntity3, String.class);
        System.out.println(responseEntity3.getBody());

        /*..........................Четвертый запрос.........................................................*/

        RestTemplate restTemplate4 = new RestTemplate();
        HttpHeaders headers4 = new HttpHeaders();
        headers4.add("Cookie",cookies);
        headers4.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity4 = new HttpEntity(user, headers4);
        ResponseEntity<String> responseEntity4 = restTemplate4.exchange (url+"/"+2,HttpMethod.DELETE, requestEntity4, String.class);
        System.out.println(responseEntity4.getBody());



    }
}