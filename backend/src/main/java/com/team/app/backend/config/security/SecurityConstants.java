package com.team.app.backend.config.security;

public class SecurityConstants {
    public static final String SECRET = "zdtlD3JK56m6wTTgsNFhqzjqP";
    public static final String ISSUER = "example.io";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
