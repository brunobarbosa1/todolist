package com.brunobarbosa.todolist_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public record TodoRequestDto(

        @NotBlank(message = "Title is required")
        @Size(max = 255, message = "Title must have at most 255 characters")
        String title,

        @NotBlank(message = "Description is required")
        @Size(min = 1, max = 100, message = "Description must have between 1 and 100 characters")
        String description,

        LocalDateTime date
) {
}