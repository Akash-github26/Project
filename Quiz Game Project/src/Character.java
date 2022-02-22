
public class Character {
	public  String name;
    public String character;
    public int health;

    public Character(String name, String character, int health) {
        this.name = name;
        this.character = character;
        this.health = health;
        
    }

   

	public void healthIncrease(){
        this.health += 30;
        if(this.health >=100){
            this.health = 100;
        }
        System.out.println("Right Answer. Health is increased by 30"+
        " Current Health is "+ this.health);
    }
	 public void damageByGun(){
	        this.health -=20;
	        if(this.health <=0){
	            this.health = 0;
	        }
	        System.out.println("OOPS! Wrong Answer. Got hit by Gun . Health is reduced by 20"+
	        " Current Health is "+ this.health);
	        if(this.health == 0){
	            
	        }
	    }
   public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

	


}
