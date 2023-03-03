package studio.thinkground.SpringTestProject.controller;

import org.springframework.web.bind.annotation.*;
import studio.thinkground.testproject.dto.MemberDTO;

import java.util.Map;
import java.util.Objects;

@RestController
public class HelloController {

    //    구버전
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    신버전
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
/*
    @PathVariable
    GET 형식의 요청에서 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법
    아래 방식은 @GetMapping에서 사용된 {변수}의 이름과 메소드의 매개변수와 일치시켜야 함
 */
//    @GetMapping(value = "/variable1/{variable}")
//    public String getVariable1(@PathVariable String variable){
//        return variable;
//    }

    /*
    @PathVariable
    GET 형식의 요청에서 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법
    아래 방식은 @GetMapping에서 사용된 {변수}의 이름과 메소드의 매개변수와 다를 경우 사용하는 방식
    변수의 관리의 용이를 위해 사용되는 방식
 */
//    @GetMapping(value = "/variable1/{variable}")
//    public String getVariable2(@PathVariable("variable") String var){
//        return var;
//    }

    /*
        @RequestParam
        GET형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
        '?'를 기준으로 우측에 {키} = {값}의 형태로 전달되며, 복수 형태로 전달할 경우 & 를 사용함
        http://localhost:8080/api/v1/get-api/request1?name=flature&email=a@gmail.com&organization=thinkground
     */
//    @GetMapping(value = "/request")
//    public String getRequestParam1(@RequestParam String name, @RequestParam String email, @RequestParam String organization){
//        return name + "" + email + "" + organization;
//    }


    /*
        @RequstParam
        GET형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
        아래 예시 코드는 어떤 요청 값이 들어올지 모를 경우 사용하는 방식
        http://localhost:8080/api/v1/get-api/request2?name=flature&email=a@gmail.com&organization=thinkground
     */

//    @GetMapping(value = "/request2")
//    public String getRequestParam2(@RequestParam Map<String, String> param){
//        StringBuilder sb = new StringBuilder();
//
//        param.entrySet().forEach(map -> {
//            sb.append(map.getKey()+ ":" + map.getValue() + "\n");
//        });
//        return sb.toString();
//    }

    /*
        DTO 사용
        GET형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
        key와 value가 정해져있지만, 받아야할 파라미터가 많을 경우 DTO 객체를 사용한 방식
     */

//    @GetMapping(value = "/request3")
//    public String getRequestParam3(MemberDTO memberDTO){
//        return memberDTO.getName() + "" + memberDTO.getEmail() + "" + memberDTO.getOrganization();
//        return memberDTO.toString();
//    }

    /*
        Post API
        리소스를  추가하기 위해 사용되는 API
        @PostMapping : POST API를 제작하기 위해 사용되는 어노테이션(Annotation)
                        @RequestMapping + POST method 의 조합
        일반적으로 추가하고자 하는 Resource를 http body에 추가하여 서버에 요청
        그렇기 때문에 @RequestBody를 이용하여 body에 담겨있는 값을 받아야함
     */

//    http://localhost:8080/api/v1/pist-api/member
//    @PostMapping(value = "/member")
//    public String postMember(@RequestBody Map<String, Object> postData) {
//        StringBuilder sb = new StringBuilder();
//
//        postData.entrySet().forEach(map-> {
//            sb.append(map.getKey() + ":" + map.getValue() + "\n");
//        });
//
//        return sb.toString();
//    }


    /*
        DTO 사용
        key와 value가 정해져있지만, 받아야할 파라미터가 많을 경우 DTO객체를 사용한 방식
     */

//    @PostMapping(value = "/member2")
//    public String postMemberDto(@RequestBody MemberDTO memberDTO) {
//        return memberDTO.toString();
//    }


    /*
        Swagger란?
        서버로 요청되는 API 리스트를 HTML 화면으로 문서화하여 테스트 할 수 있는 라이브러리
        이 라이브러리는 서버가 가동되면서 @RequestController를 읽어 API를 분석하여 HTML 문서를 작성함
        작성일(21.07.24) 기준 3.0.0 버전까지 출시되었음

        Swagger가 필요한 이유
        REST API의 스펙을 문서화 하는 것은 매우 중요
        API를 변경할 때마다 Reference 문서를 계속 바꿔야하는 불편함이 있음

        Swagger 설정 방법
        @Configuration : 어노테이션 기반의 환경 구성을 돕는 어노테이션
                         IOC Container에게 해당 클래스를 Bean 구성 Class 임을 알려줌

        @Bean : 개발자가 직접 제어가 불가능한 외부 라이브러리 등을 Bean으로 만들 경우에 사용
     */

