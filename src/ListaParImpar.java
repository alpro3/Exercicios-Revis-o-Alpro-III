import java.util.ArrayList;

public interface ListaParImpar {
		public void add(int n); //adiciona n no final da lista
		public void remove(); //remove o primeiro elemento da lista
		public ArrayList<Integer> getAllEven(); //retorna todos os pares
		public ArrayList<Integer> getAllOdd(); //retorna todos os �mpares
		public void addFirst(int n); //inserir no in�cio da lista
		public int getEven(int pos); // retorna n-�simo elemento par
		public int getOdd(int pos); // retorna n-�simo elemento impar
}
