/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thjava;

/**
 *
 * @author Admin
 */
public class NguoiDung {

    private int noAccount;
    private String nameAccount;
    private double moneyAccount;

    public NguoiDung(int no, String name, double money) {
        noAccount = no;
        nameAccount = name;
        moneyAccount = money;

    }

    /**
     * @return the noAccount
     */
    public int getNoAccount() {
        return noAccount;
    }

    /**
     * @param noAccount the noAccount to set
     */
    public void setNoAccount(int noAccount) {
        this.noAccount = noAccount;
    }

    /**
     * @return the nameAccount
     */
    public String getNameAccount() {
        return nameAccount;
    }

    /**
     * @param nameAccount the nameAccount to set
     */
    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    /**
     * @return the moneyAccount
     */
    public double getMoneyAccount() {
        return moneyAccount;
    }

    /**
     * @param moneyAccount the moneyAccount to set
     */
    public void setMoneyAccount(double moneyAccount) {
        this.moneyAccount = moneyAccount;
    }
}
