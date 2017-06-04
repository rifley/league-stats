package com.epicodus.leaguestats.models;

/**
 * Created by riffee on 6/4/2017.
 */

public class Summoner {
    private String mName;
    private Long mId;
    private Long mLevel;


    public Summoner (String name, Long id, Long level) {
        this.mName = name;
        this.mId = id;
        this.mLevel = level;
    }

    public String getName() {
        return mName;
    }
    public Long getId() { return mId; }
    public Long getLevel() { return mLevel; }
    }