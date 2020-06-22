package com.example.scm.Bean;


/**
 * Created by jigar on 5/30/2019.
 */

public class Bean_Fees {
    private int sid;
    private double TotalFees;
    private double PaidFees;
    private int Installment;
    private double DueFees;

    public double getDueFees() {
        return DueFees;
    }

    public void setDueFees(double dueFees) {
        this.DueFees = dueFees;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public double getTotalFees() {
        return TotalFees;
    }

    public void setTotalFees(double totalFees) {
        TotalFees = totalFees;
    }

    public double getPaidFees() {
        return PaidFees;
    }

    public void setPaidFees(double paidFees) {
        PaidFees = paidFees;
    }

    public int getInstallment() {
        return Installment;
    }

    public void setInstallment(int installment) {
        Installment = installment;
    }
}
