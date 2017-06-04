package com.epicodus.leaguestats.models;

/**
 * Created by riffee on 6/4/2017.
 */

public class Summoner {
    private String mName;
    private long mId;
    private long mLevel;


    public Summoner (String name,long id, long level) {
        this.mName = name;
        this.mId = id;
        this.mLevel = level;
    }

    public String getName() {
        return mName;
    }
    public long getId() { return mId; }
    public long getLevel() { return mLevel; }
    }