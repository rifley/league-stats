package com.epicodus.leaguestats.models;

/**
 * Created by Guest on 6/1/17.
 */

public class Champion {
    private String mName;
    private String mTitle;
    private double mBaseArmor;
    private double mBaseHP;
    private double mBaseAD;
    private double mBaseMR;

    public Champion (String name, String title, double armor, double hp, double mr, double attackDamage) {
        this.mName = name;
        this.mTitle = title;
        this.mBaseArmor = armor;
        this.mBaseHP = hp;
        this.mBaseAD = attackDamage;
        this.mBaseMR = mr;
    }

    public String getName() {
        return mName;
    }
    public String getTitle() {
        return mTitle;
    }
    public double getArmor() {
        return mBaseArmor;
    }
    public double getHP() {
        return mBaseHP;
    }
    public double getMR() {
        return mBaseMR;
    }
    public double getAttack() {
        return mBaseAD;
    }

}


