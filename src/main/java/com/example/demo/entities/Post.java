package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "post")
@Data


public class Post {
    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY) // User objesinin database'den hemen çekme
    @JoinColumn(name = "user_id", nullable = false )// User columuna bağla
    @OnDelete(action = OnDeleteAction.CASCADE) // bir user silindiğinde tüm postları da sil
    @JsonIgnore
    User user;


    Long userId;
    String title;
    @Lob
    /*
    Java dilinde "@Lob" (Large Object) anotasyonu, veritabanında büyük boyutlu verilerin (genellikle metin veya biner veriler) saklanmasını sağlayan bir işaretlemedir.
    Bu anotasyon, JPA (Java Persistence API) kapsamında, nesnelerin veritabanına kalıcı bir şekilde kaydedilmesini yönetmek için kullanılır.
    */
    @Column(columnDefinition = "text")
    String text;


}
