package com.example.basic.entity;

import com.example.basic.code.MessageType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Notification extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Long receiverId;

    private String message;
    private boolean readOrNot;

    @Enumerated(value = EnumType.STRING)
    private MessageType messageType;
    private Long referenceId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

}
