package com.epicodus.leaguestats.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 6/1/17.
 */

@Parcel
public class Champion {
    String name;
    String title;
    Double baseArmor;
    Double armorPerLevel;
    Double moveSpeed;
    Double baseHealthPoints;
    Double hpPerLevel;
    Double baseAttackDamage;
    Double baseMagicResist;
    Double magicResistPerLevel;
    String imageUrl;

    public Champion() {}

    public Champion (String name, String title, Double armor, Double armorLvl, Double speed, Double hp, Double hpPerLvl, Double attackDamage, Double mr, Double mrPerLvl) {
        this.name = name;
        this.title = title;
        this.baseArmor = armor;
        this.armorPerLevel = armorLvl;
        this.moveSpeed = speed;
        this.baseHealthPoints = hp;
        this.hpPerLevel = hpPerLvl;
        this.baseAttackDamage = attackDamage;
        this.baseMagicResist = mr;
        this.magicResistPerLevel = mrPerLvl;
        this.imageUrl = "http://ddragon.leagueoflegends.com/cdn/7.5.2/img/champion/" + name + ".png";
    }

    public String getName() {
        return name;
    }
    public String getTitle() {
        return title;
    }
    public String getArmor() {
        return baseArmor.toString();
    }
    public String getHealthPoints() {
        return baseHealthPoints.toString();
    }
    public String getMagicResist() {
        return baseMagicResist.toString();
    }
    public String getAttack() {
        return baseAttackDamage.toString();
    }
    public String getArmorLvl() {
        return armorPerLevel.toString();
    }
    public String getMoveSpeed() {
        return moveSpeed.toString();
    }
    public String getHealthLvl() {
        return hpPerLevel.toString();
    }
    public String getMagicResistLvl() {
        return magicResistPerLevel.toString();
    }
    public String getImageUrl() { return imageUrl; }

}

