/**
 * The `game` class represents a character in a game with various attributes and functionalities.
 */
public class game {
    String playername;
    double damage;
    double hp;
    double shield;
    double speed;
    int level;
    double baseHp;
    double basedamage;
    double shieldbase;
    double speedbase;
    double swordweight;
    double shieldweight;
    String jobname;

    /**
     * Constructor to initialize the game character with base attributes.
     *
     * @param xHp     Initial base HP of the character.
     * @param yDamage Initial base damage of the character.
     * @param zShield Initial base shield of the character.
     * @param hSpeed  Initial base speed of the character.
     *
     * Preconditions: None.
     * Postconditions: Character attributes are initialized with the provided values.
     * Side Effects: None.
     */

    public game(double xHp,double yDamage,double zShield,double hSpeed){
        baseHp = xHp;
        basedamage = yDamage;
        shieldbase = zShield;
        speedbase = hSpeed;
        setHp();
        setSpeed();
        setDamage();
        setShield();
    }
    /**
     * Display the current status of the character.
     *
     * Preconditions: None.
     * Postconditions: None.
     * Side Effects: Outputs character information to the console.
     */
    public void display() {
        System.out.println("------------------------");
        System.out.println("Class : "+ jobname); //เรียกจาก object fromjob
        System.out.println("Player name : " + playername);
        System.out.println("Level : " + level);
        System.out.println("HP : " + hp);
        System.out.println("Speed : " + speed);
        System.out.println("Damage : " + damage);
        System.out.println("Shield : " + shield);
        System.out.println("------------------------");
    }
//    โค้ดตรงส่วนนี้มีไว้แสดงสเตตัสของตัวละคร
//    public void generatePlayer(String playername) {
//
//        this.level = 120;
//        this.playername = playername;
//        setHp();
//        setSpeed();
//        setDamage();
//        setShield();
//
//    }
    //สร้างตัวละครและชื่อและตั้งค่าสเตตัสเริ่มต้น


//    public void base(){
//        damage = 2.0;
//        shield = 10.0;
//        speed = 100;
//        setHp();
//        setMana();
//        setSpeed();
//    }

    /**
     * Level up the character, updating its attributes accordingly.
     *
     * Preconditions: None.
     * Postconditions: Character level is increased, and attributes (HP, speed, damage, shield) are updated.
     * Side Effects: None.
     */
    public void levelup(){
        level++;
        setHp();
        setSpeed();
        setDamage();
        setShield();
    }
    //เวลาเลเวลอัพจะมีการอัพเดทสเตตัสต่างๆที่กำหนดไว้ให้มค่าเพิ่มขึ้น
    /**
     * Use a sword and update character stats based on whether the sword is used or not.
     *
     * @param x True if using a sword, false otherwise.
     * @return The value of x.
     *
     * Preconditions: x is a boolean value.
     * Postconditions: If x is true, the character's speed and swordweight are updated. If x is false, the character's speed is adjusted.
     * Side Effects: None.
     */
    public boolean UseSword(boolean x){
        if(x){
            swordweight=basedamage*(0.1+0.04*level);
            setSpeed();

        }
        else if (!x){
            this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        }
        return  x;
    }

    /**
     * Use a shield and update character stats based on whether the shield is used or not.
     *
     * @param x True if using a shield, false otherwise.
     * @return The value of x.
     *
     * Preconditions: x is a boolean value.
     * Postconditions: If x is true, the character's speed, shieldweight, and shield are updated. If x is false, the character's speed is adjusted.
     * Side Effects: None.
     */
    public boolean UseShield(boolean x){
        if(x){
            shieldweight=shieldbase*(0.1+0.08*level);
            shield += 50;
            setSpeed();
        }
        else if (!x){
            this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        }
        return  x;
    }

    /**
     * Set the character's HP based on the current level.
     *
     * Preconditions: None.
     * Postconditions: Character's HP is updated based on the formula: baseHp + (10 * level).
     * Side Effects: None.
     */
    public void setHp() {
        this.hp = baseHp+(10*level);
    }

