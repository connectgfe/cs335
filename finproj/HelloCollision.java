
import com.jme3.app.SimpleApplication;
import com.jme3.asset.plugins.ZipLocator;

import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.bullet.collision.shapes.BoxCollisionShape;


import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.asset.TextureKey;
import com.jme3.font.BitmapText;

import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.input.MouseInput;

import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

import com.jme3.material.Material;
import com.jme3.math.Vector2f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.scene.shape.Sphere.TextureMode;

import com.jme3.texture.Texture;
import com.jme3.texture.Texture.WrapMode;



/**
 * Example 9 - How to make walls and floors solid.
 * This collision code uses Physics and a custom Action Listener.
 * @author normen, with edits by Zathras
 */
public class HelloCollision extends SimpleApplication
        implements ActionListener {

  private Spatial sceneModel;
  private BulletAppState bulletAppState;
  private RigidBodyControl landscape;
  private CharacterControl player;
  
//  private BoxCollisionShape floor;

  private Vector3f walkDirection = new Vector3f();
  private boolean left = false, right = false, up = false, down = false;

  //Temporary vectors used on each frame.
  //They here to avoid instanciating new vectors on each frame
  private Vector3f camDir = new Vector3f();
  private Vector3f camLeft = new Vector3f();

  /** Prepare Materials */
  Material wall_mat;
  Material stone_mat;
  Material floor_mat;

  /** Prepare geometries and physical nodes for bricks and cannon balls. */
  private RigidBodyControl    brick_phy;
  private static final Box    box;

  private static final Box    box2;
  private RigidBodyControl    box2_phy;


  private RigidBodyControl    ball_phy;
  private static final Sphere sphere;
  private RigidBodyControl    floor_phy;
  private static final Box    floor;


  /** dimensions used for bricks and wall */
  private static final float brickLength = 0.48f;
  private static final float brickWidth  = 0.24f;
  private static final float brickHeight = 0.12f;

  static {
    /** Initialize the cannon ball geometry */
    sphere = new Sphere(15, 15, 0.4f, true, false);
    sphere.setTextureMode(TextureMode.Projected);
    /** Initialize the brick geometry */
    box = new Box(brickLength, brickHeight, brickWidth);
    box.scaleTextureCoordinates(new Vector2f(1f, .5f));

    box2 = new Box(2,2,2);
    box2.scaleTextureCoordinates(new Vector2f(1f, .5f));


    /** Initialize the floor geometry */
    floor = new Box(30f, .1f, 30f);
    floor.scaleTextureCoordinates(new Vector2f(1, 1.5f));



  }




  public static void main(String[] args) {
    HelloCollision app = new HelloCollision();
    app.start();
  }

  public void simpleInitApp() {
    /** Set up Physics */

   bulletAppState = new BulletAppState();
   stateManager.attach(bulletAppState);
 //  bulletAppState.setDebugEnabled(true);

    // We re-use the flyby camera for rotation, while positioning is handled by physics
    viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
    flyCam.setMoveSpeed(150);
    setUpKeys();
    setUpLight();

    // We load the scene from the zip file and adjust its size.
    assetManager.registerLocator("world_05.zip", ZipLocator.class);
    sceneModel = assetManager.loadModel("world_01.scene");
    sceneModel.setLocalScale(10f);

    // We set up collision detection for the scene by creating a
    // compound collision shape and a static RigidBodyControl with mass zero.
    CollisionShape sceneShape =
            CollisionShapeFactory.createMeshShape(sceneModel);
    landscape = new RigidBodyControl(sceneShape, 0);
    sceneModel.addControl(landscape);

/*
    CollisionShape sceneShape =
            CollisionShapeFactory.createMeshShape(floor);
    landscape = new RigidBodyControl(sceneShape, 0);
    sceneModel.addControl(landscape);
*/


    // We set up collision detection for the player by creating
    // a capsule collision shape and a CharacterControl.
    // The CharacterControl offers extra settings for
    // size, stepheight, jumping, falling, and gravity.
    // We also put the player in its starting position.
    CapsuleCollisionShape capsuleShape = new CapsuleCollisionShape(1.5f, 6f, 1);
    player = new CharacterControl(capsuleShape, 0.05f);
    player.setJumpSpeed(20);
    player.setFallSpeed(30);
    player.setGravity(130);
    player.setPhysicsLocation(new Vector3f(0,0 ,-5));

    // We attach the scene and the player to the rootnode and the physics space,
    // to make them appear in the game world.


    rootNode.attachChild(sceneModel);
    bulletAppState.getPhysicsSpace().add(landscape);



    bulletAppState.getPhysicsSpace().add(player);

   /** Add InputManager action: Left click triggers shooting. */
    inputManager.addMapping("shoot",
                   new KeyTrigger(KeyInput.KEY_H));

//            new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
    inputManager.addListener(actionListener, "shoot");
    /** Initialize the scene, materials, and physics space */


    initMaterials();
//    initWall(0,0);
//    initWall(10,5);
     makeBox(10,30);

//    initFloor();
//    initCrossHairs();

  }



  /** Initialize the materials used in this scene. */
  public void initMaterials() {

    wall_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    TextureKey key = new TextureKey("Textures/Terrain/BrickWall/BrickWall.jpg");
    key.setGenerateMips(true);
    Texture tex = assetManager.loadTexture(key);
    wall_mat.setTexture("ColorMap", tex);


    stone_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    TextureKey key2 = new TextureKey("Textures/Terrain/Rock/Rock.PNG");

    key2.setGenerateMips(true);
    Texture tex2 = assetManager.loadTexture(key2);
    stone_mat.setTexture("ColorMap", tex2);


    floor_mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
    TextureKey key3 = new TextureKey("Textures/Terrain/splat/grass.jpg");
    key3.setGenerateMips(true);
    Texture tex3 = assetManager.loadTexture(key3);
    tex3.setWrap(WrapMode.Repeat);

    floor_mat.setTexture("ColorMap", tex3);

  }



  /** Make a solid floor and add it to the scene. */
  public void initFloor() {

    Geometry floor_geo = new Geometry("Floor", floor);
    floor_geo.setMaterial(floor_mat);
    floor_geo.setLocalTranslation(0, -0.1f, 0);

    // attach floor to app
    this.rootNode.attachChild(floor_geo);
    /* Make the floor physical with mass 0.0f! */
    floor_phy = new RigidBodyControl(0.0f);
    floor_geo.addControl(floor_phy);
    bulletAppState.getPhysicsSpace().add(floor_phy);
  }




  private void setUpLight() {
    // We add light so we see the scene
    AmbientLight al = new AmbientLight();
    al.setColor(ColorRGBA.White.mult(1.3f));
    rootNode.addLight(al);

    DirectionalLight dl = new DirectionalLight();
    dl.setColor(ColorRGBA.White);
    dl.setDirection(new Vector3f(2.8f, -2.8f, -2.8f).normalizeLocal());
    rootNode.addLight(dl);
  }

  /** We over-write some navigational key mappings here, so we can
   * add physics-controlled walking and jumping: */
  private void setUpKeys() {
    inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
    inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
    inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
    inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
    inputManager.addMapping("Jump", new KeyTrigger(KeyInput.KEY_SPACE));
    inputManager.addListener(this, "Left");
    inputManager.addListener(this, "Right");
    inputManager.addListener(this, "Up");
    inputManager.addListener(this, "Down");
    inputManager.addListener(this, "Jump");
  }

  /** These are our custom actions triggered by key presses.
   * We do not walk yet, we just keep track of the direction the user pressed. */
  public void onAction(String binding, boolean isPressed, float tpf) {
    if (binding.equals("Left")) {
      left = isPressed;
    } else if (binding.equals("Right")) {
      right= isPressed;
    } else if (binding.equals("Up")) {
      up = isPressed;
    } else if (binding.equals("Down")) {
      down = isPressed;
    } else if (binding.equals("Jump")) {
      if (isPressed) { player.jump(); }
    }
  }

  /**
   * This is the main event loop--walking happens here.
   * We check in which direction the player is walking by interpreting
   * the camera direction forward (camDir) and to the side (camLeft).
   * The setWalkDirection() command is what lets a physics-controlled player walk.
   * We also make sure here that the camera moves with player.
   */
  @Override
    public void simpleUpdate(float tpf) {

        
        camDir.set(cam.getDirection()).multLocal(0.6f);
        camLeft.set(cam.getLeft()).multLocal(0.4f);
        walkDirection.set(0, 0, 0);
        if (left) {
            walkDirection.addLocal(camLeft);
        }
        if (right) {
            walkDirection.addLocal(camLeft.negate());
        }
        if (up) {
            walkDirection.addLocal(camDir);
        }
        if (down) {
            walkDirection.addLocal(camDir.negate());
        }
        player.setWalkDirection(walkDirection);
        cam.setLocation(player.getPhysicsLocation());

System.out.println("  "+player.getPhysicsLocation()+" "+cam.getLocation()+" "+walkDirection+" "+camDir+" "+cam.getDirection());

    }


  /**
   * Every time the shoot action is triggered, a new cannon ball is produced.
   * The ball is set up to fly from the camera position in the camera direction.
   */


  private ActionListener actionListener = new ActionListener() {
    public void onAction(String name, boolean keyPressed, float tpf) {
      if (name.equals("shoot") && !keyPressed) {
        makeCannonBall();
      }
    }
  };

  public void makeCannonBall() {
	    /** Create a cannon ball geometry and attach to scene graph. */
	    Geometry ball_geo = new Geometry("cannon ball", sphere);
	    ball_geo.setMaterial(stone_mat);
	    rootNode.attachChild(ball_geo);
	    /** Position the cannon ball  */
        Vector3f loc = new Vector3f(player.getPhysicsLocation().getX(),player.getPhysicsLocation().getY()+4,player.getPhysicsLocation().getZ());
 
	    ball_geo.setLocalTranslation(loc);
           
//            ball_geo.setLocalTranslation(player.getLocation());
	
	    /** Make the ball physcial with a mass > 0.0f */
	    ball_phy = new RigidBodyControl(1f);
	    /** Add physical ball to physics space. */
	    ball_geo.addControl(ball_phy);
	    bulletAppState.getPhysicsSpace().add(ball_phy);
	    /** Accelerate the physcial ball to shoot it. */
//            if (cam.getDirection().getX()>0 && cam.getDirection().getZ()>0){
	    ball_phy.setLinearVelocity(cam.getDirection().mult(50));

/*
            }else{
            ball_phy.setLinearVelocity(cam.getDirection().mult(-25));
            }
*/
System.out.println("NO: "+player.getPhysicsLocation()+" "+cam.getLocation()+" "+walkDirection+" "+camDir+" "+cam.getDirection()+" "+cam.getDirection().mult(25));


	  }


  public void makeBox(int x, int z) {
	    /** Create a cannon ball geometry and attach to scene graph. */
	    Geometry box2_geo = new Geometry("box", box2);
	    box2_geo.setMaterial(stone_mat);
	    rootNode.attachChild(box2_geo);
	    /** Position the cannon ball  */
 
	    box2_geo.setLocalTranslation(x,0,z);
           
//            ball_geo.setLocalTranslation(player.getLocation());
	
	    /** Make the ball physcial with a mass > 0.0f */
	    box2_phy = new RigidBodyControl(.001f);
	    /** Add physical ball to physics space. */
	    box2_geo.addControl(box2_phy);
	    bulletAppState.getPhysicsSpace().add(box2_phy);
	    /** Accelerate the physcial ball to shoot it. */
	  }





  /** A plus sign used as crosshairs to help the player with aiming.*/
  protected void initCrossHairs() {
    guiNode.detachAllChildren();
    guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
    BitmapText ch = new BitmapText(guiFont, false);
    ch.setSize(guiFont.getCharSet().getRenderedSize() * 2);
    ch.setText("+");        // fake crosshairs :)

    ch.setLocalTranslation( // center
      settings.getWidth() / 2 - guiFont.getCharSet().getRenderedSize() / 3 * 2,
      settings.getHeight() / 2 + ch.getLineHeight() / 2, 0);
   
     guiNode.attachChild(ch);
  }

  /** This loop builds a wall out of individual bricks. */
  public void initWall(int x, int z) {
    float startpt = brickLength / 4;
    float height = 0;
    for (int j = 0; j < 15; j++) {
      for (int i = 0; i < 6; i++) {
        Vector3f vt =
         new Vector3f((i+x) * brickLength * 2 + startpt, (brickHeight + height), (0+z));
        makeBrick(vt);
      }
      startpt = -startpt;
      height += 2 * brickHeight;
    }
  }

  /** This method creates one individual physical brick. */
  public void makeBrick(Vector3f loc) {
    /** Create a brick geometry and attach to scene graph. */
    Geometry brick_geo = new Geometry("brick", box);
    brick_geo.setMaterial(wall_mat);
    rootNode.attachChild(brick_geo);
    /** Position the brick geometry  */
    brick_geo.setLocalTranslation(loc);
    /** Make brick physical with a mass > 0.0f. */
    brick_phy = new RigidBodyControl(.0010f);
    /** Add physical brick to physics space. */
    brick_geo.addControl(brick_phy);
    bulletAppState.getPhysicsSpace().add(brick_phy);
  }



}
