package com.epicodus.leaguestats.services;

import android.util.Log;

import com.epicodus.leaguestats.Constants;
import com.epicodus.leaguestats.models.Champion;
import com.epicodus.leaguestats.models.Summoner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
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

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RIOT_STATIC_BASE_URL).newBuilder();
        urlBuilder.addPathSegment(id);
        urlBuilder.addQueryParameter("tags", "stats");
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

    public static void findSummoner(String name, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RIOT_SUMMONER_BASE_URL).newBuilder();
        urlBuilder.addPathSegment(name);
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

    public ArrayList<Champion> processStats(Response response) {
        ArrayList<Champion> champions = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject riotJSON = new JSONObject(jsonData);
                String name = riotJSON.getString("name");
                String title = riotJSON.getString("title");
                Double armor = riotJSON.getJSONObject("stats")
                        .getDouble("armor");
                Double healthPoints = riotJSON.getJSONObject("stats")
                        .getDouble("hp");
                Double attackDamage = riotJSON.getJSONObject("stats")
                        .getDouble("attackdamage");
                Double magicResist = riotJSON.getJSONObject("stats")
                        .getDouble("spellblock");
                Log.i("name", name);
                Champion responseChampion = new Champion(name, title, armor, healthPoints, attackDamage, magicResist);
                champions.add(responseChampion);

            }
        } catch(IOException e){
            e.printStackTrace();
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return champions;
    }

    public ArrayList<Summoner> processSummoner(Response response) {
        ArrayList<Summoner> summoner = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if(response.isSuccessful()) {
                JSONObject riotJSON = new JSONObject(jsonData);
                String name = riotJSON.getString("name");
                Log.d("name in service", name);
                Long id = riotJSON.getLong("accountId");
                Long level = riotJSON.getLong("summonerLevel");

                Summoner responseSummoner = new Summoner(name, id, level );
                summoner.add(responseSummoner);

            }
        } catch(IOException e){
            e.printStackTrace();
        } catch(JSONException e) {
            e.printStackTrace();
        }
        return summoner;
    }
}

