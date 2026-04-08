package com.phaiecobyte.portfolio_api.module.todo.dto.req;

import com.phaiecobyte.portfolio_api.module.todo.enums.TodoPriority;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoCreateReq {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    private TodoPriority priority;

    private LocalDateTime dueDate;

    @Min(value = 0, message = "Progress percent must be at least 0")
    @Max(value = 100, message = "Progress percent must not exceed 100")
    private Integer progressPercent;

    private Boolean pinned;
}