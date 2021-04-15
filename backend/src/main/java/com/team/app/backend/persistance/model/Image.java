package com.team.app.backend.persistance.model;

public class Image {
    String name;
    byte[] picByte;

    public Image(String name, byte[] picByte) {
        this.name = name;
        this.picByte = picByte;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
