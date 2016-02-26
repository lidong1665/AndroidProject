package com.chni.lidong.androidtestdemo;

import com.chni.lidong.androidtestdemo.Entity;

/**
 * Created by Chen on 2015/11/5.
 */
public class Person extends Entity {

    private  int s;
    private  int j;

    public Person(int id) {
        super(id);
    }

    public Person(int s, int id){
        super(id);
        this.s=s;
    }

    public Person(int s, int id,int j){
        this(id,s);
        this.j=j;
    }
}
