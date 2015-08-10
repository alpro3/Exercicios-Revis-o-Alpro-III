import java.util.List;

public interface CrossRef {

		public void addWord(String palavra, int linha);
		//se a palavra já está na lista, acrescenta mais um
		//número de linha; Se a palavra não está na
		//lista, acrescenta a palavra com um
		//primeiro número de linha
		public List getRef(String pal);
		//retorna uma lista ordenada das linhas
		//onde a palavra ocorre

}
