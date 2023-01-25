package com.webservice.domain.posts;

import com.webservice.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;

@Getter /* 클래스 내 모든 필드의 Getter 메소드를 자동 생성 */
@NoArgsConstructor /* 기본 생성자 자동 추가 */
@Entity /* 테이블과 링크 될 클래스*/
public class Posts extends BaseTimeEntity {

    @Id /* 해달 테이블의 기본키를 나타냄 */
    @GeneratedValue(strategy = GenerationType.IDENTITY) /* 기본키의 규칙을 나타냄 */
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder /* 해당 클래스의 빌더 팩던 클래스 생성 */
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}