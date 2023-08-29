package com.student.ibmproject.services;
import com.student.ibmproject.entities.Activity;
import com.student.ibmproject.entities.Student;
import com.student.ibmproject.exceptions.CustomException;
import com.student.ibmproject.repositories.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository = activityRepository;
    }

    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity getActivityById(Integer id) {
        Optional<Activity> activityOptional = activityRepository.findById(id);
        return activityOptional.orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "There is no activity with id : " + id));
    }

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public void deleteActivity(int activityId) {
        activityRepository.deleteById(activityId);
    }

    public Activity updateActivity(int activityId, Activity updatedActivity) {
        Activity existingActivity = activityRepository.findById(activityId).orElseThrow((() -> new RuntimeException("Student with id: "+ activityId+ " not found")));
        if (existingActivity != null) {
            existingActivity.setActivityId(updatedActivity.getActivityId());
            existingActivity.setActivityName(updatedActivity.getActivityName());
            return activityRepository.save(existingActivity);
        }
        return null;
    }
}
