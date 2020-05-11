import java.util.Random;

public class Felszerelesek {

	private byte weaponMinDamage;
	private byte weaponMaxDamage;
	private String weaponName;
	private byte durability;
	
	
	public Felszerelesek(String name, byte weaponMinDamage, byte weaponMaxDamage) {
		this.weaponName = name;
		this.weaponMinDamage = weaponMinDamage;
		this.weaponMaxDamage = weaponMaxDamage;
		this.durability = 10;
		if(weaponMaxDamage < weaponMinDamage) {
			byte csere = weaponMaxDamage;
			weaponMaxDamage = weaponMinDamage;
			weaponMinDamage = csere;
		}
		
	}
	public byte getWeaponMinDamage() {
		return weaponMinDamage;
	}

	public byte getWeaponMaxDamage() {
		return weaponMaxDamage;
	}

	public String getWeaponName() {
		return this.weaponName;
	}

	public byte getDurability() {
		return durability;
	}

	public int useWeapon() {
		Random r = new Random();
		this.durability--;
		return r.nextInt(this.weaponMaxDamage - this.weaponMinDamage) + this.weaponMinDamage;
	}
	
	public void fegyverstat () {
		System.out.println("\n -------------------------------");
		System.out.println("A fegyver neve: " + this.getWeaponName());
		System.out.println("Támadás: " + this.getWeaponMinDamage() + "-" + this.getWeaponMaxDamage());
		System.out.println("A fegyver strapbírósága: " + this.getDurability());
		System.out.println("---------------------------------\n");
	}

}
