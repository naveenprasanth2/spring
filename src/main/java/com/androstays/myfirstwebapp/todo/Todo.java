package com.androstays.myfirstwebapp.todo;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Todo {
    private int id;
    private String username;
    @Size(min = 10, message = "please enter a valid value")
    private String description;
    private LocalDate targetDate;
    private boolean done;
}
