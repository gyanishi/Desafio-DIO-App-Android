package com.dio.soccernews.ui.favorites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.dio.soccernews.data.SoccerNewsRepositoy;
import com.dio.soccernews.domain.News;

import java.util.List;

public class FavoritesViewModel extends ViewModel {

    public FavoritesViewModel() {
    }

    public LiveData<List<News>> loadFavoriteNews() {
        return SoccerNewsRepositoy.getInstance().getLocalDb().NewsDao().loadFavoriteNews();
    };

    public void saveNews(News news) {
        SoccerNewsRepositoy.getInstance().getLocalDb().NewsDao().save(news);;
    }

}