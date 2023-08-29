package com.example.IBMProject.Controller;

import com.example.IBMProject.entities.Activity;
import com.example.IBMProject.services.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    private final ActivityService activityService;

    @Autowired
    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/{activityId}")
    public Activity createActivity(@RequestBody Activity activity) {
       return activityService.createActivity(activity);
    }

    @DeleteMapping("/{activityId}")
    public void deleteActivity(@PathVariable int activityId) {
        activityService.deleteActivity(activityId);
    }
}