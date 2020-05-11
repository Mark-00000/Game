import java.util.Scanner;

public class jatekMenet {

	public static void main(String[] args) {
		
		
		System.out.println("Add meg a karaktered nevét!");
		Scanner sc = new Scanner(System.in);
		String karakterNev = sc.next();
		System.out.println("Válassz castot! \n Warrior - 0 \n Hunter - 1 \n Mage - 2 \n Shaman - 3");
		byte valasztas = sc.nextByte();
		
	
		Player p = new Player(karakterNev, valasztas);
		p.getSpecs();
		
		String[] helyek = {"erdõ", "hegy", "domb", "völgy"};
		int randomHely1 = (int) (Math.random() * helyek.length);
		int randomhely2 = (int) (Math.random() * helyek.length);
		while (randomHely1 == randomhely2) {
			randomHely1 = (int) (Math.random() * helyek.length);
		}
		
		
		System.out.println("Merre felé szeretnél haladni?  \n (0) erre: " + helyek[randomHely1] + " \n vagy \n (1) erre: " + helyek[randomhely2]);
		int ut = sc.nextInt();
		if(ut == 0) {
			System.out.println("Tovább haladsz erre a(z): " + helyek[randomHely1]);
		} else if(ut == 1) {
			System.out.println("Tovább haladsz erre  a(z): " + helyek[randomhely2]);
		}
		
		String[] szorny = {"pók", "unikornis", "orias kigyó", "medvedisznóember"};
		int randomSzorny = (int) (Math.random() * szorny.length);
		System.out.println("\n");
		System.out.println("Az utadban áll egy " + szorny[randomSzorny] + "\n ha megszeretnél vele küzdeni (0) \n ha pedig kerülõ útra mennél (1)");
		int dontes = sc.nextInt();
		if(dontes == 0) {
			System.out.println("készûlj fel a harcra és válassz ellene egy megfelelõ fegyvert");
			System.out.println("Fegyverek: Axe(0), Sword(1), Staff(2), Dagger(3)");
			byte fegyverValasztas = sc.nextByte();
			boolean megfeleloFegyver = false;
			String fegyverNev = "";
			if(fegyverValasztas == p.getCast()) {
				megfeleloFegyver = true;	
			}
			if(fegyverValasztas == 0) {
				fegyverNev = "Axe";
			} else if(fegyverValasztas == 1) {
				fegyverNev = "Sword";
			} else if(fegyverValasztas == 2) {
				fegyverNev = "Staff";
			} else if(fegyverValasztas == 3) {
				fegyverNev = "Dagger";
			}
			Felszerelesek fegyver;
			if(true == megfeleloFegyver) {
				fegyver = new Felszerelesek(fegyverNev, (byte) 80, (byte) 100);
				System.out.println("A megfelelõ fegyvert választottad a kastodhoz!");
			} else {
				fegyver = new Felszerelesek(fegyverNev, (byte) 40, (byte) 75);
				System.out.println("Rossz a fegyvered! Szeretnél újabb fegyvert választani?");
				System.out.println("Igen(0) \n0Nem(1)");
				int ujraValasztas = sc.nextInt();
				if(ujraValasztas == 0) {
					System.out.println("Fegyverek: Axe(0), Sword(1), Staff(2), Dagger(3)");
					fegyverValasztas = sc.nextByte();
				
					if(fegyverValasztas == 0) {
						fegyverNev = "Axe";
					} else if(fegyverValasztas == 1) {
						fegyverNev = "Sword";
					} else if(fegyverValasztas == 2) {
						fegyverNev = "Staff";
					} else if(fegyverValasztas == 3) {
						fegyverNev = "Dagger";
					}
					if(fegyverValasztas == p.getCast()) {
						fegyver = new Felszerelesek(fegyverNev, (byte) 80, (byte) 100);
						System.out.println("A megfelelõ fegyvert választottad a kastodhoz!");
					} else {
						fegyver = new Felszerelesek(fegyverNev, (byte) 40, (byte) 85);
						System.out.println("Rossz a fegyvered!");
					}	
				}
			}
			p.harc(fegyver, 82);
			fegyver.fegyverstat();
		}
	}	
}

