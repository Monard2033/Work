package com.student.ibmproject.controllers;
import com.student.ibmproject.services.ActivityService;
import com.student.ibmproject.entities.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private  ActivityService activityService;

    @GetMapping(value = "/all")
    public ResponseEntity<List<Activity>> getAllActivities() {
        List<Activity> activities = activityService.getAllActivities();
        return new ResponseEntity<>(activities, HttpStatus.OK);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        Activity addedActivity = activityService.addActivity(activity);
        return new ResponseEntity<>(addedActivity, HttpStatus.CREATED);
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<Activity> getActivityById(@PathVariable int activityId) {
        Activity activity = activityService.getActivityById(activityId);
        if (activity != null) {
            return new ResponseEntity<>(activity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{activityId}")
    public ResponseEntity<String> deleteActivity(@PathVariable int activityId) {
        Activity activity = activityService.getActivityById(activityId);
        if (activity != null) {
            activityService.deleteActivity(activityId);
            return new ResponseEntity<>("Activity with ID " + activityId + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Activity with ID " + activityId + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{activityId}")
    public ResponseEntity<Activity> updateActivity(@PathVariable int activityId, @RequestBody Activity updatedActivity) {
        Activity activity = activityService.getActivityById(activityId);
        if (activity != null) {
            activity.setActivityId(updatedActivity.getActivityId());
            activity.setActivityName(updatedActivity.getActivityName());
            Activity updated = activityService.updateActivity(activityId,updatedActivity);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
