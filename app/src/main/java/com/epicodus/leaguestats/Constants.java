package com.epicodus.leaguestats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Guest on 6/1/17.
 */

public class Constants {
    public static final String[] Champions = new String[] {"Annie", "Olaf", "Galio", "Twisted Fate", "Xin Zhao", "Urgot", "LeBlanc", "Vladimir", "Fiddlesticks", "Kayle", "Master Yi", "Alistar", "Ryze", "Sion", "Sivir", "Soraka", "Teemo", "Tristana", "Warwick", "Nunu", "Miss Fortune", "Ashe", "Tryndamere", "Jax", "Morgana", "Zilean", "Singed", "Evelynn", "Twitch", "Karthus", "Cho'Gath", "Amumu", "Rammus", "Anivia", "Shaco", "Dr. Mundo", "Sona", "Kassadin", "Irelia", "Janna", "Gangplank", "Corki", "Karma", "Taric", "Veigar", "Trundle", "Swain", "Caitlyn", "Blitzcrank", "Malphite", "Katarina", "Nocturne", "Maokai", "Renekton", "Jarvan IV", "Elise", "Orianna", "Wukong", "Brand", "Lee Sin", "Vayne", "Rumble", "Cassiopeia", "Skarner", "Heimerdinger", "Nasus", "Nidalee", "Udyr", "Poppy", "Gragas", "Pantheon", "Ezreal", "Mordekaiser", "Yorick", "Akali", "Kennen", "Garen", "Leona", "Malzahar", "Talon", "Riven", "Kog'Maw", "Shen", "Lux", "Xerath", "Shyvana", "Ahri", "Graves", "Fizz", "Volibear", "Rengar", "Varus", "Nautilus", "Viktor", "Sejuani", "Fiora", "Ziggs", "Lulu", "Draven", "Hecarim", "Kha'Zix", "Darius", "Jayce", "Lissandra", "Diana", "Quinn", "Syndra", "Aurelion Sol", "Zyra", "Gnar", "Zac", "Yasuo", "Vel'Koz", "Taliyah", "Camille", "Braum", "Jhin", "Kindred", "Jinx", "Tahm Kench", "Lucian", "Zed", "Kled", "Ekko", "Vi", "Aatrox", "Nami", "Azir", "Thresh", "Illaoi", "Rek'Sai", "Ivern", "Kalista", "Bard", "Rakan", "Xayah"};

    public static final String[] ChampionId = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "48", "50", "51", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "67", "68", "69", "72", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "89", "90", "91", "92", "96", "98", "99", "101", "102", "103", "104", "105", "106", "107", "110", "111", "112", "113", "114", "115", "117", "119", "120", "121", "122", "126", "127", "131", "133", "134", "136", "143", "150", "154", "157", "161", "163", "164", "201", "202", "203", "222", "223", "236", "238", "240", "245", "254", "266", "267", "268", "412", "420", "421", "427", "429", "432", "497", "498"};


    public static final String RIOT_KEY = BuildConfig.RIOT_KEY;
    public static final String RIOT_STATIC_BASE_URL = "https://na1.api.riotgames.com/lol/static-data/v3/champions/";
    public static final String RIOT_SUMMONER_BASE_URL = "https://na1.api.riotgames.com/lol/summoner/v3/summoners/by-name";
    public static final String RIOT_CHAMPSTATS_QUERY_PARAMETER = "tags=stats";
}
