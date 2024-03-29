package com.coffeetime.ctmessage.infrastructure.entity;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(name = "fromUserId", nullable = false)
    private int fromUserId;

    @Column(name = "toUserId", nullable = false)
    private int toUserId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private Instant sendAt = Instant.now();

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private Boolean read = false;

    @Column(nullable = true, columnDefinition = "TIMESTAMP")
    private Instant deleteAt;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private Boolean anonymous = false;

    @Column(nullable = true)
    private String anonymousName;

    @Column(nullable = true)
    private int fromPostId;

    // Constructors
    public Messages() {
    }

    // Getters and Setters
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getSendAt() {
        return sendAt;
    }

    public void setSendAt(Instant sendAt) {
        this.sendAt = sendAt;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }

    public Instant getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Instant deleteAt) {
        this.deleteAt = deleteAt;
    }

    public Boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        this.anonymous = anonymous;
    }

    public String getAnonymousName() {
        return anonymousName;
    }

    public void setAnonymousName(String anonymousName) {
        this.anonymousName = anonymousName;
    }

    public int getFromPostId() {
        return fromPostId;
    }

    public void setFromPostId(int fromPostId) {
        this.fromPostId = fromPostId;
    }

    // toString
    @Override
    public String toString() {
        return "Messages{" +
                "messageId=" + messageId +
                ", fromUserId=" + fromUserId +
                ", toUserId=" + toUserId +
                ", content='" + content + '\'' +
                ", sendAt=" + sendAt +
                ", read=" + read +
                ", deleteAt=" + deleteAt +
                ", anonymous=" + anonymous +
                ", anonymousName='" + anonymousName + '\'' +
                ", fromPostId=" + fromPostId +
                '}';
    }
}