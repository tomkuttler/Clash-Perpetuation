import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The devil is the boss of the game. If you defeat him, you will win the game.
 * 
 * @author Tom Kuttler, Robert Cockshott 
 * @version 1.0.0
 */
public class Devil extends Enemy
{
    //----- Animation -----     
    private static final int animationSpeed = 10;              //Number of animation frames per second

    //----- Movement -----
    private static final int walkSpeed = 25;                   //Move 25 pixel per second

    private static final int minDistance = 47;                 //Minimum distance between the enemy and the player

    //----- Health -----
    public static final int maxHealth = 500;                   //Max health of the enemy

    private static final int barYOffset = 60;                  //The offset of the enemy health bar relative to the enemy in y direction (in pixel)
    
    //----- Attack -----
    private static final String enemyType = "melee";           //"melee" (if the enemy has a sword or dagger,...) or "ranged" (if the enemy has a bow) 

    private static final int bowRange = 0;                     //The range of the bow if this enemy has a bow
    private static final int bowSpeed = 0;                     //The speed of the bow if this enemy has a bow

    private static final int detectPlayerRange = 300;          //Player detection range of this enemy    
    private static final int attackRange = 47;                 //Attack range of this enemy 

    private static final int damage = 30;                      //Attack damage of this enemy   

    //----- Cooldowns -----
    private static final double hitCooldown = 1000000000.0;    //Cooldown of 1 bilion nanosec (1sec) between hits

    private static final double removeCooldown = 2000000000.0; //Enemy will be removed after Cooldown of 2 bilion nanosec (2sec) (after Health <= 0)

    //----- Drop item -----
    private static final String[] dropItems = new String[] {null, null, null, null, null};            //Array that contins the items that will be dropped if this enemy dies
    private static final int[] dropAmount = new int[] {0, 0, 0, 0, 0};                                //Array that contins the amount of items that will be dropped if this enemy dies
    private static final int[] probability = new int[] {0, 0, 0, 0, 0};                               //Array that contins the probability of dropping that item

    //----- Reference -----
    private Player player;                        //Reference to the player
    private EnemyHealthBar bar;                   //Reference to the HealthBar of the enemy

    //----- Layer images -----    
    private static final GreenfootImage devil = new GreenfootImage("enemys/devil.png");
    
    /**
     * Devil Constructor: Sets the speed, creates the spriteSheet of the character, creates the animations and sets variables.
     * 
     * @param 'newPlayer': Reference to the player
     * @param 'newBar': Reference to the health bar of the enemy
     * @param 'startDirection': The direction in which the character will face at the start (0 = Right, 1 = Left, 2 = Up, 3 = Down)
     */ 
    public Devil(Player newPlayer, EnemyHealthBar newBar, int startDirection)
    {
        //Set the speed
        changeSpeed(walkSpeed, animationSpeed);

        //Create spriteSheet
        setLayer(0, devil);

        //----- BUILD ANIMATIONS -----
        //Build walking animation (primary animation)                
        animations.put("move", Animation.createAnimation(getSpriteSheet(), 1, 4, 4, 128, 128));
        //Build a swing animation for attacking
        animations.put("attack", Animation.createAnimation(getSpriteSheet(), 5, 4, 4, 128, 128));
        //Build dying animation
        animations.put("die", Animation.createAnimation(getSpriteSheet(), 9, 1, 7, 128, 128));

        //Set primary animation (default animation)
        primaryAnimation = animations.get("move");

        //Set the start direction
        direction = startDirection;

        //For the starting image, grab the 0th frame from the current facing dirction
        setImage(primaryAnimation.getOneImage(direction, 0));        

        //Spawn new Collider
        setCollider(35, 65, 0, -10);

        //Set References
        player = newPlayer;
        bar = newBar;
        
        //Hide bar at start
        bar.setImage((GreenfootImage)null);
        
        //Set the variables in superclass
        setup(maxHealth, barYOffset, enemyType, detectPlayerRange, minDistance, attackRange, bowRange, bowSpeed, damage, hitCooldown, removeCooldown, bar, player);
    }

    /**
     * Method 'act': Is called every tick or whenever the 'Act' or 'Run' button gets pressed in the environment.
     * It calls the 'act' method of the AnimatedCharacter superclass to perform animations and movement.
     */
    public void act() 
    {
        updateHealthBar();

        updatePlayerPosition();        

        moveToPlayer();

        turnToPlayer();

        hit();

        checkCollision();

        storePosition();

        checkRemove(dropItems, dropAmount, probability);

        //Call superclass act() to perform animations and movement
        super.act();
    }
}
