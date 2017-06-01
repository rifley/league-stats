package com.epicodus.leaguestats.services;

import android.util.Log;

import com.epicodus.leaguestats.Constants;

import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 6/1/17.
 */

public class RiotService {
    public static void findChampion(String id, Callback callback) {

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RIOT_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("/", id);
        urlBuilder.addPathSegment(Constants.RIOT_CHAMPSTATS_QUERY_PARAMETER);
        String url = urlBuilder.build().toString();

        Log.d("url", url);


//        Request request = new Request.Builder()
//                .header("Origin", "")


    }
}
