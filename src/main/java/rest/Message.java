package rest;

import java.io.Serializable;

/**
 * Created by Aliaksei on 22.11.2017.
 */

//package main.java;


public class Message implements Serializable {
    private int messageId;
    private String messageTitle;
    private String messageText;

    public Message() {
    }

    public Message(int messageId, String messageTitle, String messageText) {
        this.messageId = messageId;
        this.messageTitle = messageTitle;
        this.messageText = messageText;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "rest.Message{" +
                "messageId=" + messageId +
                ", messageTitle='" + messageTitle + '\'' +
                ", messageText='" + messageText + '\'' +
                '}';
    }
}
