package com.example.scm.Bean;



import java.util.Date;

/**
 * Created by jigar on 5/30/2019.
 */

public class Bean_Library {
    private int SID;
    private String BOOK;
    private String ISSUE;
    private String DUE;
    private String SUBMIT;

    public int getSID() {
        return SID;
    }

    public void setSID(int SID) {
        this.SID = SID;
    }

    public String getBOOK() {
        return BOOK;
    }

    public void setBOOK(String BOOK) {
        this.BOOK = BOOK;
    }

    public String getISSUE() {
        return ISSUE;
    }

    public void setISSUE(String ISSUE) {
        this.ISSUE = ISSUE;
    }

    public String getDUE() {
        return DUE;
    }

    public void setDUE(String DUE) {
        this.DUE = DUE;
    }

    public String getSUBMIT() {
        return SUBMIT;
    }

    public void setSUBMIT(String SUBMIT) {
        this.SUBMIT = SUBMIT;
    }
}

