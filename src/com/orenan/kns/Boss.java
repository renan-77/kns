package com.orenan.kns;

public class Boss {
    String name;
    int hp;
    int atkDmg;
    int expDrop;

    public void whichBoss(){

        if(name == "aquarius"){

            hp = 13;
            atkDmg = 4;
            expDrop = 10;

        }

    }

    public void aquariusLevelUp(){


        Main importMain = new Main();
        importMain.userHero.exp = 11;
        importMain.userHero.CharLevel();

    }


}