    /*
        Put API
        해당 리소스가 존재하면 갱신하고, 리소스가 없을 경우에는 새로 생성해주는 API
        업데이트를 위한 메소드
        기본적인 동작 방식은 Post API와 동일

        Delete API
        서버를 통해 리소스를 삭제하기 위해 사용되는 API
        일반적으로 @PathVariable을 통해 리소스 ID 등을 받아 처리

        ResponseEntity
        Spring Framework에서 제공하는 클래스 중 HttpEntity라는 클래스를 상속받아  사용하는 클래스
        사용자의 HttpRequest에 대한 응답 데이터를 포함

        포함하는 클래스
        - HttpStatus
        - HttpHeaders
        - HttpBody
     */

    /*
        Lombok
        반복되는 메소드를 Annotation을 사용하여 자동으로 작성해주는 라이브러리
        일반적으로 VO, DTO, Model, Entity 등의 데이터 클래스에서 주로 사용됨

        대표적으로 많이 사용되는 Annotation
        - @Getter
        - @Setter
        - @NoArgConstructor
        - @AllArgConstructor
        - @Data
        - @ToString

        Lombok의 대표적인 어노테이션

        @Getter / @Setter
        - 해당클래스에 선언되어 있는 필드를 기반으로 'getField', 'setField'와 같은 식으로 자동으로 메소드 설정

        @NoArgConstructor : 파라미터가 없는 생성자를 생성
        @AllArgConstructor : 모든 필드값을 파라미터로 갖는 생성자를 생성
        @RequiredArgsConstructor : 필드값 중 final이나 @NotNull인 값을 갖는 생성자를 생성 (많이 사용되지 않는다.)

        @ToString : toString 메소드 자동으로 생성해주는기능
        @ToString 어노테이션에 exclude 속성을 사용하여 특정 필드를 toString에서 제외시킬 수 있음

        @EqualsAndHashCode
        equals, hashCode 메소드를 자동으로 생성

        equals : 두 객체의 내용(필드값)이 같은지 동등성(equality)를 비교하는 연산자
        hashCode : 두 객체가 같은 객체인지 동일성(identity)를 비교하는 연산자

        callSuper 속성을 통해 메소드 생성시 부모 클래스의 필드까지 고려할지 여부 설정 가능
        - callSuper = true -> 부모 클래스(superClass) 필드 값들도 동일한지 체크

        @Data
        해당 어노테이션을 사용하면, 앞서 나온 기능들을 한번에 추가해줌 ( -> 불필요한 메서드 추가로 기피하는 경향이 있다 / 사용시 유의해야함)
        - @Getter / @Setter / @RequiredArgsConstructor / @ToString

     */

    /*
        Entity(Domain)
        데이터베이스에 쓰일 컬럼과 여러 엔티티 간의 연관관계를 정의
        데이터베이스의 테이블을 하나의 엔티티로 생각해도 무방함
        실제 데이터베이스의 테이블과 1:1로 매핑됨
        이 클래스의 필드는 각 테이블 내부의 컬럼(Column)을 의미

        Repository
        Entity에 의해 생성된 데이터베이스에 접근하는 메소드를 사용하기 위한 인터페이스
        Service와 DB를 연결하는 고리의 역할을 수행
        데이터베이스에 적용하고자 하는 CRUD를 정의하는 영역

        DAO(Data Access Object)
        데이터베이스에 접근하는 객체를 의미( Persistance Layer)
        Service가 DB에 연결할 수 있게 해주는 역할
        DB를 사용하여 데이터를 조회하거나 조작하는 기능을 전담

        DTO(Data Transfer Object)
        DTO는 VO(Value Object)로 불리기도 하며, 계층간 데이터 교환을 위한 객체를 의미
        VO의 경우 Read Only의 개념을 가지고 있음
        (데이터를 옮겨 주기
        위한 객체)
     */




}
