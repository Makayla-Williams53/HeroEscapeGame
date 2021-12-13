//imports random class
import java.util.Random;

public class Villain
{
    // create random variable
    Random rand = new Random();

    // 1)Instance Variables
    private String name;
    private String weapon;
    private String quote;
    private int health;

    // other Variables
    int randNum;

    // 2)Constructor
    public Villain(String name, String weapon, String quote, int health)
    {
        this.name = name;
        this.weapon = weapon;
        this.quote = quote;
        this.health = health;
    }// end full constructor

    public Villain()
    {
        name = "";
        weapon = "";
        quote = "";
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

    public String getQuote()
    {
        return quote;
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

    public void setQuote(String quote)
    {
        this.quote = quote;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    // 6)Brain Methods
    // attack brain method
    public void attack(Hero victim)
    {
        // set randNum variable to a number between 0 and 100 inclusive
        randNum = rand.nextInt(101);

        //if randNum is greater than 85 exclusive have the attack do 35 points of damage
        if(randNum > 85)
        {
            //set the victim's (usually the hero's) health to 35 points less than what it was
            victim.setHealth(victim.getHealth() - 35);

            //prints out little story snippet at says how much damage the attack did
            System.out.println(name + " laughs a booming laugh that would give Odin himself chills, then he attacks our hero, " + victim.getName());
            System.out.println(name + "\'s attack does 35 points of damage");
        }//end if statement
        //if randNum is between 66 and 85 inclusive have the attack do 10 points of damage
        else if (randNum > 65 && randNum <= 85)
        {
            //set the victim's (usually the hero's) health to 10 points less than what it was
            victim.setHealth(victim.getHealth() - 10);

            //prints out little story snippet at says how much damage the attack did
            System.out.println(name + " gives " + victim.getName() + " a psychotic smile and then attacks.");
            System.out.println(name + "\'s attack does 10 points of damage");
        }//end else-if statement
        //if randNum is between 41 and 65 inclusive have the attack do 15 points of damage
        else if (randNum > 40 && randNum <= 65)
        {
            //set the victim's (usually the hero's) health to 15 points less than what it was
            victim.setHealth(victim.getHealth() - 15);

            //prints out little story snippet at says how much damage the attack did
            System.out.println("With his deep earth trembling voice " + name + " says \n\t\"" + quote + "\"");
            System.out.println(name + "\'s attack does 15 points of damage");
        } //end else-if statement
        //otherwise have the attack do 25 points of damage
        else
        {
            //set the victim's (usually the hero's) health to 25 points less than what it was
            victim.setHealth(victim.getHealth() - 25);

            //prints out little story snippet at says how much damage the attack did
            System.out.println("With his mighty " + weapon + " " + name + " charges.");
            System.out.println(name + "\'s attack does 25 points of damage");
        }//end else statement
    }//end attack brain method

    // ToString
    public String toString() {
        String output = "Name: " + name + "\nWeapon: " + weapon + "\nQuote: " + quote + "\nHealth: " + health;
        return output;
    }//end toString method
}//end villain class