import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
/*		//Esercizio Modulo=ALGORITMO DI COMPRESSIONE
		
		int range = 10;
		System.out.println(23%10); 
		//ottengo 3 che è il resto della divisione 23/10
*/		
		
		Set<Impiegato> impiegati = new HashSet<Impiegato>();
		
		Impiegato i1 = new Impiegato(27, "Andrea", "Marcelli");
		Impiegato i2 = new Impiegato(45, "Fulvio", "Corno");
		Impiegato i3 = new Impiegato(45, "Giovanni", "Squillero");
		
		impiegati.add(i1);
		impiegati.add(i2);
		impiegati.add(i3);
		
		//Creo iteratore che mi restituisca tutti gli elementi della collezione
		//NON HO CERTEZZA CHE ELEMENTI MI VENGA RESTITUITI NELL'ORDINE DI INSERIMENTO
		Iterator<Impiegato> it = impiegati.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		List<String> arrayList = new ArrayList<String>();
		List<String> linkedList = new LinkedList<String>();
	
		HashSet<String> set = new HashSet<String>();
		
		//genero 10 000 parole casuali e prendo i tempi
		Long t1 = System.nanoTime();
		for(int i =0; i<10000; i++) 
			arrayList.add("tag_"+i);
		Long t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		
		t1 = System.nanoTime();
		for(int i =0; i<10000; i++) 
			linkedList.add("tag_"+i);
		t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		
		
		t1 = System.nanoTime();
		for(int i =0; i<10000; i++) 
			set.add("tag_"+i);
		t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		
		//inserimento nell'hashSet è più lento perché ogni volta che inserisco un elemento
		//richiama la funzione hashCode quindi i tempi aumentano
		
		//tempi di rimossione elementi
		/*System.out.println("Tempi di rimozione elementi ");
		t1 = System.nanoTime();
		for(int i =0; i<100000; i++) 
			arrayList.remove("tag_"+i);
		t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		
		t1 = System.nanoTime();
		for(int i =0; i<100000; i++) 
			linkedList.remove("tag_"+i);
		t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		
		t1 = System.nanoTime();
		for(int i =0; i<100000; i++) 
			set.remove("tag_"+i);
		t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		*/
		//rimozione più lenta in arrayList, linkedLIst è stata molto più veloce
		//perché guarda il primo valore e lo rimuove, poi passa al secondo che deve eanche rimuovere ecc,
		//non deve cercare i valori li guarda uno dopo l'altro
		
		System.out.println("Tempi di rimozione elementi in ordine opposto");
		t1 = System.nanoTime();
		for(int i = 9999; i>=0; i--) 
			arrayList.remove("tag_"+i);
		t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		
		t1 = System.nanoTime();
		for(int i = 9999; i>=0; i--) 
			linkedList.remove("tag_"+i);
		t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		
		t1 = System.nanoTime();
		for(int i = 9999; i>=0; i--) 
			set.remove("tag_"+i);
		t2= System.nanoTime();
		System.out.println((t2-t1)/1e9);
		
		//SET è due ordini di grandezza più veloce di arrayList e LinkedList
		
		//AVREI LA STESSA COSA CON contains() invece di remove()
		//perché prima di restituire/rimuovere l'oggetto deve trovarlo quindi sono simili
		//TROVARE L'OGGETTO RALLENTA/VELOCIZZA UN ALGORITMO
		//Con ArrayList e LInkedList non so da dove partire a cercare quindi parto dall'inizio della Collezione e itero.
		//Con gli HashSet sfrutto la funzione di Hash che mi dice da dove iniziare a cercare.
	}

}
