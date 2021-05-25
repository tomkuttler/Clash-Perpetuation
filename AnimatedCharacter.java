import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;

/**
 * The AnimatedCharacter superclass is designed to manage animations for 2d sprites
 * It implements TIME-BASED frame changing and moving to create both smoothness and preciseness. 
 *  
 * Primary Animation: Usually movement - this is the base animation.
 * Terminal Animations: Animations that run, then end, and return to the primary animation.
 */

public abstract class AnimatedCharacter extends Actor
{
    public final static int MAX_LAYERS = 12;

    //----- Protected variables -----
    protected HashMap<String, Animation> animations;

    protected Animation primaryAnimation; //The primary animation is generally movement - this is the base animation
    protected Animation currentAnimation; //The animation currenty playing

    protected int direction; //Direction: 0 = Right, 1 = Left, 2 = Up, 3 = Down

    //----- Private variables -----
    private double framesPerSecond;   // animation speed
    private double secondsPerFrame;   // calculated fraction of second per frame
    private double maxFrameLength;    // Used to avoid "jumping" if lag or GF pause.
    //What fraction of a second is max dead time?

    private int frame;          // current frame counter
    private double xx, yy;      // internal, double representation of coordinates
    private int dirX, dirY;     // variables used to control direction
    private int prevX, prevY;   // previous rounded X and Y values
    private boolean idle;       // used to specify idle frame
    private boolean stopAtEnd;  // is this a TERMINAL animation?

    private double moveSpeed;   // how many pixels per SECOND

    //Current set of images
    //This is one dimension of an Animation, and will be cycled through in the animation code.
    private GreenfootImage[] currentImages; 
    private GreenfootImage[] spriteSheetLayers;
    private GreenfootImage spriteSheet;

    protected Collider myCollider;
    private boolean collisionEnabled = false; 

    //for time-keeping to keep animation going at consistent speed
    private long lastFrame;         // Keep track of when the last animation was updated
    private long current;           // Keep track of time between frames for movement
    private long elapsed;           // how long a frame was

    public AnimatedCharacter()
    {
        animations = new HashMap<String, Animation>();

        //Start values for private variables
        frame = 0;
        dirX = 0;
        dirY = 0;
        idle = false;
        stopAtEnd = false;

        //VALUES FOR ANIMATION 
        maxFrameLength = 0.10;

        // In case program is too laggy, this determines the max time per frame.
        // In other words, if a frame takes longer than maxFrameLength to render,
        // or the program is paused for more time, the animation will place the
        // object at the point at the distance that would have been covered in
        // maxFrameLength time.
        maxFrameLength = 1/30.0; // aboutn 1/60th of a second, 60 FPS  

        spriteSheetLayers = new GreenfootImage[MAX_LAYERS];

        // Set the initial timestamp for animation timer
        lastFrame = System.nanoTime();
    }

    public void addedToWorld(World w)
    {
        //When I get added to world, set my internal double variables 
        xx = getX();
        yy = getY();
        prevX = getX();
        prevY = getY();

        currentAnimation = primaryAnimation;

        setCurrentImages (currentAnimation.getDirectionalImages()[direction]);

        if(collisionEnabled)
        {
            positionCollider();
        }
    } 

    public void setCollider(int width, int height, int xOffset, int yOffset)
    {
        myCollider = new Collider(width, height, xOffset, yOffset);
        collisionEnabled = true;
    }

    public void positionCollider() 
    {
        if(myCollider.getWorld() != getWorld())
        {
            getWorld().addObject(myCollider, 0, 0);
        } 

        myCollider.setLocation(getX() + myCollider.getXOffset(), getY() + myCollider.getYOffset());
    }

    public void disableCollision() 
    {
        if (myCollider != null && myCollider.getWorld() != null)
        {
            getWorld().removeObject(myCollider);
        }

        collisionEnabled = false;
    }    

    public GreenfootImage getSpriteSheet() 
    {
        return spriteSheet;
    }

    public GreenfootImage getStartingImage() 
    {
        return primaryAnimation.getOneImage(direction, 0);
    }

    /**
     * Set layers for your image.
     * 
     * The 0th layer is on the bottom and will be drawn first. The highest 
     * layer is on top and will be drawn last. By default there are 12 layers,
     * but you can add more by changing the MAX_LAYERS constant.
     * 
     * The supplied graphics should all be Spritesheets, and you should consider
     * which layers should be drawn on top of which for the best visual effect.
     * 
     * @param layer The layer number you want to place this spritesheet at
     * @param image The sprite sheet that you want to place at this layer
     */   
    public void setLayer(int layer, GreenfootImage image)
    {
        spriteSheetLayers[layer] = image;
        spriteSheet = Animation.updateSpriteSheet(spriteSheetLayers);
    }

