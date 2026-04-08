package com.phaiecobyte.portfolio_api.todo.entity;

import com.phaiecobyte.portfolio_api.common.AuditField;
import com.phaiecobyte.portfolio_api.todo.enums.TodoPriority;
import com.phaiecobyte.portfolio_api.todo.enums.TodoStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tbl_todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Todo extends AuditField{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TodoStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TodoPriority priority;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "completed_at")
    private LocalDateTime completedAt;

    @Column(name = "is_pinned", nullable = false)
    private Boolean pinned = false;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "progress_percent")
    private Integer progressPercent;

    @Column(name = "estimated_minutes")
    private Integer estimatedMinutes;

    @Column(name = "actual_minutes")
    private Integer actualMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_todo_id")
    private Todo parentTodo;

    @OneToMany(mappedBy = "parentTodo", cascade = CascadeType.ALL)
    private List<Todo> subTasks = new ArrayList<>();

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TodoTagMap> todoTags = new ArrayList<>();


}