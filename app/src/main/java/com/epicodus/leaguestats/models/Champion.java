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
    public Double getBaseArmor() {
        return baseArmor;
    }
    public Double getBaseHealthPoints() {
        return baseHealthPoints;
    }
    public Double getBaseMagicResist() {
        return baseMagicResist;
    }
    public Double getBaseAttackDamage() {
        return baseAttackDamage;
    }
    public Double getArmorPerLevel() {
        return armorPerLevel;
    }
    public Double getMoveSpeed() {
        return moveSpeed;
    }
    public Double getHpPerLevel() {
        return hpPerLevel;
    }
    public Double getMagicResistPerLevel() {
        return magicResistPerLevel;
    }
    public String getImageUrl() { return imageUrl; }

}

