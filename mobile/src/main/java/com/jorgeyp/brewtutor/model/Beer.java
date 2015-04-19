package com.jorgeyp.brewtutor.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by jorge on 15/4/15.
 */
public class Beer implements Serializable{
    // Details
    private int id;
    private String name;
    private int style;
    private String description;
    private int time;
    private float abv;
    private float ibu;
    private float ebc;
    // For the mash
    private float mashVol;
    private int mashTime;
    private int mashTemp;
    private Ingredient[] grains;
    // For the boil
    private float boilVol;
    private float boilTime;
    private Ingredient[] hops;
    private Ingredient[] extras;
    // For the fermentation
    private int fermentationTemp;
    private long fermentationTime;
    private long conditioningTime;
    private int conditioningTemp;
    private String yeast;

    public Beer() {}

    public Beer(int id, String name, int style, String description, int time, float abv, float ibu, float ebc, float mashVol, int mashTime, int mashTemp, Ingredient[] grains, float boilVol, float boilTime, Ingredient[] hops, Ingredient[] extras, int fermentationTemp, int fermentationTime, int conditioningTime, int conditioningTemp, String yeast) {
        this.id = id;
        this.name = name;
        this.style = style;
        this.description = description;
        this.time = time;
        this.abv = abv;
        this.ibu = ibu;
        this.ebc = ebc;
        this.mashVol = mashVol;
        this.mashTime = mashTime;
        this.mashTemp = mashTemp;
        this.grains = grains;
        this.boilVol = boilVol;
        this.boilTime = boilTime;
        this.hops = hops;
        this.extras = extras;
        this.fermentationTemp = fermentationTemp;
        this.fermentationTime = fermentationTime;
        this.conditioningTime = conditioningTime;
        this.conditioningTemp = conditioningTemp;
        this.yeast = yeast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public float getAbv() {
        return abv;
    }

    public void setAbv(float abv) {
        this.abv = abv;
    }

    public float getIbu() {
        return ibu;
    }

    public void setIbu(float ibu) {
        this.ibu = ibu;
    }

    public float getEbc() {
        return ebc;
    }

    public void setEbc(float ebc) {
        this.ebc = ebc;
    }

    public float getMashVol() {
        return mashVol;
    }

    public void setMashVol(float mashVol) {
        this.mashVol = mashVol;
    }

    public int getMashTime() {
        return mashTime;
    }

    public void setMashTime(int mashTime) {
        this.mashTime = mashTime;
    }

    public int getMashTemp() {
        return mashTemp;
    }

    public void setMashTemp(int mashTemp) {
        this.mashTemp = mashTemp;
    }

    public Ingredient[] getGrains() {
        return grains;
    }

    public void setGrains(Ingredient[] grains) {
        this.grains = grains;
    }

    public float getBoilVol() {
        return boilVol;
    }

    public void setBoilVol(float boilVol) {
        this.boilVol = boilVol;
    }

    public float getBoilTime() {
        return boilTime;
    }

    public void setBoilTime(float boilTime) {
        this.boilTime = boilTime;
    }

    public Ingredient[] getHops() {
        return hops;
    }

    public void setHops(Ingredient[] hops) {
        this.hops = hops;
    }

    public Ingredient[] getExtras() {
        return extras;
    }

    public void setExtras(Ingredient[] extras) {
        this.extras = extras;
    }

    public int getFermentationTemp() {
        return fermentationTemp;
    }

    public void setFermentationTemp(int fermentationTemp) {
        this.fermentationTemp = fermentationTemp;
    }

    public long getConditioningTime() {
        return conditioningTime;
    }

    public void setConditioningTime(long conditioningTime) {
        this.conditioningTime = conditioningTime;
    }

    public int getConditioningTemp() {
        return conditioningTemp;
    }

    public void setConditioningTemp(int conditioningTemp) {
        this.conditioningTemp = conditioningTemp;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", style=" + style +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", abv=" + abv +
                ", ibu=" + ibu +
                ", ebc=" + ebc +
                ", mashVol=" + mashVol +
                ", mashTime=" + mashTime +
                ", mashTemp=" + mashTemp +
                ", grains=" + Arrays.toString(grains) +
                ", boilVol=" + boilVol +
                ", boilTime=" + boilTime +
                ", hops=" + Arrays.toString(hops) +
                ", extras=" + Arrays.toString(extras) +
                ", fermentationTemp=" + fermentationTemp +
                ", conditioningTime=" + conditioningTime +
                ", conditioningTemp=" + conditioningTemp +
                ", yeast='" + yeast + '\'' +
                '}';
    }

    public long getFermentationTime() {
        return fermentationTime;
    }

    public void setFermentationTime(long fermentationTime) {
        this.fermentationTime = fermentationTime;
    }
}
