package com.example.IBMProject.services;
import com.example.IBMProject.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.IBMProject.repository.ActivityRepository;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityRepository ActivityRepository;

    @Autowired
    public ActivityService(ActivityRepository ActivityRepository) {
        this.ActivityRepository = ActivityRepository;
    }

    public Activity createActivity(Activity activity) {
        return ActivityRepository.save(activity);
    }

    public void deleteActivity(int activityId) {
        ActivityRepository.deleteById(activityId);
    }
}
