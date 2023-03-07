# ✏ SpringBoot-기초 강의
유튜브 - 어라운드 허브 스튜디오 강의 따라하기


## 🕰️ 스터디 기간
• 23.02.28일 - 23.03.06일


## 🔗 강의 URL
<https://www.youtube.com/watch?v=7t6tQ4KV37g>

## 📌 스터디 내용
### @PathVariable
- GET 형식의 요청에서 파라미터를 전달하기 위해 URL에 값을 담아 요청하는 방법

### 1. @RequestParam
- GET형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
- '?'를 기준으로 우측에 {키} = {값}의 형태로 전달되며, 복수 형태로 전달할 경우 & 를 사용함
    
### 2. DTO 사용
- GET형식의 요청에서 쿼리 문자열을 전달하기 위해 사용되는 방법
- key와 value가 정해져있지만, 받아야할 파라미터가 많을 경우 DTO 객체를 사용한 방식

### 3. Post API
- 리소스를  추가하기 위해 사용되는 API
- @PostMapping : POST API를 제작하기 위해 사용되는 어노테이션(Annotation)


  ((@RequestMapping + POST method 의 조합))
- 일반적으로 추가하고자 하는 Resource를 http body에 추가하여 서버에 요청
- 그렇기 때문에 @RequestBody를 이용하여 body에 담겨있는 값을 받아야함

### 4. Swagger란?
- 서버로 요청되는 API 리스트를 HTML 화면으로 문서화하여 테스트 할 수 있는 라이브러리
- 이 라이브러리는 서버가 가동되면서 @RequestController를 읽어 API를 분석하여 HTML 문서를 작성함

### Swagger가 필요한 이유
- REST API의 스펙을 문서화 하는 것은 매우 중요
- API를 변경할 때마다 Reference 문서를 계속 바꿔야하는 불편함이 있음

### Swagger 설정 방법
- @Configuration : 어노테이션 기반의 환경 구성을 돕는 어노테이션/
                         IOC Container에게 해당 클래스를 Bean 구성 Class 임을 알려줌
- @Bean : 개발자가 직접 제어가 불가능한 외부 라이브러리 등을 Bean으로 만들 경우에 사용

### 5. Put API
- 해당 리소스가 존재하면 갱신하고, 리소스가 없을 경우에는 새로 생성해주는 API
- 업데이트를 위한 메소드
- 기본적인 동작 방식은 Post API와 동일

### 6. Delete API
- 서버를 통해 리소스를 삭제하기 위해 사용되는 API
- 일반적으로 @PathVariable을 통해 리소스 ID 등을 받아 처리

### 7. ResponseEntity
- Spring Framework에서 제공하는 클래스 중 HttpEntity라는 클래스를 상속받아  사용하는 클래스
- 사용자의 HttpRequest에 대한 응답 데이터를 포함

#### 포함하는 클래스
- HttpStatus
- HttpHeaders
- HttpBody

### 8. Lombok
- 반복되는 메소드를 Annotation을 사용하여 자동으로 작성해주는 라이브러리
- 일반적으로 VO, DTO, Model, Entity 등의 데이터 클래스에서 주로 사용됨

#### 대표적으로 많이 사용되는 Annotation
- @Getter
- @Setter
- @NoArgConstructor
- @AllArgConstructor
- @Data
- @ToString

1) @Getter / @Setter
- 해당클래스에 선언되어 있는 필드를 기반으로 'getField', 'setField'와 같은 식으로 자동으로 메소드 설정
2) @NoArgConstructor : 파라미터가 없는 생성자를 생성
3) @AllArgConstructor : 모든 필드값을 파라미터로 갖는 생성자를 생성
4) @RequiredArgsConstructor : 필드값 중 final이나 @NotNull인 값을 갖는 생성자를 생성 (많이 사용되지 않는다.)
5) @ToString : toString 메소드 자동으로 생성해주는기능 / @ToString 어노테이션에 exclude 속성을 사용하여 특정 필드를 toString에서 제외시킬 수 있음
6) @EqualsAndHashCode
- equals, hashCode 메소드를 자동으로 생성

* equals : 두 객체의 내용(필드값)이 같은지 동등성(equality)를 비교하는 연산자
* hashCode : 두 객체가 같은 객체인지 동일성(identity)를 비교하는 연산자

