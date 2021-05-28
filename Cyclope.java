import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cyclope here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cyclope extends Enemy
{
    //Animation
    private int walkSpeed = 20;
    private int walkAnimSpeed = 15;

    private int health;
    private int maxHealth = 100;           //Max health of the enemy

    private int detectPlayerRange = 200;   //Detection range of the enemy    
    private int attackRange = 47;          //Attack range of the enemy
    private int damage = 20;               //Attack damage of the enemy
    
    private double hitCooldown = 1000000000.0;  //Cooldown of 1 bilion nanosec (1sec) between hits

    private double removeCooldown = 2000000000.0; //Enemy will be removed after Cooldown of 2 bilion nanosec (2sec) (after Health <= 0)
    
    private String[] dropItems = new String[] {"redPotion", "arrow1", null, null, null};
    private int[] probability = new int[] {20, 50, 0, 0, 0};

    private Player player;                 //Referenz player

    public Cyclope(Player newPlayer)
    {
        //Set the speed
        changeSpeed(walkSpeed, walkAnimSpeed);

        //Set full health
        health = maxHealth;
        
        setup(health, maxHealth, detectPlayerRange, attackRange, damage, hitCooldown, removeCooldown);

        //SETUP ANIMATIONS
        //Create sprite sheets
        setLayer(0, new GreenfootImage("enemys/cyclope.png"));

        //Build walking animation (primary animation)                
        animations.put("move", Animation.createAnimation(getSpriteSheet(), 9, 4, 9, 64, 64));
        //Build a swing animation for swinging a weapon
        animations.put("attack", Animation.createAnimation(getSpriteSheet(), 8, 4, 6, 192, 192));
        //Build dying animation
        animations.put("die", Animation.createAnimation(getSpriteSheet(), 21, 1, 6, 64, 64));

        //Set primary animation (default animation)
        primaryAnimation = animations.get("move");

        //Start: facing downward
        direction = 3;

        //For the starting image, grab the 0th frame from the current facing dirction
        setImage(primaryAnimation.getOneImage(direction, 0));        
        
        setCollider(28, 35, 0, 6);

        //Set referenz to player
        player = newPlayer;        
    }
   
    public void act() 
    {
        updateHealthBar();
        
        updatePlayerPosition(player);        
        
        moveToPlayer();

        hit(player);

        checkCollision();

        storePosition();

        checkRemove(player, dropItems, probability);

        //Call superclass act() to perform animations and movement
        super.act();
    }
}
