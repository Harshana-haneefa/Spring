package com.eazybytes.backend.controller;

import com.eazybytes.backend.dto.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/dummy/users")
public class UserController {
    @GetMapping({"/{userId}/posts/{postId}","/api/dummy/users/{userId}"})
    public ResponseEntity<String> searchUserPostWithMultiPathVariable(@PathVariable Long userId, @PathVariable (required = false) Long postId){
        String response;
        if(postId == null){
            response="Fetch user with id:" + userId;
        }else{
            response = "Fetch user with id:" + userId + " and post id: " + postId;
        }
//        return response;
//        return ResponseEntity.ok(response);
        return  ResponseEntity.ok().body(response);
    }

    @GetMapping({"/{userId}/orders/{orderId}"})
    public String searchUserOrderWithMultiPathVariables(@PathVariable(name = "userId") Long customerId,
                                                        @PathVariable Long orderId) {
        return "Fetched user with id: " + customerId + " and order id: " + orderId;
    }

    @GetMapping({"/{userId}/address/{addressId}"})
    public String searchUserAddressWithMultiPathVariables(@PathVariable Map<String , String> pathVariablesMap) {
        return "Fetched user with id: " + pathVariablesMap.get("userId") + " and Address Id: " + pathVariablesMap.get("addressId");
    }

    @GetMapping("/search")
    public String searchUserWithQueryParams(@RequestParam (required = false,defaultValue = "Guest") String name,@RequestParam (name = "gender") String sex){
        return "Fetched user with query Params : "+ name + "and gender " + sex;
    }

    @GetMapping("/search/map")
    public String searchUserWithMapQueryParams(@RequestParam Map<String, String> requestParams){
        return "Fetched user with query Params : "+ requestParams.get("name") + "and gender " + requestParams.get("gender");
    }

    @GetMapping("/headers")
    public String readRequestHeaders(@RequestHeader ("User-Agent") String userAgent, @RequestHeader (name = "User-Location", required = false , defaultValue = "Hyderabad") String userLocation){
        return "Received " + userAgent +" " + userLocation ;
    }

    @GetMapping("/headers/map")
    public String readRequestHeadersWithMap(@RequestHeader Map<String,String> requestHeaders){
        return "Received " + requestHeaders.get("User-Agent") +" " + requestHeaders.get("User-Location") ;
    }

    @GetMapping("/headers/http-headers")
    public String readRequestHeadersWithHttpHeaders(@RequestHeader HttpHeaders requestHeaders){
        return "Received " + requestHeaders.get("User-Agent") +" " + requestHeaders.get("User-Location") ;
    }

    @PostMapping
    public  String CreateUser(@RequestBody UserDto userDto){
        return "Created User with the data: "+ userDto.toString();
    }

    @PostMapping("/request-entity")
    public ResponseEntity<UserDto> createUserWithRequestEntity(RequestEntity <UserDto> requestEntity){
        HttpHeaders headers= requestEntity.getHeaders();
        UserDto userDto = requestEntity.getBody();
        String queryParams= requestEntity.getUrl().getQuery();
        String pathVariable= requestEntity.getUrl().getPath();
//        return "Created User with the data: "+ userDto.toString();
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
    
}

