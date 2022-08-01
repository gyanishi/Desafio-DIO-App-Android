package com.dio.soccernews.data;

import androidx.room.Room;

import com.dio.soccernews.app;
import com.dio.soccernews.data.local.appDatabase;
import com.dio.soccernews.data.remote.SoccerNewsApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SoccerNewsRepositoy {
    private static final String REMOTE_API_URL = "https://digitalinnovationone.github.io/soccer-news-api/";
    private static final String LOCAL_DB_NAME = "soccer-news";

    private SoccerNewsApi remoteApi;
    private appDatabase localDb;

    public SoccerNewsApi getRemoteApi() { return remoteApi; }
    public appDatabase getLocalDb() { return localDb; }

    private SoccerNewsRepositoy() {
        remoteApi = new Retrofit.Builder()
                .baseUrl(REMOTE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(SoccerNewsApi.class);
        localDb = Room.databaseBuilder(app.getInstance(), appDatabase.class, LOCAL_DB_NAME)
                .allowMainThreadQueries()
                .build();
    }

    public static SoccerNewsRepositoy getInstance() { return LazyHolder.INSTANCE; }

    private static class LazyHolder {
        private static final SoccerNewsRepositoy INSTANCE = new SoccerNewsRepositoy();
    }
}
