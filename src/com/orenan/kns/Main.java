package com.orenan.kns;
import java.util.Scanner;
import java.util.Random;

public class Main {

    static String userName;

    Hero userHero = new Hero();

    Boss aquarius = new Boss();

    Minion minions = new Minion();


    public static  void main(String[] args) {

        System.out.println("Enter your name(only letters, no numbers or symbols):");
        Scanner userNameInput = new Scanner(System.in);
        userName = userNameInput.next();


        Main startGame = new Main();
        startGame.LevelOne();

    }

    public void restartGame(){

        System.out.println("Enter 1 to restart the game!\n");
        Scanner restartInput = new Scanner(System.in);
        int restartGame = restartInput.nextInt();

        if(restartGame == 1){

            LevelOne();

        }
    }

    public void LevelOne(){

        userHero.name = userName;
        userHero.exp = 1;

        userHero.CharLevel();

        System.out.println("Your hero name is: " + userHero.name.toUpperCase() + "\n"
                + "Your attributes are: \n" +
                "LEVEL: " + userHero.charLvl + "\n" +
                "HP: " + userHero.hp +"\n" +
                "ATTACK DAMAGE: " + userHero.atkDmg + "\n" +
                "CRITICAL ATTACK DAMAGE: " + userHero.critDmg + "\n" +
                "CHANCE OF A CRITIC: 30%\n");

        System.out.println("You have entered a cave, choose a door: \n" +
                "1 - Water Door \n" +
                "2 - Stone Door \n");

        Scanner doorInput = new Scanner(System.in);
        int doorChoice = doorInput.nextInt();

        //aquarius STAGE
        if(doorChoice == 1){


            System.out.println("You have opened the water door and saw aquarius, what are you gonna do? \n" +
                    "1 - Try to find a door to scape on the left. \n" +
                    "2 - Try to find a door to scape on the right. \n" +
                    "3 - Fight Him.\n");

            Scanner waterActionInput = new Scanner(System.in);
            int waterAction = waterActionInput.nextInt();

            //RUNNING THROUGH THE WRONG DOOR.

            if(waterAction == 1){

                System.out.println("You ran to the left and didn't find anything \n" +
                        "YOU ARE DEAD!");

                //RUNNING THROUGH THE RIGHT DOOR.

            }else if(waterAction == 2){

                System.out.println("YOU RAN TO THE RIGHT AND FIND A DOOR, YOU GO THROUGH IT  \n" +
                        "AND RETURN TO THE PREVIOUS STAGE");

                LevelOne();

                //##############AQUARIUS FIGHT################


                //IF THE HERO IS LVL 1
            }else if(waterAction == 3){
                if(userHero.charLvl == 1) {
                    aquarius.name = "aquarius";
                    aquarius.whichBoss();
                    int damage[] = {3, 3, 6, 3, 3, 6, 3, 6, 3, 3};
                    int dmgPick = new Random().nextInt(10);
                    userHero.atkDmg = damage[dmgPick];

                    battle();

                }
            }

        }


        //################ROCKS STAGE##################
        else if(doorChoice == 2){

            System.out.println("MINIONS STAGE, do you want to fight them or run away? \n" +
                    "1 - Run away. \n" +
                    "2 - Fight them. \n");
            Scanner minionsStageChoiceInput = new Scanner(System.in);
            int minionsStageChoice = minionsStageChoiceInput.nextInt();

            //RETURNING TO THE DOORS STAGE
            if(minionsStageChoice == 1){

                LevelOne();

            //FIGHTING THE MINIONS FOR EXPERIENCE
            }else if(minionsStageChoice == 2){
                System.out.println("You have entered the minions stage, fight them! \n" +
                        "You hit the minions and killed them!\n");
                userHero.exp = userHero.exp + 10;

                userHero.CharLevel();

                System.out.println("Your hero name is: " + userHero.name.toUpperCase() + "\n"
                        + "Your attributes are now: \n" +
                        "LEVEL: " + userHero.charLvl + "\n" +
                        "HP: " + userHero.hp + "\n" +
                        "ATTACK DAMAGE: " + userHero.atkDmg + "\n" +
                        "CRITICAL ATTACK DAMAGE: " + userHero.critDmg + "\n" +
                        "CHANCE OF A CRITIC: 40%\n");

                System.out.println("You are headed to the next stage now, good luck!\n");
        //THIS PART GOES TO FIGHT AQUARIUS
                aquariusStage();

            }

        }
    } // END OF LEVELONE.

    public void aquariusStage(){

        System.out.println("You have opened the water door and saw AQUARIUS THE WATER BOSS, FIGHT HIM? \n" +
                "1 - Yes.\n" +
                "2 - No, quit game.\n");
        Scanner fightHimInput = new Scanner(System.in);
        int fightHim = fightHimInput.nextInt();
        if(fightHim == 1){

            aquarius.name = "aquarius";
            aquarius.whichBoss();
            int damage[] = {5, 5, 10, 5, 5, 10, 5, 10, 5, 10};
            int dmgPick = new Random().nextInt(10);
            userHero.atkDmg = damage[dmgPick];

            battle();

        }else{

            System.out.println("Bye, thanks for playing!\n");

        }

    }

    public void battle(){

        while(aquarius.hp > 0) {

            if (userHero.hp > 0) {
                aquarius.hp = aquarius.hp - userHero.atkDmg;

                System.out.println("YOU have hit AQUARIUS with " + userHero.atkDmg + " " + "points of damage and \n" +
                        "HIS life is now: " + aquarius.hp + "\n");

            }

            if (aquarius.hp <= 0) {

                System.out.println("YOU have hit AQUARIUS with " + userHero.atkDmg + " " + "points of damage and \n" +
                        "KILLED HIM AND GOT 10 EXP AND RESTORED YOUR HEALTH POINTS.\n");

                userHero.exp = userHero.exp + 10;

                userHero.CharLevel();


                System.out.println("Your hero name is: " + userHero.name.toUpperCase() + "\n"
                        + "Your attributes are now: \n" +
                        "LEVEL: " + userHero.charLvl + "\n" +
                        "HP: " + userHero.hp + "\n" +
                        "ATTACK DAMAGE: " + userHero.atkDmg + "\n" +
                        "CRITICAL ATTACK DAMAGE: " + userHero.critDmg + "\n" +
                        "CHANCE OF A CRITIC: 40%\n");
                break; // THIS PART SHOULD GO THE NEXT LEVEL!!!

            }

            userHero.hp = userHero.hp - aquarius.atkDmg;

            if (userHero.hp <= 0) {

                System.out.println("AQUARIUS hits you with " + aquarius.atkDmg + " " + "points of damage and \n" +
                        "YOUR life is now: " + userHero.hp + "\n" +
                        "YOU HAVE DIED! TRY AGAIN!!!\n");
                restartGame();

            }else{

                System.out.println("AQUARIUS hits you with " + aquarius.atkDmg + " " + "points of damage and \n" +
                        "YOUR life is now: " + userHero.hp + "\n");

            }
        }

    }// END OF BATTLE.
}
