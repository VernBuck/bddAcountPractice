package com.company;

public class Accounts {
    private Account[] x;
    private Account[] y;

    public Accounts(Account[] x, Account[] y) {
        this.x = x;
        this.y = y;
    }

    public void setX(Account[] nX) {
        this.x =x;
    }

    public void setY(Account[] nY) {
        this.y =y;
    }

    public Account[] getX() {
        return x;
    }

    public Account[] getY() {
        return y;
    }
    public String toString(){
        return ""+this.getX()+""+this.getY()+"";
    }
}
