import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListaDePalavra implements CrossRef{
	private class Node{
		public Node(){
			lista = new ArrayList<Integer>();
		}
		Node next;
		String chave;
		ArrayList<Integer> lista;
	}
	Node head;
	public ListaDePalavra() {
		head = null;
	}
	
	public void addWord(String palavra, int linha) {
		Node node = null;
		Node aux = head;
		while(aux!=null){
			if(aux.chave.equals(palavra)){
				node = aux;
				break;
			}
			aux = aux.next;
		}
		if(node!=null){
			ArrayList<Integer> lista = node.lista;
			if(lista.contains(linha)==false){
				lista.add(linha);
				node.lista = lista;
			}
		}
		else{
			aux = head;
			node = new Node();
			node.chave = palavra;
			ArrayList<Integer> l = node.lista;
			l.add(linha);
			node.lista = l;
			if(aux==null){
				head = node;
			}
			else{
				while(aux.next!=null){
					aux = aux.next;
				}
				aux.next = node;
			}
		}
	}

	public List<Integer> getRef(String pal) {
		Node aux = head;
		while(aux!=null){
			if(aux.chave.equals(pal)){
				return aux.lista;
			}
			aux = aux.next;
		}
		return null;
	}
	
	public void leArquivo(String caminho){
		try{
			File file = new File(caminho);
			FileReader fileReader = new FileReader(file);
			BufferedReader buff = new BufferedReader(fileReader);
			int cont = 0;
			while(buff.ready()){
				String linha = buff.readLine();
				String palavras[] = linha.split(" ");
				for (int i = 0; i < palavras.length; i++) {
					addWord(palavras[i], cont);
				}
				cont++;
			}
		}catch(Exception e){
			System.out.println(e.getStackTrace().toString());
		}
	}
	
	public static void main(String[] args) {
		ListaDePalavra listaDePalavra = new ListaDePalavra();
		listaDePalavra.leArquivo("C:/users/eduardo/desktop/texto.txt");
		System.out.println(listaDePalavra.getRef("ELEFANTE"));
	}
}