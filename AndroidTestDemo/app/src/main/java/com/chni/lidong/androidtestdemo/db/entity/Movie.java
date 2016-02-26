package com.chni.lidong.androidtestdemo.db.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import com.chni.lidong.androidtestdemo.BR;
import com.chni.lidong.androidtestdemo.utils.MyResultCallback;
import com.chni.lidong.androidtestdemo.utils.OkHttpClientManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Request;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2015/12/30.
 */
    public class Movie extends BaseObservable {


    private String id;
    private String title;
    private String original_title;
    private String year;
    private Images images;
    private Rating rating;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);

    }

    @Bindable
    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
        notifyPropertyChanged(BR.description);
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
        notifyPropertyChanged(BR.images);
    }

    @Bindable
    public String getDescription() {
        return this.original_title + "\n" + this.getYear();
    }


    @Bindable
    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
        notifyPropertyChanged(BR.rating);
    }

    public class Images implements Serializable {
        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }


    public class Rating {
        private float max;
        private float average;
        private String stars;
        private float min;

        public float getMax() {
            return max;
        }

        public void setMax(float max) {
            this.max = max;
        }

        public float getAverage() {
            return average;
        }

        public void setAverage(float average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public float getMin() {
            return min;
        }

        public void setMin(float min) {
            this.min = min;
        }
    }

    public class Cast {
        private String id;
        private String name;
        private Images avatars;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Images getAvatars() {
            return avatars;
        }

        public void setAvatars(Images avatars) {
            this.avatars = avatars;
        }
    }

    private static final String BASE_URL = "https://api.douban.com/v2/";

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }


    public interface IMovieResponse<T> {
        void onData(T data);
    }

    public static void searchMovies(String name, final IMovieResponse<List<Movie>> response1) {
        HashMap<String,String> params1 = new HashMap<String,String>();
        params1.put("tag", name);
        params1.put("start", 0+"");
        params1.put("end", 50+"");
        OkHttpClientManager.postAsyn(getAbsoluteUrl("movie/search"), params1, new MyResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                Log.i("TAG------------", request.toString() + e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                Log.i("TAG------------", response);
                Gson gson = new Gson();
                JSONObject json = null;
                try {
                    json = new JSONObject(new String(response));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONArray jaMovies = json.optJSONArray("subjects");
                List<Movie> movies = gson.fromJson(jaMovies.toString(), new TypeToken<List<Movie>>() {
                }.getType());
                response1.onData(movies);
            }
        });
    }

}
