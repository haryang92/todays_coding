package studio.thinkground.SpringTestProject.controller;

import org.springframework.web.bind.annotation.*;
import studio.thinkground.SpringTestProject.data.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //    http://localhost:8080/api/v1/post-api/default
    @PostMapping(value = "/default")
    public String postMethod() {
        return "Hello World!";
    }
    //    http://localhost:8080/api/v1/pist-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map-> {
            sb.append(map.getKey() + ":" + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO) {
        return memberDTO.toString();
    }
}

