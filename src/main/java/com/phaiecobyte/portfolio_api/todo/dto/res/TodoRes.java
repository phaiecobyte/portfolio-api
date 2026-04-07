package com.phaiecobyte.portfolio_api.todo.dto.res;

import com.phaiecobyte.portfolio_api.common.AuditField;
import com.phaiecobyte.portfolio_api.todo.enums.TodoPriority;
import com.phaiecobyte.portfolio_api.todo.enums.TodoStatus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

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
