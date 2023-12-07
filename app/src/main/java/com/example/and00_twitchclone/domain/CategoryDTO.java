package com.example.and00_twitchclone.domain;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryDTO implements Serializable, Comparable<CategoryDTO> {
    private String name;
    private int image;
    private ArrayList<String> tagList;
    private int viewer;

    public CategoryDTO(String name, int image, ArrayList<String> tagList) {
        this.name = name;
        this.image = image;
        this.tagList = tagList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<String> getTagList() {
        return tagList;
    }

    public void setTagList(ArrayList<String> tagList) {
        this.tagList = tagList;
    }

    public int getViewer() {
        return viewer;
    }

    public String getViewerFormat() {
        int i = this.viewer;
        return i >= 10000 ? String.format("%.2f만", i / 10000.0) : "" + i;
    }

    public void setViewer(int viewer) {
        this.viewer = viewer;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        CategoryDTO param = (CategoryDTO) obj;
        return param.getName().equals(this.getName());
    }

    @Override
    public int compareTo(CategoryDTO categoryDTO) {
        if (this.getViewer() < categoryDTO.getViewer()) {
            return 1;
        } else if (this.getViewer() > categoryDTO.getViewer()) {
            return -1;
        }
        return 0;
    }
}
