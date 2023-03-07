//package studio.thinkground.SpringTestProject.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.lang.reflect.Member;
//
//@RestController
//@RequestMapping("/api/server")
//public class TestController {
//
//    private final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
//
//    @GetMapping(value = "/around-hub")
//    public String getTest1(){
//        LOGGER.info("getTEST1 호출!");
//        return "Hello. Around Hub Studio!";
//    }
//
//    @GetMapping(value = "/name")
//    public String getTest2(@RequestParam String name){
//        LOGGER.info("getTEST2 호출!");
//        return "Hello" + name + "!";
//    }
//
//    @GetMapping(value = "/path-variable/{name}")
//    public String getTest3(@PathVariable String name){
//        LOGGER.info("getTEST3 호출!");
//        return "Hello" + name + "!";
//    }
//
//    @PostMapping(value = "/member")
//    public ResponseEntity<studio.thinkground.testproject.dto.MemberDTO> getMember(
//            @RequestBody studio.thinkground.testproject.dto.MemberDTO memberDTO,
//            @RequestParam String name,
//            @RequestParam String email,
//            @RequestParam String organization
//            ){
//
//        LOGGER.info("getMember 호출!");
//
//        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
//    }
//
//    @PostMapping(value = "/add-header")
//    public ResponseEntity<studio.thinkground.testproject.dto.MemberDTO> addHeader(@RequestHeader("around-header") String header, @RequestBody studio.thinkground.testproject.dto.MemberDTO memberDTO) {
//        LOGGER.info("add-header 호출!");
//        LOGGER.info("header 값 : {}", header);
//
//        return ResponseEntity.status(HttpStatus.OK).body(memberDTO);
//    }
//}
