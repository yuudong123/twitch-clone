package com.example.and00_twitchclone.domain;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;

public class UserDTO implements Serializable, Comparable<UserDTO> {
    private String id, password, nickname;
    private int image;
    private ArrayList<CategoryDTO> flwCategory;
    private ArrayList<UserDTO> flwStreamer;
    private ArrayList<UserDTO> alimStreamer;
    private StreamDTO streamDTO;
    private int follower = 0;

    public UserDTO(String id, String password, String nickname, int image, ArrayList<CategoryDTO> flwCategory, ArrayList<UserDTO> flwStreamer) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.image = image;
        this.flwCategory = flwCategory;
        this.flwStreamer = flwStreamer;
        this.streamDTO = new StreamDTO();
        this.alimStreamer = new ArrayList<UserDTO>();
    }

    public ArrayList<UserDTO> getAlimStreamer() {
        return alimStreamer;
    }

    public void setAlimStreamer(ArrayList<UserDTO> alimStreamer) {
        this.alimStreamer = alimStreamer;
    }

    public UserDTO(String id, String password, String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }
    public int getFollower() {
        return follower;
    }

    public String getFollowerFormat() {
        int i = this.follower;
        return i >= 10000 ? String.format("%.2f만", i / 10000.0) : "" + i;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public ArrayList<CategoryDTO> getFlwCategory() {
        return flwCategory;
    }

    public void setFlwCategory(ArrayList<CategoryDTO> flwCategory) {
        this.flwCategory = flwCategory;
    }

    public ArrayList<UserDTO> getFlwStreamer() {
        return flwStreamer;
    }

    public ArrayList<UserDTO> getFlwStreamer(boolean online) {
        ArrayList<UserDTO> result = new ArrayList<>();
        if (online) {
            for (UserDTO streamer : flwStreamer) {
                if (streamer.getStreamDTO().isLive()) {
                    result.add(streamer);
                }
            }
            return result;
        } else {
            for (UserDTO streamer : flwStreamer) {
                if (!(streamer.getStreamDTO().isLive())) {
                    result.add(streamer);
                }
            }
            return result;
        }
    }


    public void setFlwStreamer(ArrayList<UserDTO> flwStreamer) {
        this.flwStreamer = flwStreamer;
    }

    public StreamDTO getStreamDTO() {
        return streamDTO;
    }

    public void setStreamDTO(StreamDTO streamDTO) {
        this.streamDTO = streamDTO;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        UserDTO param = (UserDTO) obj;
        return param.getId().equals(this.getId());
    }

    @Override
    public int compareTo(UserDTO userDTO) {
        if (this.streamDTO.getViewer() < userDTO.streamDTO.getViewer()) {
            return 1;
        } else if (this.streamDTO.getViewer() > userDTO.streamDTO.getViewer()) {
            return -1;
        }
        return 0;
    }
}
