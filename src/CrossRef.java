import java.util.List;

public interface CrossRef {

		public void addWord(String palavra, int linha);
		//se a palavra j� est� na lista, acrescenta mais um
		//n�mero de linha; Se a palavra n�o est� na
		//lista, acrescenta a palavra com um
		//primeiro n�mero de linha
		public List getRef(String pal);
		//retorna uma lista ordenada das linhas
		//onde a palavra ocorre

}
