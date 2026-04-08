package com.phaiecobyte.portfolio_api.todo.dto.req;

import com.phaiecobyte.portfolio_api.todo.enums.TodoPriority;
import com.phaiecobyte.portfolio_api.todo.enums.TodoStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoUpdateReq {

    private String title;

    private String description;

    private TodoStatus status;

    private TodoPriority priority;

    private LocalDateTime dueDate;

    private LocalDateTime completedAt;

    @Min(value = 0, message = "Progress percent must be at least 0")
    @Max(value = 100, message = "Progress percent must not exceed 100")
    private Integer progressPercent;

    private Boolean pinned;

}