//import random and scanner classes
import java.util.Random;
import java.util.Scanner;

public class GameDriver
{
    public static void main(String[] args)
    {
        // create random and scanner variables
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        // vars to hold the user's input
        int moveSelect;
        int potionSelect;

        // var to keep count of fight round
        int round = 1;

        // arrays for villain weapon and quote
        String weaponArr[] = {"katana", "axe", "sword", "bow and arrow", "spear", "hammer"};
        String quoteArr[] = {"The inside of this prison will be the last thing you ever see", "Any last word?", "I've always wanted to kill you", "Rookie mistake trying to best me in battle"};

        // ints for the random parameters to be selected
        int randWeapon = rand.nextInt(6);
        int randQuote = rand.nextInt(4);
        int randHealth = rand.nextInt(101);
        int randPotion = rand.nextInt(3);

        // boolean to confirm fight is still happening
        boolean stillFight = true;

        // changes that villain's health until it is greater than 50
        while (randHealth < 50)
        {
            randHealth = rand.nextInt(101);
        }

        // creates villain and hero and heal potions
        Villain villain1 = new Villain("Jorgan the chaotic", weaponArr[randWeapon], quoteArr[randQuote], randHealth);
        Hero hero = new Hero(100);
        Potion plus10 = new Potion("Heal 10", 10, 80);
        Potion plus25 = new Potion("Heal 25", 25, 50);
        Potion plus50 = new Potion("Heal 50", 50, 30);

        // creates an array of potion objects
        Potion optionPotion[] = {plus10, plus25, plus50};

        // creates an array of the user's potions
        Potion userPotions[] = {optionPotion[randPotion]};

        // Intro to story
        System.out.println("Long ago in a time that few remember, there was a mischievous yet charming hero. What shall our wonderful hero's name be?");

        // sets the hero's name to what the user has entered
        hero.setName(scan.nextLine());

        System.out.println("Now THAT is a name for a mighty hero. Now please what weapon do they carry?");

        // sets the hero's weapon to what the user has entered
        hero.setWeapon(scan.nextLine());

        System.out.println("As you wish my liege, " + hero.getName()
                + " was captured by their archnemesis, Jorgan the chaotic, and is now being held in a prison as a captive."
                + " In attempt to escape they tell their trusty \ncellmate friend their plan to sneak out the castle. He responds to your crazy plan by saying \n"
                + "\t\"My friend, good luck in your endeavours, I cannot join you myself for I am weak and frail, but here take this, I hope it helps you on your journey.\""
                + "\nUpon further inspection you find out he has given you a " + userPotions[0].getName()
                + " potion that will heal our hero. After thanking him, " + hero.getName() + " starts their escape attempt."
                + "\nAt the end of the hall at on this level they see that the guard is no other than Jorgan the chaotic himself and they start a fight");

        // loop while the stillFight variable is true
        while (stillFight == true)
        {
            // Print out the basic information at the after both the hero and villain have
            // had a turn (The hero and villain health and what round it is)
            System.out.println("\nRound " + round);

            System.out.println("\nThe Hero has " + hero.getHealth() + " health left");
            System.out.println("The villain, " + villain1.getName() + " has " + villain1.getHealth() + " health left");

            // Using the comparable interface to show who has more health the villain or the hero
            if (hero.compareTo(villain1) == 1)
            {
                System.out.println(
                        "Our hero, " + hero.getName() + " has " + (hero.getHealth() - villain1.getHealth()) + " more health.");
            }//end if statement
            else if (hero.compareTo(villain1) == -1)
            {
                System.out.println(villain1.getName() + " has " + (villain1.getHealth() - hero.getHealth()) + " more health.");
            }//end else-if statement
            else
            {
                System.out.println(hero.getName() + " and " + villain1.getName() + " have the same amount of health.");
            }//end else statement

            // Print out the user's options for the hero's next move
            System.out.println("\nSelect your next move: (please enter a number between 1 and 3)" + "\n1) Attack" + "\n2) Use Potion" + "\n3) Run");

            // set the moveSelect variable to the user's input
            moveSelect = scan.nextInt();

            // validate the answer to make sure it is either a 1, 2, or 3
            while (moveSelect > 3 || moveSelect < 1)
            {
                System.out.println("The number you have entered in invalid. Please re-enter.");
                moveSelect = scan.nextInt();
            }

            // if the user chose 1 have the hero attack the villain
            if (moveSelect == 1)
            {
                hero.attack(villain1);
            } // end inner if statement
            // if the user chose 2 have the hero use a potion
            else if (moveSelect == 2)
            {
                // Print out the potions the hero has available to them and ask the user for an int input
                System.out.println("Which potion would you like to use: (Please enter a number for your selection)");
                for (int i = 0; i < userPotions.length; i++)
                {
                    System.out.println((i + 1) + ") " + userPotions[i].getName());
                } // end inner for loop

                // set potionSelect to the integer the user has entered
                potionSelect = scan.nextInt() - 1;
                // validate that the answer is within the range of available potions
                while (potionSelect >= userPotions.length || potionSelect < 1)
                {
                    System.out.println("The value entered is not an option. Please try again.");
                    potionSelect = scan.nextInt() - 1;
                } // end inner while loop

                // call the potion use brain method
                userPotions[potionSelect].use(hero, userPotions[potionSelect].getOdds(),
                        userPotions[potionSelect].getAbility());
            }// end outer else if statement
            // if the user entered a 3 have the hero attempt to run
            else if (moveSelect == 3)
            {
                // if the run method returns true have the hero make it out free
                if (hero.run() == true)
                {
                    // prints out story about the hero making it out
                    System.out.println("\nWhilst making a break for the door our hero spots the keyring hanging from "
                            + villain1.getName() + "'s belt. Whilst bolting past him, "
                            + "\nthey snags the keys and runs to the large wooden door and quickly unlocks it and runs out into the sunshine. "
                            + hero.getName() + "is free.");

                    // change the stilFight boolean to false so the loop doesn't continue
                    stillFight = false;
                    // call the break method so the loop stops here
                    break;
                }// end inner if statement
                // otherwise the hero doesn't escape by running
                else
                {
                    System.out.println("\nYou couldn't get away from the fight so the intense going battle continues.");
                } // end inner else statement
            } // end outer if else statement

            // checks to see if the villain's health is less than zero
            if (villain1.getHealth() <= 0)
            {
                // change the stilFight boolean to false so the loop doesn't continue
                stillFight = false;

                // prints out a story about the hero escaping
                System.out.println("\nThe villain has been defeated. After going up to his corpse, " + hero.getName()
                        + " takes his keys and opens the giant wooden door at the end of the hall. "
                        + "\nTo their surprise they finds that they is free. The hero then returns triumphantly to their home village and tells the heroic tale (with a few exaggerations) of how"
                        + "\nthey defeated the horrid villain, " + villain1.getName());

                // calls break method so the loop stops here
                break;
            }

            // calls the villain attack brain method basing the hero as a parameter
            villain1.attack(hero);

            // checks to see if the hero's health is less than zero
            if (hero.getHealth() <= 0)
            {
                // change the stilFight boolean to false so the loop doesn't continue
                stillFight = false;

                // prints out a story about the hero dying from their wounds.
                System.out.println("\nUnfortunately " + villain1.getName()
                        + " has bested you in battle. And you have died inside of this prison from your wounds."
                        + "\nThe people outside of your cellmate friend will never know the tale of the hero " + hero.getName()
                        + ".");

                // calls break method so the loop stops
                break;
            }

            // increases round integer by 1
            round++;
        } // end while loop

    }// end main method
}// end class
