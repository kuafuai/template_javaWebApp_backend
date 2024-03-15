package com.aiassistant.model;

import java.util.List;

public class StoreFeedback {
    private Integer id;
    private String customerName;
    private String feedbackType;
    private String feedbackContent;
    private List<String> photos;
    private List<String> videos;

    public StoreFeedback() {
    }

    public StoreFeedback(Integer id, String customerName, String feedbackType, String feedbackContent, List<String> photos, List<String> videos) {
        this.id = id;
        this.customerName = customerName;
        this.feedbackType = feedbackType;
        this.feedbackContent = feedbackContent;
        this.photos = photos;
        this.videos = videos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }
}
