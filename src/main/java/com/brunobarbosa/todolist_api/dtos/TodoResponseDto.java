package com.brunobarbosa.todolist_api.dtos;

import java.time.LocalDateTime;

public record TodoResponseDto(

        Long id,
        String title,
        String description,
        LocalDateTime date,
        boolean done
) {
}
