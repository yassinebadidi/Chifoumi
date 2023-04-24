package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Post {
    private String title;
    private String authore;
    private String content;
    private LocalDateTime createdAt;

    public Post(String title, String authore, String content) {
        this.title = title;
        this.authore = authore;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthore() {
        return authore;
    }

    public String getCreatedAt() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = now.format(formatter);
        return formattedDateTime;
    }
}
