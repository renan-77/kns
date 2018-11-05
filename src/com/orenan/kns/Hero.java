package com.orenan.kns;

public class Hero {
    String name;
    int exp;
    int charLvl;
    int hp;
    int atkDmg;
    int critDmg;


    public void CharLevel(){

        if((exp >= 0) && (exp < 10)){

            charLvl = 1;
            hp = 15;
            atkDmg = 3;
            critDmg = atkDmg * 2;

        }if((exp >= 10) && (exp < 20)){

            charLvl = 2;
            hp = 19;
            atkDmg = 5;
            critDmg = atkDmg * 2;

        }if((exp >= 20) && (exp < 30)){

            charLvl = 3;
            hp = 23;
            atkDmg = 7;
            critDmg = atkDmg * 2;

        }if((exp >= 30) && (exp < 40)){

            charLvl = 4;
            hp = 27;
            atkDmg = 9;
            critDmg = atkDmg * 2;

        }if((exp >= 40) && (exp < 50)){

            charLvl = 5;
            hp = 31;
            atkDmg = 11;
            critDmg = atkDmg * 2;
        }


    }

}