    /**
     * Custom refresh - specify your own spriteSheet, and refresh this animation to reflect it.
     * Remember to apply trim() after, if required,  as this does not trim the images.
     * 
     * @param   anim    The Animation object that you wish to refresh.
     * @param   GreenfootImage  The image object to use to update this Animation
     */
    public void refresh(Animation anim, GreenfootImage spriteSheet)
    {
        anim.refresh(spriteSheet);
        setCurrentImages (currentAnimation.getDirectionalImages()[direction]);
    }

    /**
     * Standard refresh - uses the spritesheet built into this AnimatedCharacter. This should
     * be called after making changes to the SpriteSheet, so that they will change in the 
     * active Animation. Remember to apply trim() after, if required,  as this does not trim the images.
     * 
     * @param   anim    The Animation object that you wish to refresh. This will use
     *                  the default / built-in spriteSheet, which you may have just
     *                  changed using setLayer, or otherwise.
     */
    public void refresh(Animation anim)
    {
        anim.refresh(this.spriteSheet);
        setCurrentImages (currentAnimation.getDirectionalImages()[direction]);
    }

    public void setPrimaryAnimation(String animation)
    {
        setPrimaryAnimation (animations.get(animation));
    }

    public void setPrimaryAnimation(Animation animation)
    {
        primaryAnimation = animation;
    }

    /**
     * Set the movement speed (in pixels per second) and the animation rate
     * (in frames per second)
     */
    protected void changeSpeed(int moveSpeed, int framesPerSecond)
    {
        //Only run code if something has changed
        if (this.moveSpeed != moveSpeed || this.framesPerSecond != framesPerSecond){
            this.framesPerSecond = framesPerSecond;
            this.moveSpeed = moveSpeed;

            // Figure out how many seconds per frame
            secondsPerFrame = 1.0 / this.framesPerSecond;
            // Reset animation timer
            lastFrame = System.nanoTime();
        }
    }

    /**
     * <p>Make this AnimatedCharacter move in a specified direction.</p>
     * 
     * <p><b>Instructions:</b></p>
     * <ol>
     * <li>Subclasses can just set direction once and the animated character
     * will keep moving until stopped or direction changes.</li>
     * <li>Subclasses can call this repeatedly - if direction doesn't change,
     * these method calls will be ignored</li>
     * <li> This method does not actually perform movement - only set direction
     * variables. This is intended - the super.act() call in the subclass will run
     * last in the subclass' act() method and perform the actual movement.</li>
     *
     * <li>Intended to receive a 1 or -1 for for ONE of the parameters, and a 
     * zero (0) for the other. This method does not allow diagonal movement.</li>
     * </ol>
     * @param dirX  The direction for x movement. Should be -1, 0 or 1.
     * @param dirY  The direction for y movement. Should be -1, 0 or 1. 
     */
    protected void moveInDirection(int dirX, int dirY)
    {
        // If there has been a change in direction
        if (this.dirX != dirX || this.dirY != dirY){
            if (dirX == 0 && dirY == 0){
                idle = true; 
                lastFrame = System.nanoTime(); // reset animation timer to start fresh
                frame = 0; // 0 is the idle frame
                setImage (currentAnimation.getDirectionalImages()[direction][frame]);
            } 
            else 
            {
                idle = false; 
                //frame = 1; // set to first frame if dir has changed
                // set the facing direction if direction has changed
                if (dirX == 1){
                    direction = 0;
                } else if (dirX == -1){
                    direction = 1;
                } else if (dirY == 1){
                    direction = 3;
                } else if (dirY == -1){
                    direction = 2;
                }
            }
            setCurrentImages (currentAnimation.getDirectionalImages()[direction]);
            // set these variables so that I can check for changes next time
            this.dirX = dirX;
            this.dirY = dirY;
        } 
    }

    // This method if you want to set an idle facing direction
    public void stopMoving(int direction)
    {
        this.direction = direction;
        idle = true;
        stopMoving();
    }

    // This method if you want to just stop and use current facing direction.
    public void stopMoving()
    {
        dirX = 0;
        dirY = 0;

        if (!stopAtEnd)
        {
            lastFrame = System.nanoTime();
        }
    }

    /**
     * Override the default setLocation method because the backing
     * variables xx and yy need to be updated, otherwise they will
     * immediately move the player back every time it tries to move.
     */
    @Override
    public void setLocation (int x, int y)
    {
        xx = (int)x;
        yy = (int)y;   
        // once variable have been updated, call the normal method:
        super.setLocation ((int)Math.round(xx), (int)Math.round(yy));
    }

