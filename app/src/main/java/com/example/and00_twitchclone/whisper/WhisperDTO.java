package com.example.and00_twitchclone.whisper;

import com.example.and00_twitchclone.domain.UserDTO;

import java.io.Serializable;
import java.util.ArrayList;

public class WhisperDTO implements Serializable {
    private UserDTO other;
    private ArrayList<String> history = new ArrayList<>();

    public WhisperDTO(UserDTO other) {
        this.other = other;
    }

    public UserDTO getOther() {
        return other;
    }

    public void setOther(UserDTO other) {
        this.other = other;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
