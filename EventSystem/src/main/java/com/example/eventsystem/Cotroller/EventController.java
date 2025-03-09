package com.example.eventsystem.Cotroller;

import com.example.eventsystem.Api.ApiResponse;
import com.example.eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {

    ArrayList<Event> events=new ArrayList<>();



    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event added successfully");
    }

    @GetMapping("/get")
    public ArrayList<Event> getEvent() {
        return events;

    }


    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@RequestBody Event event,@PathVariable int index) {
        events.set(index,event);
        return new ApiResponse("Event updated successfully:"+event);
    }



    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEvent(@PathVariable int index){
        events.remove(index);
        return new ApiResponse("Event deleted successfully");
    }


@PutMapping("/changeCapacity/{index}/{capacity}")
public ApiResponse changeCapacity (@PathVariable int index ,@PathVariable int capacity){
            events.get(index).setCapacity(capacity);
            return new ApiResponse("Event capacity updated to "+capacity+" successfully!");
}





    @GetMapping("/search/{id}")
    public ApiResponse searchEvent(@PathVariable String id)
    {
        for (Event event : events) {
            if (event.getId().equals(id)) {
                return new ApiResponse("The event is found:" + event);
            }
        }
        return new ApiResponse("the Events is not found");
    }





}
