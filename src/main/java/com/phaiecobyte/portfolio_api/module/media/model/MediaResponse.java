package com.phaiecobyte.portfolio_api.module.media.model;

import lombok.*;

import java.util.UUID;

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class MediaResponse {
    private UUID id;
    private String url;
    private String originalName;
}