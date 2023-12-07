package com.example.and00_twitchclone.alim;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlimDTO {
    private int image;
    private String category;
    private String dropName;
    private Date untilDate;
    private Date sendDate;

    public AlimDTO(int image, String category, String dropName, Date untilDate, Date sendDate) {
        this.image = image;
        this.category = category;
        this.dropName = dropName;
        this.untilDate = untilDate;
        this.sendDate = sendDate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDropName() {
        return dropName;
    }

    public void setDropName(String dropName) {
        this.dropName = dropName;
    }

    public String getUntilDate() {

        return new SimpleDateFormat("yyyy년 M월 d일 a h시 mm분 s초").format(this.untilDate);
    }

    public void setUntilDate(Date untilDate) {
        this.untilDate = untilDate;
    }

    public String getSendDate() {
        return new SimpleDateFormat("M월 d일").format(this.untilDate);
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }
}
