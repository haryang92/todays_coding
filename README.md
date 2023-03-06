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
