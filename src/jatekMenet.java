import java.util.Scanner;

public class jatekMenet {

	public static void main(String[] args) {
		
		
		System.out.println("Add meg a karaktered nev�t!");
		Scanner sc = new Scanner(System.in);
		String karakterNev = sc.next();
		System.out.println("V�lassz castot! \n Warrior - 0 \n Hunter - 1 \n Mage - 2 \n Shaman - 3");
		byte valasztas = sc.nextByte();
		
	
		Player p = new Player(karakterNev, valasztas);
		p.getSpecs();
		
		String[] helyek = {"erd�", "hegy", "domb", "v�lgy"};
		int randomHely1 = (int) (Math.random() * helyek.length);
		int randomhely2 = (int) (Math.random() * helyek.length);
		while (randomHely1 == randomhely2) {
			randomHely1 = (int) (Math.random() * helyek.length);
		}
		
		
		System.out.println("Merre fel� szeretn�l haladni?  \n (0) erre: " + helyek[randomHely1] + " \n vagy \n (1) erre: " + helyek[randomhely2]);
		int ut = sc.nextInt();
		if(ut == 0) {
			System.out.println("Tov�bb haladsz erre a(z): " + helyek[randomHely1]);
		} else if(ut == 1) {
			System.out.println("Tov�bb haladsz erre  a(z): " + helyek[randomhely2]);
		}
		
		String[] szorny = {"p�k", "unikornis", "orias kigy�", "medvediszn�ember"};
		int randomSzorny = (int) (Math.random() * szorny.length);
		System.out.println("\n");
		System.out.println("Az utadban �ll egy " + szorny[randomSzorny] + "\n ha megszeretn�l vele k�zdeni (0) \n ha pedig ker�l� �tra menn�l (1)");
		int dontes = sc.nextInt();
		if(dontes == 0) {
			System.out.println("k�sz�lj fel a harcra �s v�lassz ellene egy megfelel� fegyvert");
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
				System.out.println("A megfelel� fegyvert v�lasztottad a kastodhoz!");
			} else {
				fegyver = new Felszerelesek(fegyverNev, (byte) 40, (byte) 75);
				System.out.println("Rossz a fegyvered! Szeretn�l �jabb fegyvert v�lasztani?");
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
						System.out.println("A megfelel� fegyvert v�lasztottad a kastodhoz!");
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

