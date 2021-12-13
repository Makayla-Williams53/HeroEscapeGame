//import random class
import java.util.Random;

//implement Comparable interface
public class Hero implements Comparable
{
    // create random variables
    Random rand = new Random();

    // 1) Instance variables
    private String name;
    private String weapon;
    private int health;

    // other variables
    int randNum = rand.nextInt(101);

    // 2) constructors
    public Hero(String name, String weapon, int health)
    {
        this.name = name;
        this.weapon = weapon;
        this.health = health;
    }// end full constructor

    public Hero(int health)
    {
        name = "";
        weapon = "";
        this.health = health;
    }// end custom constructor for just name

    public Hero()
    {
        name = "";
        weapon = "";
        health = 0;
    }// end default constructor

    // 4) Getters
    public String getName()
    {
        return name;
    }

    public String getWeapon()
    {
        return weapon;
    }

    public int getHealth()
    {
        return health;
    }

    // 5) Setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setWeapon(String weapon)
    {
        this.weapon = weapon;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    // 6) Brain Methods
    // attack brain method
    public void attack(Villain victim)
    {
        // sets randNum variable to a random number between 0 and 100 inclusive
        randNum = rand.nextInt(101);

        // if randNum is greater than 80 have the attack do 10 points of damage
        if (randNum > 80)
        {
            // sets the victim's(usually the villain's) health 10 points less than what it was
            victim.setHealth(victim.getHealth() - 10);

            // prints out little story snippet at says how much damage the attack did
            System.out.println("\nOur hero gives a nervous chuckle then attacks.");
            System.out.println("Their attack did 10 points of damage");
        }// end if statment
        // if randNum is between 51 and 80 inclusive the attack does 15 points of damage
        else if (randNum > 50 && randNum <= 80)
        {
            // sets the victim's(usually the villain) health 15 points less than what it was
            victim.setHealth(victim.getHealth() - 15);

            // prints out little story snippet at says how much damage the attack did
            System.out.println("\nThe hero in a rather shaky voice says \n\t\"I will beat you even if it's the last thing I do\"");
            System.out.println("Their attack did 15 points of damage");
        }// end else if statement
        //otherwise the randNum was between 0 and 50 inlcusive and the attack does 25 points of damage
        else
        {
            // sets the victim's(usually the villain's) health 25 points less than what it was
            victim.setHealth(victim.getHealth() - 25);

            // prints out little story snippet at says how much damage the attack did
            System.out.println("\nWith their trusty " + weapon + " they charged");
            System.out.println("Their attack did 25 points of damage");
        }// end else statment
    }// end attack brain method

    //heal brain method
    public void heal(int amount)
    {
        //incrase the health variable by the integer amount that was passed through
        health = health + amount;
    }//end heal brain method

    // run brain method
    public boolean run()
    {
        // set randNum to a number between 0 and 100 inclusive
        randNum = rand.nextInt(101);

        // create a boolean for the output
        boolean output;

        // if randNum is greater than 81 inclusive set the output boolean to true(the run attempt worked)
        if (randNum >= 80)
        {
            output = true;
        }// end if statement
        // otherwise set output boolean to false(the run attempt failed)
        else
        {
            output = false;
        } // end else statment

        // return the output boolean
        return output;
    }// end run brain method

    // 3) ToString
    public String toString()
    {
        String output = "Name: " + name + "\nWeapon: " + weapon + "\nHealth: " + health;
        return output;
    }

    // compareTo method
    @Override
    public int compareTo(Object villain)
    {
        // variable for the output. default says the two health amonts were the same with the int 0
        int output = 0;

        // if the hero has more health than the victim that was passed as a parameter set output to 1
        if (this.health > ((Villain) villain).getHealth())
        {
            output = 1;
        }// end if statement
        // if the villain that was passed thorugh has more health than the hero set the output to -1
        else if (this.health < ((Villain) villain).getHealth())
        {
            output = -1;
        } // end else if statement

        // return output variable
        return output;
    }// end compareTo method
}// end Hero class
