package com.phaiecobyte.portfolio_api.module.todo.dto.res;

import com.phaiecobyte.portfolio_api.module.todo.enums.TodoPriority;
import com.phaiecobyte.portfolio_api.module.todo.enums.TodoStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoRes {
    private long id;
    private String title;
    private String description;
    private TodoStatus status;
    private TodoPriority priority;
    private LocalDateTime dueDate;
    private LocalDateTime completedAt;
    private Integer progressPercent;
    private Boolean pinned;
}
