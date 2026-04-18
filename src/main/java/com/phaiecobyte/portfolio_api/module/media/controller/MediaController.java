package com.phaiecobyte.portfolio_api.module.media.controller;


import com.phaiecobyte.portfolio_api.common.ApiResponse;
import com.phaiecobyte.portfolio_api.module.media.model.MediaFile;
import com.phaiecobyte.portfolio_api.module.media.model.MediaResponse;
import com.phaiecobyte.portfolio_api.module.media.service.MediaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

import static com.phaiecobyte.portfolio_api.common.Constants.STATUS_ACTIVE;


@RestController
@RequestMapping("/media-service/api/v1/media")
@RequiredArgsConstructor
@Slf4j
public class MediaController {

    private final MediaService service;

    // ========================= LIST =========================
    @GetMapping
    public ResponseEntity<Object> list(
            @RequestParam(name = "page",defaultValue = "0") int page,
            @RequestParam(name ="size",defaultValue = "10") int size
    ) {
        Page<MediaFile> mediaFiles =
                service.listMediaFiles(STATUS_ACTIVE,PageRequest.of(page, size));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Retrieve media successfully...!",mediaFiles));
    }

    // ========================= GET METADATA =========================
    @GetMapping("/{id}/metadata")
    public ResponseEntity<Object> getById(@PathVariable("id") UUID id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.apiSuccessRes(true,"Success",service.getById(id)));
    }

    // ========================= UPLOAD =========================
    @PostMapping(
            value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<ApiResponse<MediaResponse>> upload(
            @RequestPart("file") MultipartFile file
    ) {
        log.info("Content-Type: {}", file.getContentType());
        MediaFile media = service.upload(file);

        MediaResponse response = new MediaResponse(
                media.getId(),
                "/media/files/" + media.getId(),
                media.getOriginalName()
        );

        return ResponseEntity.ok(
                ApiResponse.apiSuccessRes(true,"File uploaded successfully", response)
        );
    }

    // ========================= DOWNLOAD (BY ID) =========================
    @GetMapping("/files/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") UUID id) {

        MediaService.MediaResource media = service.loadAsResource(id);
        Resource resource = new InputStreamResource(media.inputStream());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(media.contentType()))
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + media.filename() + "\""
                )
                .body(resource);
    }

    // ========================= DELETE (SOFT) =========================
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable("id") UUID id) {

        service.delete(id);

        return ResponseEntity.ok(
                ApiResponse.apiSuccessRes(true,"Media deleted successfully",null)
        );
    }
}