    /**
     * Runs an animation that will come to an end when it's finished doing it's thing.
     * 
     * @param animationName The name of the Animation (it must have been added to animations already)
     * @param stopMoving    Should this AnimatedCharacter stop moving BEFORE performing this operation?
     * @param direction     What direction is this Animation currently facing?
     */  
    public void runTerminalAnimation (String animationName, boolean stopMoving, int direction)
    {
        stopAtEnd = true;
        idle = false;
        frame = 0;

        currentAnimation = animations.get(animationName);
        this.direction = direction;

        if (currentAnimation.isDirectional())
        {
            setCurrentImages (currentAnimation.getDirectionalImages()[direction]);
        } 
        else 
        {          
            setCurrentImages (currentAnimation.getNonDirectionalImages());
        }

        if (stopMoving){
            stopMoving (direction);
        }
    }

    private void setCurrentImages (GreenfootImage[] images)
    {
        currentImages = new GreenfootImage[images.length];
        
        for (int i = 0; i < images.length; i++){
            currentImages[i] = images[i];
        }
    }

    //Act method - manages animation. Must be called by subclass at the end of own act() method.
    public void act() 
    {
        long lastAct = current;
        // determine how much time has passed since the last act
        current = System.nanoTime();
        // Find elapsed time since last frame switch in milliseconds (ms) for animation
        elapsed = (long)((current - lastFrame) / 1000000.0); 
        // Find elapsed time since last act, for movement
        long deltaTime = (current - lastAct) / 1000000;

        //----- Animation -----

        if ((dirX == 0 && dirY == 0) && !stopAtEnd) //If not moving, and not playing a terminal animation, switch to idle
        { 
            idle = true;
            lastFrame = current;
            
            //Reset animation timer 
            frame = 0;

            setImage (currentImages[frame]);
        } 
        else 
        {            
            if (elapsed > secondsPerFrame * 1000 || idle) //Check if ready to show next frame
            {
                lastFrame = current;
                frame++;

                idle = false;
            }

            if (frame > currentImages.length - 1) //If this is the last frame
            { 
                if(stopAtEnd) //If this is a terminal animation
                { 
                    //If a terminal animation is finished, return to primary
                    currentAnimation = primaryAnimation;
                    stopAtEnd = false;
                    setCurrentImages (currentAnimation.getDirectionalImages()[direction]);

                    frame = 1;
                } 
                else //If this is no terminal animation, go back to frame 1
                { 
                    frame = 1; //0th frame is the idle frame only, so count 1..last, not 0..last
                }
            }
            
            //Set the correct image
            setImage (currentImages[frame]);
        }

        //----- Movement -----

        //Calculate delta time - how many seconds have passed since the last act (I.e. 30 fps, dT = 0.0333)
        double dT = (current-lastAct) / 1000000000.0;

        if (dT > maxFrameLength)
        {
            dT = maxFrameLength;
        }

        //Calculate exact new location
        xx += ((double)(dirX) * moveSpeed) * dT;
        yy += ((double)(dirY) * moveSpeed) * dT;

        //Update my location
        super.setLocation((int)Math.round(xx), (int)Math.round(yy));
        
        //Set the position of my collider to my new location
        if(collisionEnabled)
        {
            positionCollider();
        }
    }    
}

/**
 *  Animation Class
 *  
 *  This is a 1d or 2d array of images. 
 *  
 *  For Animations that are directional, this class will store the animation as a 2d array. 
 *  For animations with one direction, this class will store the animation as 1d array. 
 *  
 */
class Animation 
{
    private GreenfootImage[][] directionalImages;
    private GreenfootImage[] nonDirectionalImages;

    private int startRow;
    private int numRows;
    private int width;
    private int height;
    private int numFrames;

    private boolean directional;

    private int directions;

    /**
     * Constructor for directional animations
     * 
     * @param images    2d array of GreenfootImage with 4 directions and at least one image per direction
     * @param terminal  true if this animation is not intended to repeat
     */ 
    public Animation(GreenfootImage[][] images, int startRow, int numRows, int numFrames, int width, int height)
    {
        this.startRow = startRow;
        this.numRows = numRows;
        this.width = width;
        this.height = height;
        this.directional = true;
        this.numFrames = numFrames;
        directionalImages = images;

        directions = images.length;
    }

    /**
     * Constructor for non directional animations 
     * 
     * @param images    1d array of GreenfootImage with 1 direction and at least one image
     * @param terminal  true if this animation is not intended to repeat
     */ 
    public Animation(GreenfootImage[] images, int startRow, int numRows, int numFrames, int width, int height)
    {
        this.startRow = startRow;
        this.numRows = numRows;
        this.width = width;
        this.height = height;
        this.directional = false;
        this.numFrames = numFrames;
        nonDirectionalImages = images;

        directions = images.length;
    }

