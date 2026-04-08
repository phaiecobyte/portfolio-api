package com.phaiecobyte.portfolio_api.todo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "tbl_todo_tag_map")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoTagMap {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", nullable = false)
    private TodoTag tag;
}