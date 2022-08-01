package com.dio.soccernews.domain;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class News {
    @PrimaryKey
    @NonNull
    public String title;
    public String description;
    public String image;
    public String link;
    public boolean favorite;

}
