/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_eduardoguevara;

/**
 *
 * @author edujg
 */
public class SerVivo {

    private String raza;
    private int ki;
    private int maxage;
    private String planeta;

    public SerVivo() {
    }

    public SerVivo(String raza, int ki, int maxage, String planeta) {
        this.raza = raza;
        this.ki = ki;
        this.maxage = maxage;
        this.planeta = planeta;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getKi() {
        return ki;
    }

    public void setKi(int ki) {
        this.ki = ki;
    }

    public int getMaxage() {
        return maxage;
    }

    public void setMaxage(int maxage) {
        this.maxage = maxage;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }

    @Override
    public String toString() {
        return "Raza: " + raza + "\n  Ki=" + ki;
    }

}
