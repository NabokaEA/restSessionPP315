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
        HttpHeaders headers = new HttpHeaders();
        headers.set("Cookie",cookies);
        //headers.add("Cookie", cookies);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity requestEntity = new HttpEntity(user, headers);

        ResponseEntity<String> responseEntity2 = restTemplate2.postForEntity(url,user, String.class);
        //ResponseEntity response = restTemplate1.exchange(url, HttpMethod.POST, requestEntity, User.class);
        System.out.println(responseEntity2.getBody());

        /*..........................Третий запрос.........................................................*/









    }
}