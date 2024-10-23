package org.game;

public class Rogue extends Entity {
     @Override
    public  void takeDamage(int damage){

    }
    @Override
    public  void kill( ){
        System.out.println("This is as far as you go...")
        System.exit(0);
    }
    @Override
    public  String genWarcry(){
        return "...";

    }
}
