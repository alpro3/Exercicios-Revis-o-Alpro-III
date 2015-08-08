//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
public class Main <E>{
	public int nOcorrencias(ArrayList<E> l, E el){
		int cont = 0;
		for(E aux: l){
			if(aux.equals(el)){
				cont++;
			}
		}
		return cont;
	}
	
	public boolean hasRepeat(ArrayList<E> l){
		for(int i=0; i<l.size(); i++){
			for(int j=i+1; j<l.size(); j++){
				if(l.get(j).equals(l.get(i))){
					return true;
				}
			}
		}
		return false;
	}
	
	public int nroRepeat(ArrayList<E> l){
		HashSet<E> l1 = new HashSet<E>();
		for(int i=0; i<l.size(); i++){
			if(nOcorrencias(l, l.get(i))>1){
				l1.add(l.get(i));
			}
		}
		return l1.size();
	}
	
	public HashSet<E> listRepeat(ArrayList<E> l){ 
		HashSet <E> unicos = new HashSet<E>();
		HashSet<E> duplicados = new HashSet<E>();
		for(E a :l){
			if(!unicos.add(a)){
				duplicados.add(a);
			}
		}
		//If you want the duplicated numbers:
		//unicos.removeAll();
		return duplicados;
	}


	
	public HashSet<E> union(ArrayList<E> l, ArrayList<E> l1){
		HashSet<E> l2 = new HashSet<E>();
		l2.addAll(l);
		l2.addAll(l1);
		return l2;
	}
	
	public HashSet<E> intersect(ArrayList<E> l, ArrayList<E> l1){
		HashSet<E> l2 = new HashSet<E>();
		l2.addAll(l);
		l2.retainAll(l1);
		return l2;
	}
	
	public static void main(String[] args) {
		Main<String> mainTeste = new Main<String>();
		ArrayList<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		l.add("c");
		l.add("d");
		l.add("e");
		l.add("f");
		l.add("a");
		l.add("b");
		l.add("b");
		l.add("b");
		l.add("a");
		l.add("k");
		System.out.println("Ocorrencias de \'a\' em l: "+mainTeste.nOcorrencias(l, "a"));
		
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("a");
		l1.add("b");
		l1.add("c");
		l1.add("d");
		l1.add("e");
		l1.add("f");
		l1.add("g");
		l1.add("h");
		l1.add("i");
		l1.add("j");
		System.out.println("Tem repetidos em l1? "+mainTeste.hasRepeat(l1));
		l1.add("a");
		System.out.println("Tem repetidos em l1? "+mainTeste.hasRepeat(l1));
		System.out.println("Numero de elementos repetidos em l: "+mainTeste.nroRepeat(l));
		System.out.println("Lista de elementos repetidos em l: "+mainTeste.listRepeat(l));
		System.out.println("Uniao de l e l1: "+mainTeste.union(l, l1));
		System.out.println("Intersecção de l e l1: "+mainTeste.intersect(l, l1));
	}
}