* callSuper 속성을 통해 메소드 생성시 부모 클래스의 필드까지 고려할지 여부 설정 가능
- callSuper = true -> 부모 클래스(superClass) 필드 값들도 동일한지 체크

7) @Data
- 해당 어노테이션을 사용하면, 앞서 나온 기능들을 한번에 추가해줌 ( -> 불필요한 메서드 추가로 기피하는 경향이 있다 / 사용시 유의해야함)
- @Getter / @Setter / @RequiredArgsConstructor / @ToString


![image](https://user-images.githubusercontent.com/73573088/223068178-d6d21ec7-608d-46f6-9a94-0be7429ef654.png)


### 9. Entity(Domain)
- 데이터베이스에 쓰일 컬럼과 여러 엔티티 간의 연관관계를 정의
- 데이터베이스의 테이블을 하나의 엔티티로 생각해도 무방함
- 실제 데이터베이스의 테이블과 1:1로 매핑됨
- 이 클래스의 필드는 각 테이블 내부의 컬럼(Column)을 의미

### 10. Repository
- Entity에 의해 생성된 데이터베이스에 접근하는 메소드를 사용하기 위한 인터페이스
- Service와 DB를 연결하는 고리의 역할을 수행
- 데이터베이스에 적용하고자 하는 CRUD를 정의하는 영역

### 11. DAO(Data Access Object)
- 데이터베이스에 접근하는 객체를 의미( Persistance Layer)
- Service가 DB에 연결할 수 있게 해주는 역할
- DB를 사용하여 데이터를 조회하거나 조작하는 기능을 전담

### 12. DTO(Data Transfer Object)
- DTO는 VO(Value Object)로 불리기도 하며, 계층간 데이터 교환을 위한 객체를 의미
- VO의 경우 Read Only의 개념을 가지고 있음
- (데이터를 옮겨 주기 위한 객체)

### 13. ORM(Object Relational Mapping)
#### ORM 이란 ? 
- 어플리케이션의 객체와 관계형 데이터베이스의 데이터를 자동으로 매핑해주는 것을 의미
    - JAVA의 데이터 클래스와 관계형 데이터 베이스의 테이블을 매핑
- 객체지향 프로그래밍과 관계형 데이터베이스의 차이로 발생하는 제약사항을 해결해주는 역할을 수행 
- 대표적으로 JPA, Hibernate 등이 있음(Persistent API)

![image](https://user-images.githubusercontent.com/73573088/223067908-ece04561-7543-41e8-a343-0375ade05b6b.png)

#### ORM 장점
- SQL 쿼리가 아닌 직관적인 코드로 데이터를 조작할 수 있음
    - 개발자가 보다 비즈니스 로직에 집중할 수 있음
- 재사용 및 유지보수가 편리
    - ORM은 독립적으로 작성되어 있어 재사용이 가능
    - 매핑정보를 명확하게 설계하기 때문에 따로 데이터베이스를 볼 필요가 없음
- DBMS에 대한 종속성이 줄어듬
    - DBMS를 교체하는 작업을 비교적 적은 리스크로 수행 가능

#### ORM 단점
- 복잡성이 커질 경우 ORM만으로는 구현하기 어려움
    - 직접 쿼리를 구현하지 않아 복잡한 설계가 어려움
- 잘못 구현할 경우 속도 저하 발생
- 대형 쿼리는 별도의 튜닝이 필요할 수 있음

### 14. JPA(Java Persistance API)
#### JPA 란 ? 
- JPA는 Java Persistance API의 줄임말이며, ORM과 관련된 인터페이스의 모음
- JAVA 진영에서 표준 ORM으로 채택되어 있음
- ORM이 큰 개념이라고 하면, JPA는 더 구체화 시킨 스펙을 포함하고 있음

![image](https://user-images.githubusercontent.com/73573088/223068882-f91b4657-ddc1-4614-bb78-2c8491fb69b3.png)

#### Hibernate 
- ORM Framework 중 하나
- JPA의 실제 구현체 중 하나이며, 현재 JPA 구현체 중 가장 많이 사용됨 

![image](https://user-images.githubusercontent.com/73573088/223070647-43def6de-c69c-411b-9b7b-0cdd754385d9.png)
- 상속과 관련된 내용

#### Spring Data JPA
- Spring Framework에서 JPA를 편리하게 사용할 수 있게 지원하는 라이브러리
    - CRUD 처리용 인터페이스 제공
    - Repository 개발 시 인터페이스만 작성하면 구현 객체를 동적으로 생성해서 주입
    - 데이터 접근 계층 개발시 인터페이스만 작성해도 됨
- Hibernate에서 자주 사용되는 기능을 조금 더 쉽게 사용할 수 있게 구현

![image](https://user-images.githubusercontent.com/73573088/223069909-bcee6627-bd89-446a-a5f2-2db985b20d81.png)

### 15. Logback
#### Logback 이란?
Logback이란 Log4J를 기반으로 개발된 로깅(Logging) 라이브러리
log4j에 비해 약 10배 정도 빠른 퍼포먼스, 메모리 효율성 증대 

* 출시 순서 : log4j -> logback -> log4j2

#### Logback 특징
- 로그에 특정 레벨을 설정할 수 있음(Trace -> Debug -> Info -> Warn -> Erro) *중요도순서
- 실운영과 테스트 상황에서 각각 다른 출력 레벨을 설정하여 로그를 확인할 수 있음
- 출력 방식에 대해 설정할 수 있음
- 설정 파일을 일정 시간마다 스캔하여 어플리케이션 중단 없이 설정 변경 가능
- 별도의 프로그램 없이 자체적으로 로그 압축을 지원
- 로그 보관 기간 설정 가능

#### Logback 구조
![image](https://user-images.githubusercontent.com/73573088/223153159-4c3a3265-4d22-4e17-9990-3712ed6666ec.png)

#### Logback 설정
- 일반적으로 Classpath에 있는 logback 설정 파일을 참조하게 됨 
    - Java Legacy, Spring의 경우에는 logback.xml 파일을 참조
    - Spring Boot의 경우에는 logback-spring.xml 파일을 참조
    
#### Logback 설정파일 형식
![image](https://user-images.githubusercontent.com/73573088/223154199-06a69d24-e7d9-40bd-96e2-70a5fa03c4bf.png)

#### appender
- Log의 형태 및 어디에 출력할지 설정하기 위한 영역
- 대표적인 Appender 형식은 아래와 같음 
    - ConsoleAppender : 콘솔에 로그를 출력
    - FileAppender : 파일에 로그를 출력
    - RollingFileAppender : 여러 개의 파일을 순회하며 로그를 저장
    - SMTPAppender : 로그를 메일로 보냄
    - DBAppender : 데이터베이스에 로그를 저장
![image](https://user-images.githubusercontent.com/73573088/223155095-c1b2c1f6-1c13-46d3-8dda-584908852e45.png)

#### encoder
- Appender 내에 포함되는 항목이며, pattern을 사용하여 원하는 형식으로 로그를 표현할 수 있음 
![image](https://user-images.githubusercontent.com/73573088/223156320-1350bbb7-3755-4dfa-9082-6aeccb9d4931.png)

#### root
- 설정한 Appender를 참조하여 로그의 레벨을 설정할 수 있음
- root는 전역 설정이며, 지역 설정을 하기 위해서는 logger를 사용
![image](https://user-images.githubusercontent.com/73573088/223156374-181137aa-37f3-4f2f-ad50-d47656e5c388.png)

#### 로그 레벨
Trace -> Debug -> Info -> Warn -> Error
1) Error : 로직 수행 중에 오류가 발생한 경우, 시스템적으로 심각한 문제가 발생하여 작동이 불가한 경우
2) Warn : 시스템 에러의 원인이 될 수 있는 경고 레벨, 처리 가능한 사항
3) Info : 상태변경과 같은 정보성 메시니
4) Debug : 어플리케이션의 디버깅을 위한 메시지 레벨
5) Trace : Debug 레벨보다 더 디테일한 메시지를 표현하기 위한 레벨
* 예를들서, 로그 레벨을 'Info'라고 설정했을 경우, 'Trace', 'Debug'레벨은 출력되지 않음

#### pattern
![image](https://user-images.githubusercontent.com/73573088/223157673-dc81483c-f386-49e2-8b7d-e912758cab17.png)

### 16. 유효성 검사 / 데이터 검증 (Validation)
#### 유효성 검사란?
- 서비스의 비즈니스 로직이 올바르게 동작하기 위해 사용되는ㄴ 데이터에 대한 사전 검증하는 작업이 필요함
- 유효성 검사 혹은 데이터 검증이라고 부르는데, 흔히 Validation이라고 부름
- 데이터 검증은 여러 계층에서 발생하는 흔한 작업
- Validation은 들어오는 데이터에 대해 의도한 형식의 값이 제대로 들어오는지 체크하는 과정을 뜻함

#### 일반적인 Validation의 문제점
- 일반적인 어플리케이션에서 사용되던 Validation 방식은 몇가지 문제가 존재
    - 어플리케이션 전체적으로 분산되어 존배
    - 코드의 중복이 심함(코드가 복잡해짐)
    - 비즈니스 로직에 섞여 있어 검사 로직 추적이 어려움
    
![image](https://user-images.githubusercontent.com/73573088/223295969-e27b1b7f-ee24-481d-95a9-de3f894a258d.png)

#### Bean Validation / Hibernate Validator 
- 앞서 나온 문제를 해결하기 위해 Java에서 2009년부터 Bean Validation이라는 데이터 유효셩 검사 프레임워크를 제공
- Bean Validation은 어노테이션을 통해 다양한 데이터를 검증할 수 있게 기능을 제공
- Hibernate Validator는 Bean Validation 명세에 대한 구현체 
- Spring Boot의 유효성 검사 표준은 Hibernate Validator를 채택
- 이전 버전의 Spring Boot에서는 starter-web에 validation이 포함되어 있었지만, 2.3버전 부터는 starter-validation을 추가해야함

#### Validation 관련 어노테이션
- @Size : 문자의 길이 조건
- @NotNull : null 값 불가
- @NotEmpty : @NotNull + ""값 불가
- @NotBlank : @NotEmpty + " "값 불가
- @Past : 과거 날짜 
- @PastOrPresent : @Past + 오늘 날짜 
- @Future: 미래 날짜 
- @FutureOrPresent : @Future + 오늘 날짜 
- @Pattern : 정규식을 통한조건
- @Max : 최대값 조건 설정 
- @Min : 최소값 조건 설정
- @AssertTrue / AssertFalse : 참/거짓 조건 설정
- @Valid : 해당 객체의 유효성 검사

### 17. 예외 처리(Exception)
#### 스프링 부트의 예외 처리 방식 
- 스프링 부트의 예외 처리 방식은 크게 2가지가 존재
    - @ControllerAdvice를 통한 모든 Controller에서 발생할 수 있는 예외 처리 
    - @ExceptionHandler를 통한 특정 Controller의 예외 처리 
    - @ControllerAdvice로 모든 컨트롤러에서 발생할 예외를 정의하고, @ExceptionHandler를 통해 발생하는 예외마다 처리할 메소드를 정의

#### 예외 클래스
![image](https://user-images.githubusercontent.com/73573088/223298980-41715b87-0e71-4bb9-b6cc-eb6c4be1c115.png)

- 모든 예외 클래스는 Throwable 클래스를 상속 받고 있음
- Exception은 수많은 자식 클래스가 있음
- RuntimeException은 Unchecked Exception이며, 그 외 Excption은 Checked Exception으로 볼 수 있음

![image](https://user-images.githubusercontent.com/73573088/223299388-23b40871-7475-4cb6-8830-90166ae0349e.png)

#### @ControllerAdvice, @RestControllerAdvice
- @ControllerAdvice는 Spring에서 제공하는 어노테이션
- @Controller나 @RestController에서 발생하는 예외를 한 곳에서 관리하고 처리할 수 있게 하는 어노테이션
- 설정을 통해 범위 지정이 가능하며, Defalut 값으로 모든 Controller에 대해 예외 처리를 관리함
    - @RestContrllerAdvice(basePackages = "aroundhub.thinkground.studio")와 같이 패키지 범위를 설정할 수 있음
-예외 발생 시 json의 형태로 결과를 반환하기 위해서는 @RestControllerAdvice를 사용하면 됨

#### @ExceptionHandler
- 예외 처리 상황이 발생하면 해당 Handler로 처리하겠다고 명시하는 어노테이션
- 어노테이션 뒤에 괄호를 붙여 어떤 ExceptionClass를 처리할지 설정할 수 있음
    - @ExceptionHandler(00Exception.class)
- Exception.class는 최상위 클래스로 하위 세부 예외 처리 클래스로 설정한 핸들러가 존재하면, 그 핸들러가 우선처리하게 되며, 처리 되지 못하는 예외 처리에 대해 ExceptionClass에서 핸들링함
- @ControllerAdvice로 설정된 클래스 내에서 메소드로 정의할 수 있지만, 각 Controller 안에 설정도 가능
- 전역 설정(@ControllerAdvice)보다 지역 설정(Controller)으로 정의한 Handler가 우선순위를 가짐

#### 우선순위 도식화 
![image](https://user-images.githubusercontent.com/73573088/223300996-2359554a-023d-443d-a72f-8915a2b34590.png)
![image](https://user-images.githubusercontent.com/73573088/223301054-b3dfa422-188f-4651-aeba-2507ef6f1aad.png)

### 18. Custom Exception 
#### 목표하는 에러 응답 예시
- 아래와 같이 error type, error code, message를 응답함으로써 Client에 정확히 어떤 에러가 발생했는지 공유하는 것
![image](https://user-images.githubusercontent.com/73573088/223303348-fccceef4-bf9d-4f54-a7bb-dc3f0c590726.png)

#### Exceprion 구조
![image](https://user-images.githubusercontent.com/73573088/223303561-41b73edb-aa52-4764-be3e-291ac7561123.png)

#### Throwable 구조
![image](https://user-images.githubusercontent.com/73573088/223303663-3a90522b-c359-4237-bb19-3719e7cb2de6.png)

#### HttpStatus 
- HttpStatus는 Enum 클래스임
- Enum 클래스 
    - 서로 관련 있는 상수들을 모아 심볼릭한 명칭의 집합으로 정의한 것
    - 클래스 처럼보이게 하는 상수
    
![image](https://user-images.githubusercontent.com/73573088/223303983-9403287c-946b-416a-b1a1-719e54cd7a18.png)

#### Custom Exception
- error type, error code, message에서 필요한 내용은 아래와 같음
    - error type : HttpStatus의 reasonPhrase
    - error code : HttpStatus의 value
    - message : 상황별 디테일 message

![image](https://user-images.githubusercontent.com/73573088/223304487-8317ef21-4b35-464f-b1e3-da87b56b82a3.png)

### 19. Rest Template
#### RestTemplate 이란?
- 스프링에서 제공하는 HTTP통신 기능을 쉽게 사용할 수 있게 설계되어 있는 템플릿
- HTTP 서버와의 통신을 단순화하고 RESTful 원칙을 지킴
- 동기 방식으로 처리되며, 비동기 방식으로는 AsyncRestTemplate이 있음
- RestTemplate 클래스는 REST 서비스를 호출하도록 설계되어 HTTP 프로토콜의 메소드에 맞게 여러 메소드를 제공

#### RestTemplate의 여러 메소드
![image](https://user-images.githubusercontent.com/73573088/223341947-20e71bea-0d67-45b8-b159-3aaaae64c4c1.png)

### 20. JUnit
#### TDD(Test-Driven-Development)에 대한 간단한 정리
- 테스트 주도 개발이라는 의미를 가짐
- 단순하게 표현하자면 테스트를 먼저설계 및 구축 후 테스트를 통과할 수 있는 코드를 짜는 것
- 코드 작성 후 테스트를 진행하는 지금까지 사용된 일반적인 방식과 다소 차이가 있음
- 애자일 개발 방식 중 하나
    - 코드 설계시 원하는 단계적 목표에 대해 설정하여 진행하고자 하는 것에대한 결정 방향의 갭을 줄이고자 함
    - 최초 목표에 맞춘 테스트를 구축하여 그에 맞게 코드를 설계하기 때문에 보다 적은 의견 충돌을 기대할 수 있음(방향 일치로 인한 피드백과 진행 방향의 충돌 방지)

#### 테스트 코드를 작성 목적
- 코드의 안전성을 높일 수 있음
- 기능을 추가하거나 변경하는 과정에서 발생할 수 있는 Side-Effect를 줄일 수 있음
- 해당 코드가 작성된 목적을 명확하게 표현할 수 있음
    - 코드에 불필요한 내용이 들어가는 것을 비교적 줄일 수 있음

#### JUnit 이란?
- JAVA 진영의 대표적인 Test Framework
- 단위 테스트(Unit Test)를 위한 도구를 제공
    - 단위 테스트란 ? 
        - 코드의 특정 모듈이 의도된 대로 동작하는지 테스트 하는 절차를 의미
        - 모든 함수와 메소드에 대한 각각의 테스트 케이스(Test Case)를 작성하는 것
- 어노테이션(Annotation)을 기반으로 테스트를 지원
- 단정문(Assert)으로 테스트 케이스의 기대값에 대해 수행 결과를 확인할 수 있음
- Spring Boot 2.2버전부터 JUnit 5버전을 사용
- JUnit 5는 크게 Jupiter, Platform, Vintage 모듈로 구성됨

#### JUnit Jupiter
- TestEngine API 구현체로 JUnit 5를 구현하고 있음
- 테스트의 실제 구현체는 별도 모듈 역할을 수행하는데, 그 모듈 중 하나가 Jupiter-Engine임 
- 이 모듈은 Jupiter-API를 작성한 테스트 코드를 발견하고 실행하는 역할을 수행
- 개발자가 테스트 코드를 작성할 때 사용됨

#### JUnit Platform
- Test를 실행하기 위한 뼈대
- Test를 발견하고 테스트 계획을 생성하는 TestEngine 인터페이스를 가지고 있음 
- TestEngine을 통해 Test를 발견하고, 수행 및 결과를 보고함
- 그리고 각정 IDE 연동을 보조하는 역할을 수행(콘솔 출력 등)
- (Platform = TestEngine API + Console Launcher + JUnit 4 Based Runner 등)

#### JUnit Vintage
- TestEngine API 구현체로 JUnit 3,4를 구현하고 있음
- 기존 JUnit 3,4 버전으로 작성된 테스트 코드를 실행할 때 사용됨
- Vintage-Engine 모듈을 포함하고 있음

![image](https://user-images.githubusercontent.com/73573088/223354079-ab156439-bee4-4af3-a6f4-0e4b73cf5af2.png)

#### JUnit LifeCycle Annotation 
- JUnit 5는 아래와 같은 테스트 라이프 사이클을 가지고 있음

![image](https://user-images.githubusercontent.com/73573088/223354253-0b0ced31-ec87-49be-bee8-5fd245c2ab1d.png)

#### JUnit Main Annotation
1) @SpringBootTest
    - 통합테스트 용도로 작성됨
    - @SpringBootApplication을 찾아가 하위의 모든 Bean을 스캔하여 로드함
    - 그 후 Test용 Application Context를 만들어 Bean을 추가하고, MockBean을 찾아 교체

2) @ExtendWith
    - JUnit4에서 @RunWith로 사용되던 어노테이션이 ExtendWith로 변경됨
    - @ExtendWith는 메인으로 실행될 Class를 지정할 수 있음
    - @SpringBootTest는 기본적으로 @ExtendWith가 추가되어 있음

3) @WebMvcTest(Class명.class)
    - ()에 작성된 클래스만 실제로 로드하여 테스트를 진행
    - 매개변수를 지정해주지 않으면 @Controller, @RestController, @RestControllerAdvice 등 컨트롤러와 연관된 Bean이 모두 로드됨
    - 스프링의 모든 Bean을 로드하는 @SpringBootTest 대신 컨트롤러 관련 코드만 테스트할 경우 사용
 
4) @Autowired about Mockbean
    - Controller의 API를 테스트하는 용도인 MockMvc 객체를 주입 받음
    - perform() 메소드를 활용하여 컨트롤러의 동작을 확인할 수 있음 / .andExpect(), andDo(), andReturn() 등의 메소드를 같이 활용함

5) @MockBean
    - 테스트할 클래스에서 주입 받고 있는 객체에 대해 가짜 객체를 생성해주는 어노테이션
    - 해당 객체는 실제 행위를 하지 않음
    - given() 메소드를 활용하여 가짜 객체의 동작에 대해 정의하여 사용할 수 있음

6) @AutoConfigureMockMvc
    - spring.test.mockmvc의 설정을 로드하면서 MockMvc의 의존성을 자동으로 주입
    - MockMvc 클래스는 REST API 테스트를 할 수 있는 클래스

7) @Import
    - 필요한 Class들을 Configuration으로 만들어 사용할 수 있음
    - Configuration Component 클래스도 의존성 설정할 수 있음
    - Import된 클래스는 주입으로 사용 가능

#### 통합 테스트
- 통합 테스트는 여러 기능을 조합하여 전체 비즈니스 로직이 제대로 동작하는지 확인하는 것을 의미
- 통합 테스트의 경우, @SpringBootTest를 사용하여 진행
    - @SpringBootTest는 @SpringBootApplication을 찾아가서 모든 Bean을 로드하게 됨
    - 이 방법을 대규모 프로젝트에서 사용할 경우, 테스트를 실행할 때마다 모든 빈을 스캔하고 로드하는 작업이 반복되어 매번 무거운 작업을 수행해야 함

#### 단위 테스트
- 단위 테스트는 프로젝트에 필요한 모든 기능에 대한 테스트를 각각 진행하는 것을 의미
- 일반적으로 스프링 부트에서는 'org.springframework.boot:spring-boot-starter-test' 디펜던시만으로 의존성을 모두 가질 수 있음


#### F.I.R.S.T 원치
- Fast : 테스트 코드의 실행은 빠르게 진행되어야 함
- Independent : 독립적인 테스트가 가능해야 함
- Repeatable : 테스트는 매번 같은 결과를 만들어야 함
- Self-Validating : 테스트는 그 자체로 실행하여 결과를 확인할 수 있어야 함
- Timely : 단위 테스트는 비즈니스 코드가 완성되기 전에 구성하고 테스트가 가능해야 함
            >> 코드가 완성되기 전부터 테스트가 따라와야 한다는 TDD의 원칙을 담고 있음

### 21. 테스트 커버리지 확인하기
#### 코드 커버리지
- 소프트웨어의 테스트 수준이 충분한지 표현할 수 있는 지표 중 하나
- 테스트를 진행했을 때 해당 코드가 실행되었는지를 표현하는 방법
- 많은 코드 커버리지 도구가 있으며, 가장 보편적으로 사용되는 Jacoco에 대해 다룬 강의

#### Jacoco 란?
- Java 코드의 커버리지를 체크하는 라이브러리
- 작성된 코드의 테스트 커버리지(Test Coverage)를 측정하는 도구
- Runtime으로 Test Case를 실행하여 Coverage를 체크하는 방식으로 사용됨
- 테스트 코드를 통해 테스트를 실행하고 그 결과를 html, xml, csv등 형식으로 Report를 제공

#### 블랙 박스 테스트(Black Box Test)
- 소프트웨어의 내부 구조나 작동 원리를 모르는 상태에서 동작을 검사하는 방식
- 다양한 값을 입력하여 올바른 출력이 나오는지 테스트
- 사용자 관점의 테스트 방법

#### 화이트 박스 테스트(White Box Test)
- 소프트웨어의 내부 구조와 동작을 검사하는 테스트 방식
- 소프트웨어 내부 소스 코드를 테스트하는 방법
- 개발자 관점의 테스트 방법

#### Jacoco pom.xml 파일 설정
- Execution 내부의 사용되는 값
    - prepare-agent : 테스트 중인 어플리케이션에서 인수를 전달하는 Jacoco Runtime Agent에 대한 property를 준비
    - merge : 여러 실행 데이터 파일들을 하나로 통합하는 명령어
    - report : 하나의 프로젝트 테스트에 대한 Code Coverage 리포트를 생성하는 명령어
    - check : code coverage metric이 충돌하는지 확인하는 명령어

#### Jacoco Rule
- Element type - 코드 커버리지 체크 기준
    - BUNDLE(defalt) : 패키지 번들
    - PACKAGE : 패키지
    - CLASS : 클래스
    - SOURCEFILE : 소스파일
    - METHOD : 메소드
- Counter - 코드 커버리지를 축정할 때 사용하는 지표
    - LINE : 빈 줄을 제외한실제 코드의 라인 수
    - BRANCH : 조건문 등의 분기 수
    - METHOD : 메소드 수
    - CLASS : 클래스 수
    - INSTRUCTION(default) : Java 바이트 코드 명령 수
    - COMPLEXITY : 복잡도
- Value - 커버리지 정도를 나타내는 지표
    - TOTALCOUNT : 전체 개수
    - MISSEDCOUNT : 커버되지 않은 개수
    - COVEREDCOUNT : 커버된 개수
    - MISSEDRATIO : 커버되지 않은 비율(0~1)
    - COVEREDRATIO (default) : 커버된 비율(0~1)

#### Jacoco 설정 예시
- 특정 클래스를 테스트 대상에서 제외하기 위해 아래와 같이 설정

![image](https://user-images.githubusercontent.com/73573088/223371101-2abd0460-9dab-4735-a8c8-7d4fe04cd32b.png)

![image](https://user-images.githubusercontent.com/73573088/223371483-60ca24f5-7f00-4232-b7cd-b7d4eae67118.png)

#### Jacoco 와 Maven LifeCycle
- Maven의 라이프 사이클 : compile -> test -> package -> install -> deploy
- Jacoco 플러그인은 Maven 라이프 사이클에 의해 동작하며, test phase 이후에 측정이 가능함 
- package phase 이후로 동작 가능

### 22. 스프링 VS 스프링 부트
#### 스프링(Spring) 이란 ?
- 정확한 표현으로는 ' 스프링 프레임워크(Spring Framework)'
- 스프링 프레임워크(Spring Framework)는 자바에서 가장 많이 사용되는 프레임워크
- 의존성 주입(DI, Dependency Injection)과 제어역전(IOC, Iversion of Control), 관점지향 프로그래밍(AOP)이 가장 중요한 요소
- 위 요소들을 통해 느슨한 결합(Loose Coupling)을 달성할 수 있음
- 위와 같이 느슨한 결합으로 개발한 어플리케이션은 단위 테스트를 수행하기 용이함

#### 의존성 주입(DI, Dependency Injection)
- 예제 코드와 같이 DI를 사용하지 않은 코드의 경우
![image](https://user-images.githubusercontent.com/73573088/223377968-9b1f7b92-313f-4e43-aed9-c1a4c19016f2.png)

- 예제 코드와 같이 DI를 사용하는 코드의 경우
![image](https://user-images.githubusercontent.com/73573088/223378124-d34b8c5d-8c2b-4d11-9b2f-bdb2e0de0e7d.png)

#### 관점 지향 프로그래밍(AOP, Aspect Oriented Programming)
- 스프링 프레임워크에서 제공하는 강력한 기능 중 하나 
- AOP는 쉽게 말해, OOP를 보완하는 수단으로, 여러 곳에 쓰이는 공통 기능을 모듈화하여 필요한 것에 연결함으로써 유지보수 또는 재사용에 용이하도록 하는 것을 의미
- AOP를 통해 기존 프로젝트에 다양한 기능을 로직 수정 없이 추가할 수 있음
- 이런 개발 방식을 통해 결합도를 낮춘 개발이 가능함
TIP. 알아보면 좋은 것 : 프록시 디자인 패턴, 핵심적인 관점, 부가적인 관점, 흩어진 관심사(Crosscutting Concerns)

#### 스프링 프레임워크의 대표적 모듈
- 스프링 프레임워크는 다양한 기능이 존재 그 기능들은 약 20개 의 모듈로 구성되어 있음
- 많이 사용되는 대표적인 모듈
    - Spring JDBC
    - Spring MVC
    - Spring AOP
    - Spring ORM
    - Spring Test
    - Spring Expression Language(SpEL)

#### 스프링 부트가 제공하는 기능
- 스프링 부트는 자동설정(AutoConfiguration)을 이용
    - 어플리케이션 개발에 필요한 모든 디펜던시(Dependency)를 프레임워크에서 관리
    - jar파일이 클래스 패스에 있는 경우 스프링 부트는 Dispatcher Servlet으로 자동 구성됨
    - 스프링 부트는 미리 설정되어 있는 Starter 프로젝트를 제공
    - xml 설정 없이 자바 코드를 통해 설정할 수 있음
- 어플리케이션을 개발하면서 사용되는 디펜던시들은 호환되는 버전으로 관리해줘야 함
    - 이런 복잡도를 줄이기 위해 스프링 부트는 SpringBoot-Starter를 제공하여 자동으로 호환되는 버전을 관리
- 모니터링 관리를 위한 스프링 액추에이터(Spring Actuator) 제공
    - 서비스가 정상적으로 동작하는지 상태 모니터링 기능 제공
    - 스프링 액추에이터는 스프링 부트에서 제공하는 상태 정보를 보다 쉽게 모니터링할 수 있게 기능을 제공

#### 스프링 부트 프로젝트의 starter 디펜던시
- spring-boot-starter-web-service : SOAP 웹 서비스 
- spring-boot-starter-web : RESTful 응용 프로그램
- spring-boot-starter-test : 단위 테스트, 통합 테스트
- spring-boot-starter-jdbc : 기본적인 JDBC
- spring-boot-starter-security : 스프링 시큐리티(인증,권한)
- spring-boot-starter-data-jpa : Spring Data JPA(Hibernate)
- spring-boot-starter-cache : 캐시
