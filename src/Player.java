import java.util.Random;
import java.util.Scanner;

public class Player {

	
		private byte health;
		private String name;
		private byte cast;
		private byte armor;
		private byte damage;
	
		public Player(String name, byte cast) {
			this.health = 100;
			this.name = name;
			if(cast > 3 || cast < 0) {
				this.cast = 0;
			} else {
				this.cast = cast;
			}
			if(this.cast == 0) {
				this.armor = 120;
				this.damage = 40;
			}else if(this.cast == 1) {
				this.armor = 80;
				this.damage = 20;
			}
			else if(this.cast == 2) {
				this.armor = 50;
				this.damage = 25;
			}
			else if(this.cast == 3) {
				this.armor = 100;
				this.damage = 15;
			}
					
		}
			
		public byte getDamage() {
			return damage;
		}
		
		public byte getArmor() {
			return armor;
		}
		
		public byte getHealth() {
			return health;
		}
		
		public void setHealth(byte health) {
			if(health > 0 && health < 100) {
				this.health = health;
			} else {
				System.out.println("Nem megfelel� az �rt�k!");
			}
				
		}

		public String getName() {
			return name;
		}


		public byte getCast() {
			return cast;
		}
		
		public String getCastName() {
			String[] casts = {"Warrior", "Hunter", "Mage", "Shaman"};
			return casts[this.cast];
		}
		
		/* ha true akkor t�l �lte a karakter�nk a t�mad�st, ha false akkor belehalt! */
		public boolean getDamaged(byte attack) {
			int damage = attack * 2 - armor;
			if(damage < 0) {
				damage = 0;
			}
			this.health -= damage;
			if(this.health <= 0) {
				return false;
			} else {
				return true;
			}
			
		}
		
		public void getSpecs() {
			System.out.println("\n -------------------------------");
			System.out.println("A karaktered neve: " + this.name);
			System.out.println("A karaktered cast-ja: " + this.getCastName());
			System.out.println("A karaktered p�nc�lja: " + this.armor);
			System.out.println("A karaktered t�mad�sa: " + this.damage);
			System.out.println("A karaktered jelenlegi �lete: " + this.health);
			System.out.println("---------------------------------\n");
		}
		
		public boolean harc(Felszerelesek f, int szornyHp) {
			Random r = new Random();
			int randSz =  r.nextInt(3) + 1;
			Scanner sc = new Scanner(System.in);
			System.out.println("Adj meg egy sz�mot! Amit, ha eltal�lsz r�gr�n meghal az ellenfeled!");
			int szamBeker = sc.nextInt();
			if(randSz == szamBeker) {
				System.out.println("Egyb�l meg�lteda sz�rnyet!");
				return true;
			} else {
				int utes = f.useWeapon();
				if(utes >= szornyHp) {
					System.out.println("Sajnos nem tal�ltad el a megfelel� sz�mot, �gy harcolnotok kell!");
					System.out.println("Ekkora �t�st m�rt�l a sz�rnyre: " + utes + " Ezzel legy�zted a sz�rnyet!");
					return true;
				}
			} 
			System.out.println("Sajnos vesztett�l!");
			return false;		
		}
}


