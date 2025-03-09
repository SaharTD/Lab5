package com.example.eventsystem.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@lombok.Data
@lombok.AllArgsConstructor
public class Event {
    private String id;
    private String description;
    private int capacity;



    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(pattern ="yyyy-MM-dd")
    private LocalDate endDate;

}
