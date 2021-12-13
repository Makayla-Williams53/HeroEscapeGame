//import random class
import java.util.Random;

public class Potion {
    // create random variables
    Random rand = new Random();

    // 1) Instance variables
    private String name;
    private int ability;
    private int odds;

    // other variables
    private int randNum;

    // 2)Constructors;
    public Potion(String name, int ability, int odds)
    {
        this.name = name;
        this.ability = ability;
        this.odds = odds;
    }// end full constructor

    public Potion()
    {
        name = "";
        ability = 0;
        odds = 0;
    }// end default constructor

    // 4)getters
    public String getName()
    {
        return name;
    }

    public int getAbility()
    {
        return ability;
    }

    public int getOdds()
    {
        return odds;
    }

    // 5) setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setAbility(int ability)
    {
        this.ability = ability;
    }

    public void setOdds(int odds)
    {
        this.odds = odds;
    }

    // 6) brain methods
    //use brain method
    public void use(Hero victim, int odds, int ability)
    {
        //set randNum variable to a number between 0 and 100 inlcusive
        randNum = rand.nextInt(101);

        //if randNum is less than or equal to the odds variable than have the potion work
        if (randNum <= odds) {
            //call the victim heal brain method and pass the ability integer as a parameter
            victim.heal(ability);
            //print out how many health points it healed
            System.out.println("\nYour potion healed " + ability + " health");
        }//end if statement
        //otherwise the potion didn't work
        else
        {
            //print out that the potion didn't work
            System.out.println("\nYour potion failed");
        }//end else statement
    }//end use brain method

    // 3) toString
    public String toString() {
        String output = "Name: " + name + "Ability: " + ability + "Odds: " + odds;
        return output;
    }//end toString method
}//end potion class
