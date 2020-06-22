package com.example.scm.Bean;


import java.sql.Blob;

/**
 * Created by jigar on 5/30/2019.
 */

public class Bean_Circular {
    private int CNo;
    private String CDate;
    private byte[] Circular;

    public int getCNo() {
        return CNo;
    }

    public void setCNo(int CNo) {
        this.CNo = CNo;
    }

    public String getCDate() {
        return CDate;
    }

    public void setCDate(String CDate) {
        this.CDate = CDate;
    }

    public byte[] getCircular() {
        return Circular;
    }

    public void setCircular(byte[] circular) {
        Circular = circular;
    }
}

