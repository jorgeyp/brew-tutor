package com.jorgeyp.brewtutor.model;

/**
 * Created by jorge on 15/4/15.
 */
public class Beer {
    private int id;
    private String name;
    private String style;
    private String description;
    private int time;
    private float abv;
    private float ibu;
    private float ebc;

    public Beer() {}

    public Beer(String name, String style, String description, int time, float abv, float ibu, float ebc) {
        super();
        this.name = name;
        this.style = style;
        this.description = description;
        this.time = time;
        this.abv = abv;
        this.ibu = ibu;
        this.ebc = ebc;
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

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
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

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", style='" + style + '\'' +
                ", description='" + description + '\'' +
                ", time=" + time +
                ", abv=" + abv +
                ", ibu=" + ibu +
                ", ebc=" + ebc +
                '}';
    }
}