    public void refresh (GreenfootImage spriteSheet) 
    {
        if (directional)
        {
            GreenfootImage[][] temp = processImages(spriteSheet, startRow, numRows, numFrames, width, height);
            setImages (temp);
        } 
        else 
        {
            GreenfootImage[] temp = processImages(spriteSheet, startRow, numRows, numFrames, width, height)[0];
            setImages (temp);
        }
    }

    /**
     * Change the images in an existing directional Animation. 
     * 
     * @param   images  2d Array of GreenfootImages
     */
    public void setImages(GreenfootImage[][] images)
    {
        directionalImages = images;
    }

    /**
     * Change the images in an existing non directional Animation
     * 
     * @param   images  1d Array of GreenfootImages
     */
    public void setImages(GreenfootImage[] images)
    {
        nonDirectionalImages = images;
    }    

    public int getDirectionCount() 
    {
        return directions;
    }

    public boolean isDirectional()
    {
        return this.directional;
    }

    public GreenfootImage getOneImage(int direction, int frame)
    {
        return directionalImages[direction][frame];
    }

    public GreenfootImage[][] getDirectionalImages()
    {
        return directionalImages;
    }

    public GreenfootImage[] getNonDirectionalImages()
    {
        return nonDirectionalImages;
    }

    /** Create a new animation.
     *  
     *  @param spriteSheet  the Spritesheet to pull frames from
     *  @param startRow     the row on which the desired sprites are located
     *  @param numRows      the number of rows to import, which will correspond with the number of directions (1 or 4 directions)
     *  @param numFrames    the number of frames in the animation
     *  @param width        the width of each frame
     *  @param height       the height of each frame
     *  
     *  @return Animation   Animation object that is either 1 direction or 4 direction.
     *  
     */
    protected static Animation createAnimation(GreenfootImage spriteSheet, int startRow, int numRows, int numFrames, int width, int height)
    {
        GreenfootImage[][] images = processImages(spriteSheet, startRow, numRows, numFrames, width, height);

        if (numRows == 1) //If this only has one dimension, create a 1 dimension Animation
        { 
            GreenfootImage[] img1d = new GreenfootImage[images[0].length];

            for (int i = 0; i < img1d.length; i++)
            {
                img1d[i] = images[0][i];
            }

            Animation animation = new Animation(img1d, startRow, numRows, numFrames, width, height);
            return animation;
        } 
        else //If this is directional
        { 
            Animation animation = new Animation (images, startRow, numRows, numFrames, width, height);
            return animation;
        }
    }

    private static GreenfootImage[][] processImages(GreenfootImage spriteSheet, int startRow, int numRows, int numFrames, int width, int height)
    {
        GreenfootImage[][] images = new GreenfootImage[numRows][numFrames];
        
        for (int row = 0; row < numRows; row++)
        {
            int dir = -1;

            if (numRows == 1)
            { 
                dir = 0;
            } 
            else 
            { 
                switch (row) 
                { 
                    //translate between Direction values and the order in which the frames are organized in sprite sheets
                    case 0: dir = 2;  break;
                    case 1: dir = 1;  break;
                    case 2: dir = 3;  break;
                    case 3: dir = 0;  break; 
                }
            }

            if (dir == -1) 
            {
                return null;
            }

            for (int frame = 0; frame < numFrames; frame++)
            {
                images[dir][frame] = new GreenfootImage (getSlice(spriteSheet, frame * width, (startRow + row - 1) * height, width, height));
            }
        }
        return images;
    }

    /**
     * Grabs a part of a sprite sheet and returns it as a new GreenfootImage. (The sprite sheet must be larger than the resulting image.)
     * 
     * @param spriteSheet   the larger spritesheet to pull images from
     * @param xPos  the x position (of the left) of the desired spot to draw from
     * @param yPos  the y position (of the top) of the desired spot to draw from
     * @param frameWidth     the horizontal tile size
     * @param frameHeight    the vertical tile size
     * @return GreenfootImage   the resulting image
     */
    private static GreenfootImage getSlice(GreenfootImage spriteSheet, int xPos, int yPos, int frameWidth, int frameHeight)
    {
        if (frameWidth > spriteSheet.getWidth() || frameHeight > spriteSheet.getHeight())
        {
            return null;
        }
        
        GreenfootImage small = new GreenfootImage (frameWidth, frameHeight);
        small.drawImage (spriteSheet, -xPos, -yPos);
        return small;
    }

    //Called by AnimatedCharacter when Layers change
    public static GreenfootImage updateSpriteSheet(GreenfootImage[] layers)
    {
        GreenfootImage spriteSheet = new GreenfootImage (layers[0].getWidth(), layers[0].getHeight());

        for (int i = 0; i < layers.length; i++)
        {
            if (layers[i] != null)
            {
                spriteSheet.drawImage(layers[i], 0, 0);
            }
        }

        return spriteSheet;
    }
}
