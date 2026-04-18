package com.phaiecobyte.portfolio_api.common;

import java.util.Set;

public class Constants {
    public static final String BASE_URL_PORTFOLIO ="/api/v1/portfolio";
    public final String BASE_URL_POS = "/api/v1/pos";
    public final String BASE_URL_TODO = "/api/v1/todo";


    public static final String STATUS_ACTIVE = "A";
    public static final String STATUS_INACTIVE = "I";


    // ================== Media Service ==============
    public static long MAX_FILE_SIZE = 5 * 1024 * 1024;
    public static final Set<String> ALLOWED_FILE_TYPES = Set.of(
            "image/jpeg",
            "image/png",
            "image/jpg",
            "image/svg",
            "image/webp"
    );

    public static final String MEDIA_BASE_PATH = "/media/files";
}
