package com.grcp.cucumber;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/api/v1/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") Integer id) {
        var userResponse = new UserResponse(id);
        return ResponseEntity.ok(userResponse);
    }

    @Getter
    class UserResponse {
        private final Integer id;
        private final String name;

        public UserResponse(Integer id) {
            this.id = id;
            this.name = String.format("User name [%s]", id);
        }
    }
}
