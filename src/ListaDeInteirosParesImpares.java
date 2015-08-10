import java.util.ArrayList;


public class ListaDeInteirosParesImpares implements ListaParImpar{
	private class Node{
		Node prev, next;
		int numero;
	}
	int qtdNumeros = 0;
	Node headPar = null;
	Node headImpar = null;
	Node primeiroDaLista = null;
	Node ultimoDalista = null;
	
	public ListaDeInteirosParesImpares(){
		qtdNumeros = 0;
		headPar = null;
		headImpar = null;
		primeiroDaLista = null;
		ultimoDalista = null;
	}
	
	public void add(int n) {
		if(n%2==0){
			Node node = new Node();
			if(headPar==null){
				node.prev = null;
				node.next = null;
				node.numero = n;
				headPar = node;
			}
			else{
				Node aux = headPar;
				while(aux.next!=null){
					aux = aux.next;
				}
				node.prev = aux;
				node.next = null;
				node.numero = n;
				aux.next = node;
			}
		}
		else{
			Node node = new Node();
			node = new Node();
			if(headImpar==null){
				node.prev = null;
				node.next = null;
				node.numero = n;
				headImpar = node;
			}
			else{
				Node aux = headImpar;
				while(aux.next!=null){
					aux = aux.next;
				}
				node.prev = aux;
				node.next = null;
				node.numero = n;
				aux.next = node;
			}
		}
		
		if(primeiroDaLista==null){
			Node node = new Node();
			node.next = null;
			node.prev = null;
			node.numero = n;
			primeiroDaLista = node;
			ultimoDalista = node;
		}
		else{
			Node node = new Node();
			node.prev = ultimoDalista;
			node.next = null;
			node.numero = n;
			ultimoDalista.next = node;
			ultimoDalista = node;
		}
		qtdNumeros++;
	}

	public void remove() {
		if(primeiroDaLista!=null){
			int n = -1;
			if(qtdNumeros>1){
				n = primeiroDaLista.numero;
				primeiroDaLista = primeiroDaLista.next;
				primeiroDaLista.prev = null;
				if(n%2==0){
					Node aux = headPar;
					while(aux.numero!=n){
						aux = aux.next;
					}
					if(aux.prev==null){
						if(aux.next==null){
							headPar=null;
						}
						else{
							headPar = headPar.next;
							headPar.prev = null;
						}
					}
					else{
						if(aux.next==null){
							aux.prev.next = null;
						}
						else{
							aux.prev.next = aux.next;
							aux.next = aux.prev;
						}
					}
				}
				else{
					Node aux = headImpar;
					while(aux.numero!=n){
						aux = aux.next;
					}
					if(aux.prev==null){
						if(aux.next==null){
							headImpar=null;
						}
						else{
							headImpar = headImpar.next;
							headImpar.prev = null;
						}
					}
					else{
						if(aux.next==null){
							aux.prev.next = null;
						}
						else{
							aux.prev.next = aux.next;
							aux.next = aux.prev;
						}
					}
				}
			}
			qtdNumeros--;
		}
	}

	public ArrayList<Integer> getAllEven() {
		ArrayList<Integer> pares = new ArrayList<Integer>();
		Node node = headPar;
		while(node!=null){
			pares.add(node.numero);
			node = node.next;
		}
		return pares;
	}

	public ArrayList<Integer> getAllOdd() {
		ArrayList<Integer> pares = new ArrayList<Integer>();
		Node node = headImpar;
		while(node!=null){
			pares.add(node.numero);
			node = node.next;
		}
		return pares;
	}

	public void addFirst(int n) {
		if(primeiroDaLista!=null){
			if(qtdNumeros==0){
				Node node = new Node();
				node.prev = null;
				node.next = null;
				node.numero = n;
			}
			else{
				Node node = new Node();
				node.prev = null;
				node.next = primeiroDaLista;
				primeiroDaLista.prev = node;
				node.numero = n;
				primeiroDaLista = node;
			}
		}
	}

	public int getEven(int pos) {
		if(headPar==null){
			throw new ArrayIndexOutOfBoundsException();
		}
		else{
			int posicao = 0;
			Node aux = headPar;
			while(aux!=null){
				if(posicao==pos){
					return aux.numero;
				}
				aux = aux.next;
				posicao++;
			}
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public int getOdd(int pos) {
		if(headImpar==null){
			throw new ArrayIndexOutOfBoundsException();
		}
		else{
			int posicao = 0;
			Node aux = headImpar;
			while(aux!=null){
				if(posicao==pos){
					return aux.numero;
				}
				aux = aux.next;
				posicao++;
			}
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public String toString() {
		ArrayList<Integer> lista  = new ArrayList<Integer>();
		Node node = primeiroDaLista;
		while(node!=null){
			lista.add(node.numero);
			node = node.next;
		}
		return lista.toString();
	}
	
	public static void main(String[] args) {
		ListaDeInteirosParesImpares listaDeInteirosParesImpares = new ListaDeInteirosParesImpares();
		listaDeInteirosParesImpares.add(2);
		listaDeInteirosParesImpares.add(4);
		listaDeInteirosParesImpares.add(6);
		listaDeInteirosParesImpares.add(1);
		listaDeInteirosParesImpares.add(3);
		listaDeInteirosParesImpares.add(5);
		System.out.println("Lista: "+listaDeInteirosParesImpares);
		System.out.println("Numero impar na posicao 0: "+listaDeInteirosParesImpares.getOdd(0));
		System.out.println("Numero par na posicao 0: "+listaDeInteirosParesImpares.getEven(0));
		listaDeInteirosParesImpares.remove();
		System.out.println("Lista: "+listaDeInteirosParesImpares);
		System.out.println("Numero impar na posicao 0: "+listaDeInteirosParesImpares.getOdd(0));
		System.out.println("Numero par na posicao 0: "+listaDeInteirosParesImpares.getEven(0));
		System.out.println("END");
	}
}
