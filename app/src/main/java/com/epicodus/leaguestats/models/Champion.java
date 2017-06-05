package com.epicodus.leaguestats.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 6/1/17.
 */

@Parcel
public class Champion {
    String mName;
    String mTitle;
    Double mBaseArmor;
    Double mBaseHP;
    Double mBaseAD;
    Double mBaseMR;
    String mImageUrl;

    public Champion() {}

    public Champion (String name, String title, Double armor, Double hp, Double mr, Double attackDamage) {
        this.mName = name;
        this.mTitle = title;
        this.mBaseArmor = armor;
        this.mBaseHP = hp;
        this.mBaseAD = attackDamage;
        this.mBaseMR = mr;
        this.mImageUrl = "http://ddragon.leagueoflegends.com/cdn/7.5.2/img/champion/" + name + ".png";
    }

    public String getName() {
        return mName;
    }
    public String getTitle() {
        return mTitle;
    }
    public String getArmor() {
        return mBaseArmor.toString();
    }
    public String getHP() {
        return mBaseHP.toString();
    }
    public String getMR() {
        return mBaseMR.toString();
    }
    public String getAttack() {
        return mBaseAD.toString();
    }
    public String getImageUrl() { return mImageUrl; }


}


