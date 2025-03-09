package com.example.lab5_students.Controller;

import com.example.lab5_students.Api.ApiResponse;
import com.example.lab5_students.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class studentController {



    ArrayList<Student>students=new ArrayList<>();

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody Student student) {
        students.add(student);
        return new ApiResponse("Student added successfully");
    }

    @GetMapping("/get")
    public ArrayList<Student> getStudents() {
        return students;

    }


    // found the student to update by id
@PutMapping("/update/{index}")
    public ApiResponse updateStudent(@RequestBody Student student,@PathVariable int index) {
            students.set(index,student);
            return new ApiResponse("Student updated successfully:"+student);
    }



    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index){
        students.remove(index);
        return new ApiResponse("Student deleted successfully");
    }


@GetMapping("/honorsCategories")
public ApiResponse honorsCategories() {
        ArrayList<Student> first_honors=new ArrayList<>();
    ArrayList<Student> second_honors=new ArrayList<>();

    for (int i = 0; i <students.size() ; i++) {
        if(students.get(i).getGpa()>=4.5){
            first_honors.add(students.get(i));
        }else if(students.get(i).getGpa()>=3.5 && students.get(i).getGpa()<4.5){
            second_honors.add(students.get(i));
    }
    }
        return new ApiResponse("The first class honors students :"+first_honors
                +"The second class honors students :"+second_honors);

}

@GetMapping("/aboveAverage")
public ApiResponse aboveAverage () {
        double average=0;
        double sum=0;

        ArrayList<Student> aboveAverage=new ArrayList<>();
    for (int i = 0; i <students.size() ; i++) {
       sum+= students.get(i).getGpa();
    }
    average=sum/students.size();

    for (int i = 0; i < students.size(); i++) {
        if(average<students.get(i).getGpa()){
            aboveAverage.add(students.get(i));
        }
    }

    return new ApiResponse("The students with the above average gpa are :"
            +aboveAverage);
}





}
