package com.youngun.webservice.domain.posts;

import com.youngun.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //spring 2부터는 auto increment를 하려면 strategy= 헤야함.
    private Long id;

    @Column(columnDefinition ="TEXT",length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;


    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

//
//    Posts 클래스에는 JPA에서 제공하는 어노테이션들이 몇개 있습니다.
//
//@Entity
//테이블과 링크될 클래스임을 나타냅니다.
//        언더스코어 네이밍(_)으로 이름을 매칭합니다.
//        ex) SalesManager.java -> sales_manager table
//@Id
//해당 테이블의 PK 필드를 나타냅니다.
//@GeneratedValue
//PK의 생성 규칙을 나타냅니다.
//        기본값은 AUTO 로, MySQL의 auto_increment와 같이 자동증가하는 정수형 값이 됩니다.
//        스프링 부트 2.0에선 옵션을 추가하셔야만 auto_increment가 됩니다!
//@Column
//테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됩니다.
//        사용하는 이유는, 기본값 외에 추가로 변경이 필요한 옵션이 있을경우 사용합니다.
//        문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex: title), 타입을 TEXT로 변경하고 싶거나(ex: content) 등의 경우에 사용됩니다.

//
//    위에서 소개드린 어노테이션 외에 몇개의 어노테이션들이 더 보입니다.
//        (@NoArgsConstructor, @Getter, @Builder)
//
//        이는 처음 프로젝트 생성시 추가했던 Lombok 라이브러리의 어노테이션들입니다.
//        어노테이션 이름만 봐도 대략 기능을 예측할수 있습니다.
//
//@NoArgsConstructor : 기본 생성자 자동 추가
//        access = AccessLevel.PROTECTED : 기본생성자의 접근 권한을 protected로 제한
//        생성자로 protected Posts() {}와 같은 효과
//        Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는것은 허용하기 위해 추가
//@Getter : 클래스내 모든 필드의 Getter 메소드를 자동생성
//@Builder : 해당 클래스의 빌더패턴 클래스를 생성
//        생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
//        특히 서비스 구축단계에선 테이블 설계(여기선 Entity설계)가 빈번하게 변경되는데, 이때 Lombok의 어노테이션들은 코드 변경량을 최소화시켜주기 때문에 아주 강력 추천하는 라이브러리입니다.