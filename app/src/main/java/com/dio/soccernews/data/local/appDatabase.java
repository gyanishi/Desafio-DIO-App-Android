package com.dio.soccernews.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.dio.soccernews.domain.News;

@Database(entities = {News.class}, version = 1)
public abstract class appDatabase extends RoomDatabase {
    public abstract newsDao NewsDao();
}
