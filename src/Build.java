/**
 * The `Build` class represents a specific character build in a game, inheriting from the `game` class.
 */
public class Build extends game {

    /**
     * Constructor to create a character with a specific job and player name.
     *
     * @param jobname    The job name for the character build (e.g., "Tank", "Assassin", "Ranger").
     * @param playername The player name for the character.
     *
     * Preconditions: jobname and playername are non-null.
     * Postconditions: A new character with the specified job and player name is created, and job-specific attributes are set.
     * Side Effects: The character's attributes are initialized based on the specified job.
     */
    public Build(String jobname,String playername){
        super(100,10,10,100);
        this.level = 0;
        this.jobname = jobname;
        this.playername = playername;
        switch (jobname) {
            case "Tank" -> setTank();
            case "Assassin" -> setAssassin();
            case "Ranger" -> setRanger();
        }
    }

    /**
     * Set attributes for the Tank job.
     *
     * Preconditions: None.
     * Postconditions: Tank-specific attributes are set for the character.
     * Side Effects: The character's baseHp, hp, basedamage, damage, speedbase, speed, shieldbase, and shield are updated.
     */

    public void setTank(){
        this.baseHp = 500;
        this.hp = baseHp+(10*level);
        this.basedamage = 20;
        this.damage = basedamage*(1+(0.1*level));
        this.speedbase = 300;
        this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        this.shieldbase = 50;
        this.shield = shieldbase*(1+(0.05*level));
    }

    /**
     * Set attributes for the Assassin job.
     *
     * Preconditions: None.
     * Postconditions: Assassin-specific attributes are set for the character.
     * Side Effects: The character's baseHp, hp, basedamage, damage, speedbase, speed, shieldbase, and shield are updated.
     */

    public void setAssassin(){
        this.baseHp = 350;
        this.hp = baseHp+(10*level);
        this.basedamage = 35;
        this.damage = basedamage*(1+(0.1*level));
        this.speedbase = 500;
        this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        this.shieldbase = 30;
        this.shield = shieldbase*(1+(0.05*level));
    }

    /**
     * Set attributes for the Ranger job.
     *
     * Preconditions: None.
     * Postconditions: Ranger-specific attributes are set for the character.
     * Side Effects: The character's baseHp, hp, basedamage, damage, speedbase, speed, shieldbase, and shield are updated.
     */

    public void setRanger(){
        this.baseHp = 250;
        this.hp = baseHp+(10*level);
        this.basedamage = 50;
        this.damage = basedamage*(1+(0.1*level));
        this.speedbase = 450;
        this.speed = (speedbase*(0.1+(0.04*level)))-(shieldweight+swordweight);
        this.shieldbase = 20;
        this.shield = shieldbase*(1+(0.05*level));
    }
}

