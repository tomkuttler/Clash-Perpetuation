import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Cyclopes are giant one-eyed creatures.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cyclope extends Enemy
{
    //----- Animation -----     
    private int animationSpeed = 15;              //Number of animation frames per second
    
    //----- Movement -----
    private int walkSpeed = 20;                   //Move 20 pixel per second
    
    private int minDistance = 47;                 //Minimum distance between the enemy and the player
    
    //----- Health -----
    private int maxHealth = 100;                  //Max health of the enemy
    
    //----- Attack -----
    private String enemyType = "melee";           //"melee" (if the enemy has a sword or dagger,...) or "ranged" (if the enemy has a bow) 
    
    private int bowRange = 0;                     //The range of the bow if this enemy has a bow
    private int bowSpeed = 0;                     //The speed of the bow if this enemy has a bow
    
    private int detectPlayerRange = 200;          //Player detection range of this enemy    
    private int attackRange = 47;                 //Attack range of this enemy 
    
    private int damage = 20;                      //Attack damage of this enemy   
    
    //----- Cooldowns -----
    private double hitCooldown = 1000000000.0;    //Cooldown of 1 bilion nanosec (1sec) between hits

    private double removeCooldown = 2000000000.0; //Enemy will be removed after Cooldown of 2 bilion nanosec (2sec) (after Health <= 0)
    
    //----- Drop item -----
    private String[] dropItems = new String[] {"redPotion", "arrow1", null, null, null}; //Array that contins the items that will be dropped if this enemy dies
    private int[] dropAmount = new int[] {5, 3, 0, 0, 0};                                //Array that contins the amount of items that will be dropped if this enemy dies
    private int[] probability = new int[] {50, 20, 0, 0, 0};                             //Array that contins the probability of dropping that item

    //----- Reference -----
    private Player player;                        //Reference to the player

    /**
     * Cyclope Constructor: Sets the speed, creates the spriteSheet of the character, creates the animations and sets variables.
     * 
     * @param 'newPlayer': Reference to the player
     * @param 'startDirection': The direction in which the character will face at the start (0 = Right, 1 = Left, 2 = Up, 3 = Down)
     */ 
    public Cyclope(Player newPlayer, int startDirection)
    {
        //Set the speed
        changeSpeed(walkSpeed, animationSpeed);
        
        //Set the variables in superclass
        setup(maxHealth, enemyType, detectPlayerRange, minDistance, attackRange, bowRange, bowSpeed, damage, hitCooldown, removeCooldown);

        //Create spriteSheet
        setLayer(0, new GreenfootImage("enemys/cyclope.png"));

        //----- BUILD ANIMATIONS -----
        //Build walking animation (primary animation)                
        animations.put("move", Animation.createAnimation(getSpriteSheet(), 9, 4, 9, 64, 64));
        //Build a swing animation for attacking
        animations.put("attack", Animation.createAnimation(getSpriteSheet(), 8, 4, 6, 192, 192));
        //Build dying animation
        animations.put("die", Animation.createAnimation(getSpriteSheet(), 21, 1, 6, 64, 64));

        //Set primary animation (default animation)
        primaryAnimation = animations.get("move");

        //Set the start direction
        direction = startDirection;

        //For the starting image, grab the 0th frame from the current facing dirction
        setImage(primaryAnimation.getOneImage(direction, 0));        
        
        //Spawn new Collider
        setCollider(28, 35, 0, 6);

        //Set Reference
        player = newPlayer;        
    }
   
    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'act' method of the AnimatedCharacter superclass to perform animations and movement.
     */
    public void act() 
    {
        updateHealthBar();
        
        updatePlayerPosition(player);        
        
        moveToPlayer();
        
        turnToPlayer();

        hit(player);

        checkCollision();

        storePosition();

        checkRemove(player, dropItems, dropAmount, probability);

        //Call superclass act() to perform animations and movement
        super.act();
    }
}
