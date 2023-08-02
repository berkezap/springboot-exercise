package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table (name = "p_like")
@Data

public class Like {

    @Id
    long id;

    @ManyToOne(fetch = FetchType.LAZY) // User objesinin database'den hemen çekme
    @JoinColumn(name = "user_id", nullable = false )// User columuna bağla
    @OnDelete(action = OnDeleteAction.CASCADE) // bir user silindiğinde tüm postları da sil
    @JsonIgnore
    User user;

    @ManyToOne(fetch = FetchType.LAZY) // User objesinin database'den hemen çekme
    @JoinColumn(name = "post_id", nullable = false )// User columuna bağla
    @OnDelete(action = OnDeleteAction.CASCADE) // bir user silindiğinde tüm postları da sil
    @JsonIgnore
    Post post;

}
