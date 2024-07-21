package com.aiassistant.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private int priority;
    private boolean completionStatus;
}
