package com.example.arad_sheybak.englishlearning.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arad_Sheybak on 7/15/2017.
 */

public class MovieResponse {
    @SerializedName("movieName")
    private String name;
    @SerializedName("description")
    private String descript;
    @SerializedName("file")
    private String file;
    @SerializedName("pic")
    private String pic;
    private int id;
    private String category;
    private boolean isSeen;

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
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

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
