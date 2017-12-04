package com.example.khalessi.pizzabestellen;

/**
 * Created by milde on 04.12.17.
 */

public class Bestellung {
    private String teig;
    private String belag1;
    private String belag2;
    private String belag3;
    private String kaese;
    private String wurst;

    // setter
    public void setTeig(String teig) {
        this.teig = teig;
    }

    public void setBelag1(String belag1) {
        this.belag1 = belag1;
    }

    public void setBelag2(String belag2) {
        this.belag2 = belag2;
    }

    public void setBelag3(String belag3) {
        this.belag3 = belag3;
    }

    public void setKaese(String kaese) {
        this.kaese = kaese;
    }

    public void setWurst(String wurst) {
        this.wurst = wurst;
    }

    // getter

    public String getTeig() {
        return teig;
    }

    public String getBelag1() {
        return belag1;
    }

    public String getBelag2() {
        return belag2;
    }

    public String getBelag3() {
        return belag3;
    }

    public String getKaese() {
        return kaese;
    }

    public String getWurst() {
        return wurst;
    }


    //

    @Override
    public String toString() {
        String bestellung = ""
                + getTeig() + ", "
                + getBelag1() + ", "
                + getBelag2() + ", "
                + getBelag3() + ", "
                + getWurst() + ", "
                + getKaese();
        return bestellung;
    }
}
