package com.aiassistant.utils;

import com.aiassistant.model.User;
import lombok.Data;

@Data
public class ExperienceModel {
    private int experiencePoints;
    private int coins;
    private int skillPoints;

    private User user;

    public ExperienceModel(User user) {
        this.user = user;
        this.experiencePoints = 0;
        this.coins = 0;
        this.skillPoints = 0;
    }

    public ExperienceModel(User user, int experiencePoints, int coins, int skillPoints) {
        this.user = user;
        this.experiencePoints = experiencePoints;
        this.coins = coins;
        this.skillPoints = skillPoints;
    }
}
