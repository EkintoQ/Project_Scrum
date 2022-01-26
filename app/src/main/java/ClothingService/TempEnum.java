package ClothingService;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum TempEnum {

    HOT(
            "lniana koszula, ołówkowa spódnica, czółenka na niskim obcasie",
            "lniany komplet garniturowy, lekka koszula, czółenka na słupku",
            "sukienka z krótkim rękawem, czółenka na szpilce",
            6,
            0,
            0,
            0
    ),
    WARM(
            "spodnie z nogawką w kant, koszula z rękawem 3/4, żakiet, czółenka na niskim obcasie",
            "ołówkowa spódnica, koszula, marynarka, czółenka na słupku",
            "sukienka z rękawem 3/4 , żakiet, czółenka na szpilce",
            8,
            0,
            0,
            0
    ),
    COLD(
            "koszula z długim rękawem, spodnie z nogawką w kant, żakiet, jesienny płaszcz, sztyblety",
            "sukienka z długim rękawem, trench, rajstopy lekkie, botki na obcasie",
            "ołówkowa spódnica, koszula z długim rękawem, żakiet, trench, botki na szpilce",
            10,
            0,
            0,
            0
    ),
    FREEZING(
            "koszula z długim rękawem, kardigan, spodnie w kant, rajstopy, zimowy płaszcz, szalik, rękawiczki, ocieplane botki",
            "sukienka z długim rękawem, żakiet, grube rajstopy, futro, rękawiczki, ocieplane botki na słupku",
            "koszula z długim rękawem, marynarka, spodnie w kant, rajstopy, puchowa kurtka, szalik, rękawiczki",
            16,
            0,
            0,
            0

    );

    private String set1;
    private String set2;
    private String set3;
    private int time;
    private int ratingForSet1;
    private int ratingForSet2;
    private int ratingForSet3;

    TempEnum(String set1, String set2, String set3, int time, int ratingForSet1, int ratingForSet2, int ratingForSet3) {
        this.set1 = set1;
        this.set2 = set2;
        this.set3 = set3;
        this.time = time;
        this.ratingForSet1 = ratingForSet1;
        this.ratingForSet2 = ratingForSet2;
        this.ratingForSet3 = ratingForSet3;
    }

    TempEnum() {
    }

    @NonNull
    public Map<String, Integer>  getAllSetsWithRatings(){
        Map<String, Integer> setsWithRatings = new HashMap<>();
        setsWithRatings.put(this.set1,this.ratingForSet1);
        setsWithRatings.put(this.set2,this.ratingForSet2);
        setsWithRatings.put(this.set3,this.ratingForSet3);
        return setsWithRatings;
    }

    public Map<String, Integer> setNewRating(@NonNull Map<String,Integer> setsWithRatings, String set, int newRating){
        setsWithRatings.replace(set,newRating);
        return setsWithRatings;
    }


    public String getRandomClothes(){
        String[] sets = new String[]{this.set1, this.set2, this.set3};
        Random random = new Random();
        return sets[random.nextInt(sets.length)];
    }

    public int getTime(){
        return this.time;
    }

    public String getSet1() {
        return set1;
    }

    public String getSet2() {
        return set2;
    }

    public String getSet3() {
        return set3;
    }

}