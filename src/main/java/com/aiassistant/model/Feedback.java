package com.aiassistant.model;

public class Feedback {
    private String storeId;
    private String feedback;
    private String imageUrl;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isValid() {
        return storeId != null && !storeId.isEmpty() &&
                feedback != null && !feedback.isEmpty() &&
                imageUrl != null && !imageUrl.isEmpty();
    }
}
