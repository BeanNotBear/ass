/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment01.entity;

/**
 *
 * @author nghin
 */
public class Lending {

    private String bcode;
    private String rcode;
    private int state;

    public Lending() {
    }

    public Lending(String bcode, String rcode, int state) {
        this.bcode = bcode;
        this.rcode = rcode;
        this.state = state;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getRcode() {
        return rcode;
    }

    public void setRcode(String rcode) {
        this.rcode = rcode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-10s | %-5s |",
                bcode, rcode, state);
    }
}