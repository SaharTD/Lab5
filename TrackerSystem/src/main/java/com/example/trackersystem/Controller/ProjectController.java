package com.example.trackersystem.Controller;


import com.example.trackersystem.Api.ApiResponse;
import com.example.trackersystem.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    ArrayList<Project> projects = new ArrayList<>();


    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse("Project added successfully");
    }

    @GetMapping("/get")
    public ArrayList<Project> getProject() {
        return projects;

    }


    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@RequestBody Project project,@PathVariable int index) {
        projects.set(index,project);
        return new ApiResponse("Project updated successfully:"+project);
    }



    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index){
        projects.remove(index);
        return new ApiResponse("Project deleted successfully");
    }



    @PutMapping("/changeStatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index ) {

        Project project= projects.get(index);
        String oldStatus=project.getStatus();
        if(project.getStatus().equals("undone")){
            project.setStatus("done");
        }else project.setStatus("undone");
        return new ApiResponse("Project status changed successfully"+"-- old status:"+oldStatus+"-- new status :"+project.getStatus()) ;
    }




    @GetMapping("/search/{title}")
    public ApiResponse searchProject(@PathVariable String title)
    {
        for (int i = 0; i < projects.size(); i++) {
            if( projects.get(i).getTitle().equals(title)){
                return new ApiResponse("The Project is found:"+ projects.get(i));
            }
        } return new ApiResponse("the Project is not found");
    }



    @GetMapping("/display/{companyName}")
    public ApiResponse displayProject(@PathVariable String  companyName)
    {
        ArrayList<Project> companyProjects = new ArrayList<>();
        for (int i = 0; i < projects.size(); i++) {
            if( projects.get(i).getCompanyName().equals(companyName)){
                companyProjects.add(projects.get(i));
            }
        } return new ApiResponse("the Projects under the company name :"+companyName +
            "are :"+ companyProjects);
    }



}
