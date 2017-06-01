package com.epicodus.leaguestats.services;

import android.util.Log;

import com.epicodus.leaguestats.Constants;
import com.epicodus.leaguestats.models.Champion;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 6/1/17.
 */

public class RiotService {
    public static void findChampion(String id, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RIOT_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("/", id);
        urlBuilder.addPathSegment(Constants.RIOT_CHAMPSTATS_QUERY_PARAMETER);
        String url = urlBuilder.build().toString();

        Log.d("url", url);


        Request request = new Request.Builder()
                .url(url)
                .addHeader("Origin", "https://developer.riotgames.com")
                .addHeader("Accept-Charset", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("X-Riot-Token", Constants.RIOT_KEY)
                .addHeader("Accept-Language", "en-US,en;q=0.8")
                .addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Champion> processResults(Response response) {
        ArrayList<Champion> champions = new ArrayList<>();

        try {

        }
        }
    }
}
