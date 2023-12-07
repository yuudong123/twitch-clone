package com.example.and00_twitchclone.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class StreamDTO implements Serializable {
    private String title;
    private int viewer;
    private ArrayList<String> tagList;
    private boolean live;
    private CategoryDTO categoryDTO;

    public StreamDTO(String title, int viewer, ArrayList<String> tagList, boolean live) {
        this.title = title;
        this.viewer = viewer;
        this.tagList = tagList;
        this.live = live;
    }

    public StreamDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public ArrayList<String> getTagList() {
        return tagList;
    }

    public void setTagList(ArrayList<String> tagList) {
        this.tagList = tagList;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

}
