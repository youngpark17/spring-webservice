# 스프링부트 공부 (https://jojoldu.tistory.com/255?category=635883)
기억보단 기록님의 블로그 보고.

## 2강을 통해 알게된 것 
1. RestController 는 Controller 어노테이션 + 추가로 메소들에게 ResponsBody 적용.
때문에 보통 RestController는 데이터 반환 Controller는 View단 반환
2. JPA 사용법 및 JPA Auditing 을 통해 데이터베이스 수정, 생성시 자동으로 column값 추가.
3. SpringBoot2는 디폴트 JUnit이 5이기 때문에 4를 사용하기 위해선 downgrade.
4. h2 db를 통해 로컬환경에서 쉽게 테스트 가능.

[코드 링크](https://github.com/youngpark17/spring-webservice/commit/d7ba5578a581268ae9746f935b89d632f517e377)

## 3강을 통해 알게된 것

1. Handlebar의 장점.
- 문법이 다른 템플릿 엔진보다 간편.
- 로직코드를 사용할 수 없어 View, 서버의 역할을 명확하게 제한
- Handlebars.js와 Handlebars.java 2가지가 다 있어, 하나의 문법으로 클라이언트 서버 템플릿 모두 사용 가능
- 다른 서버 템플릿 스타터 패키지와 마찬가지로 Handlebars도 기본 경로는 src/main/resources/templates가 됩니다.
- handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정됩니다.

2. Transactional 어노테이션
Tip) 트랜잭션?
일반적으로 DB 데이터를 등록/수정/삭제 하는 Service 메소드는 @Transactional를 필수적으로 가져갑니다.
이 어노테이션이 하는 일은 간단합니다.
메소드 내에서 Exception이 발생하면 해당 메소드에서 이루어진 모든 DB작업을 초기화 시킵니다.
즉, save 메소드를 통해서 10개를 등록해야하는데 5번째에서 Exception이 발생하면 앞에 저장된 4개까지를 전부 롤백시켜버립니다.
(정확히 얘기하면, 이미 넣은걸 롤백시키는건 아니며, 모든 처리가 정상적으로 됐을때만 DB에 커밋하며 그렇지 않은 경우엔 커밋하지 않는것입니다.)

3. Sevice란 무엇인가?
Controller : Request를 어떻게 처리할까?
Service : Request에 대해 어떤 처리를 할까?
- Client 가 Request 를 보낸다.
- Request URL에 알맞은 Controller 가 수신한다.
- Controller 는 넘어온 요청을 처리하기 위해 Service 를 호출한다.
- Service 는 알맞은 정보를 가공하여 Controller 에게 데이터를 넘긴다.
- Controller 는 Service 의 결과물을 Client 에게 전달해준다.
Service가 Client의 요청에 대한 올바른 정보를 제공하기 위한 처리 -> 비지니스 로직을 수행한다.
비지니스 로직 & 트랜잭션 관리는 모두 Service에서 관리하고, View 와 연동되는 부분은 Controller에서 담당하도록 구성합니다.

