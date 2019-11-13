package lesson5;

import java.util.Random;

public class Animal {

    protected String name;
    private int limitRun;
    private Double limitJum;
    private int limitSwim;
    private  Random random = new Random();

    protected Animal(int limitRun, Double limitJum, int limitSwim, String name){
        this.limitRun = random.nextInt(limitRun) + limitRun / 3;
        this.limitJum = limitJum;
        this.limitSwim = limitSwim > 0 ? random.nextInt(limitSwim) + limitSwim / 3 : limitSwim;
        this.name = name;
    }

    protected void run(int limit){
        if (limit > 0 && limit <= limitRun){
            System.out.println(this.name + " побежал!");
        } else {
            System.out.println(this.name + " не добажал!");
        }
    }

    protected void swim(int limit){
        if (limit > 0 && limit <= limitSwim){
            System.out.println(this.name + " поплыл!");
        } else {
            System.out.println(this.name + " не доплыл!");
        }
    }

    protected void jump(Double limit){
        if (limit > 0 && limit <= limitJum){
            System.out.println(this.name + " допрыгнул!");
        } else {
            System.out.println(this.name + " не допрыгнул!");
        }
    }
}
