package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "activity")
public class activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int activityId;
    private String activity_type;

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }




}
