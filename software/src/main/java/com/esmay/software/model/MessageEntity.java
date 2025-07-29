package com.esmay.software.model;


import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class MessageEntity extends BaseEntity{

    @Column(name = "subject")
    private String messageSubject;


    @Column(name = "message")
    private String messageBody;

    @Column(name = "Sent")
    private String fromBody;

    public MessageEntity(String messageSubject, String messageBody, String fromBody) {
        this.messageSubject = messageSubject;
        this.messageBody = messageBody;
        this.fromBody = fromBody;
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

    public String getFromBody() {
        return fromBody;
    }

    public void setFromBody(String fromBody) {
        this.fromBody = fromBody;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "messageSubject='" + messageSubject + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", fromBody='" + fromBody + '\'' +
                '}';
    }
}
