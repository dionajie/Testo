package com.dionajie.root.testo.Model;

import android.media.Image;

import com.dionajie.root.testo.EventActivity;

import java.util.Date;

/**
 * Created by root on 25/02/15.
 */
public class Event extends EventActivity {
    public String event;
    public Image gambar;
    public String tanggal;

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public Image getGambar() {
        return gambar;
    }

    public void setGambar(Image gambar) {
        this.gambar = gambar;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