    /**
     * Set the character's speed based on the current level and equipment weights.
     *
     * Preconditions: None.
     * Postconditions: Character's speed is updated based on the formula: (speedbase * (0.1 + (0.04 * level))) - (shieldweight + swordweight).
     * Side Effects: None.
     */

    public void setSpeed(){
        this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
    }

    /**
     * Set the character's damage based on the current level.
     *
     * Preconditions: None.
     * Postconditions: Character's damage is updated based on the formula: basedamage * (1 + (0.1 * level)).
     * Side Effects: None.
     */

    public void setDamage(){
        this.damage = basedamage*(1+(0.1*level));
    }

    /**
     * Set the character's shield based on the current level.
     *
     * Preconditions: None.
     * Postconditions: Character's shield is updated based on the formula: shieldbase * (1 + (0.05 * level)).
     * Side Effects: None.
     */

    public void setShield(){
        this.shield = shieldbase*(1+(0.05*level));
    }

    /**
     * Equip or unequip Hermes Boots to the character.
     *
     * @param boots True if equipping Hermes Boots, false if unequipping.
     * @return The value of boots.
     *
     * Preconditions: boots is a boolean value.
     * Postconditions: If boots is true, speedbase is increased by 500. If boots is false, speedbase is unchanged.
     * Side Effects: None.
     */

    public boolean Hermes_Boots(boolean boots){
        if (boots) {
            this.speedbase = speedbase + 500;
            setSpeed();
        }
        else if(!boots) {
            this.speedbase = speedbase;
        }
        return  boots;
    }

    /**
     * Equip or unequip Attack Ring to the character.
     *
     * @param ring True if equipping Attack Ring, false if unequipping.
     * @return The value of ring.
     *
     * Preconditions: ring is a boolean value.
     * Postconditions: If ring is true, basedamage is increased by 100. If ring is false, basedamage is unchanged.
     * Side Effects: None.
     */

    public boolean Atk_Ring(boolean ring){
        if (ring) {
            this.basedamage = basedamage + 100;
            setDamage();
        }
        else if(!ring) {
            this.basedamage = basedamage;
        }
        return  ring;
    }

    /**
     * Perform an attack on an opponent, considering shield and health.
     *
     * @param opponent The opponent character.
     *
     * Preconditions: opponent is not null.
     * Postconditions: The opponent's shield and health may be reduced based on the attack. Output information is displayed on the console.
     * Side Effects: None.
     */
    public void attack(game opponent) {

        double DmgAttacker = 0;

        if(damage >= opponent.shield ){
            DmgAttacker = damage - opponent.shield;
            if(opponent.shield > 0){
                opponent.shield = DmgAttacker - opponent.shield;
            }else if(opponent.shield < 0){
                opponent.shield = 0;
            }

            opponent.hp = opponent.hp - DmgAttacker ;
        }
        else if(damage < opponent.shield){
            DmgAttacker = opponent.shield - damage;
            if(opponent.shield > 0){
                opponent.shield = opponent.shield - DmgAttacker;
            }else if(opponent.shield < 0){
                opponent.shield = 0;
            }

        }

        if(opponent.shield < 0){
            opponent.shield = 0;
        }

        if(opponent.hp > 0) {
            System.out.println("------------------------");
            System.out.println(this.playername + " attacks " + opponent.playername + " for " + DmgAttacker + " damage.");
            System.out.println(opponent.playername + "'s Current Shield: " + opponent.shield);
            System.out.println(opponent.playername + "'s Current HP: " + opponent.hp);
            System.out.println("------------------------");
        }
        else if(opponent.hp < 0) {
            opponent.hp = 0;
            System.out.println("==============");
            System.out.println(opponent.playername + "'s Current HP: " + opponent.hp);
            System.out.println(this.playername + " kill " + opponent.playername );
            System.out.println("==============");
        }
    }
}
