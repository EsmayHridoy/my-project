package com.esmay.hrservice.model;


import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class MessageEntity extends BaseEntity{

    @Column(name = "subject")
    private String messageSubject;

    @Override
    public String toString() {
        return "MessageEntity{" +
                "messageSubject='" + messageSubject + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", user=" + user +
                '}';
    }

    @Column(name = "message")
    private String messageBody;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public MessageEntity(String messageSubject, String messageBody, User user) {
        this.messageSubject = messageSubject;
        this.messageBody = messageBody;
        this.user = user;
    }

    public String getMessageSubject() {
        return messageSubject;
    }

    public void setMessageSubject(String messageSubject) {
        this.messageSubject = messageSubject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
