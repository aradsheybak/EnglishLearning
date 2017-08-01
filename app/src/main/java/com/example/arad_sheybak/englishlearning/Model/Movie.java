package com.example.arad_sheybak.englishlearning.Model;

/**
 * Created by Arad_Sheybak on 7/15/2017.
 */

public class Movie {
    private String name;
    private String description;
    private String pic;
    private boolean isSeen;
    private String category;
    private String file;
    private int id;

    public Movie(String category, String name, String description, int id, String pic, boolean isSeen, String file) {
        this.name = name;
        this.description = description;
        this.pic = pic;
        this.isSeen = isSeen;
        this.category = category;
        this.id=id;
        this.file=file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getpic() {
        return pic;
    }

    public void setpic(String imgMovie) {
        this.pic = imgMovie;
    }

    public boolean isSeen() {
        return isSeen;
    }

    public void setSeen(boolean seen) {
        isSeen = seen;
    }
    public String toString(){
        return "Movie{"+",Name'"+name+'\''+", Descriptoin'"+description+'\''+", ImgMovie'"+pic+'\''+", Id'"+id+", file'"+file+'\''+'}';
    }
}
