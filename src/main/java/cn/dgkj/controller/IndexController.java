package cn.dgkj.controller;

import com.fasterxml.jackson.databind.util.ClassUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mawt
 */
@RestController
public class IndexController {

    @Bean
    public OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory() {
        OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory();


        return factory;
    }


    @RequestMapping("/")
    public String index() {

        //Spring Boot之发送HTTP请求
        String url = "";

        RestTemplate restTemplate = new RestTemplate();

        //1. 不带参的get请求
        User user1 = restTemplate.getForObject("http://xxx.top/notice/list/1/5", User.class);
        //2. 带参数的get请求1
        User user2 = restTemplate.getForObject("http://fantj.top/notice/list/{1}/{2}", User.class, 1, 5);
        //3. 带参数的get请求2, 利用map装载参数，不过它默认解析的是PathVariable的url形式。
        Map<String, String> map = new HashMap();
        map.put("start", "1");
        map.put("page", "5");
        User user3 = restTemplate.getForObject("http://fantj.top/notice/list/", User.class, map);
        //4.
        ResponseEntity<User> userEntity = restTemplate.getForEntity("", User.class);
        User user4 = userEntity.getBody();
        HttpStatus statusCode = userEntity.getStatusCode();
        boolean xxSuccessful = statusCode.is2xxSuccessful();
        int statusCodeValue = userEntity.getStatusCodeValue();
        HttpHeaders headers = userEntity.getHeaders();

        ResponseEntity.BodyBuilder status = ResponseEntity.status(statusCode);
        status.contentLength(100);
        status.body("xxxxxxxxxxxxx");
        ResponseEntity<Class<User>> body = status.body(User.class);
        Class<User> body1 = body.getBody();


        //5
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> mapp= new LinkedMultiValueMap<>();
        mapp.add("email", "844072586@qq.com");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request , String.class );
        System.out.println(response.getBody());

        /**
         * public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables){}
         * public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables){}
         * public <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType){}
         *
         */
        return "index";
    }

}
