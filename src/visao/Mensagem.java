package visao;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import entidade.Pokemon;

public class Mensagem {

	public int inicio() {
		
		Object[] options = { "Aquatico", "Fogo", "Sair" };
		try {
			return JOptionPane.showOptionDialog(null, "Pense em um Pokemon Aquatico ou Fogo", "Jogo dos Pokemons", JOptionPane.DEFAULT_OPTION, 
					JOptionPane.WARNING_MESSAGE, new ImageIcon(ImageIO.read(getClass().getResource("/imagem/pokemon.png"))) , options, options[0]);
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0 ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0 ;
		}
	}

	public int perguntaSeEh(Pokemon p, int simOuNao) {
		return simOuNao == 0
				? JOptionPane.showConfirmDialog((Component) null,
						"O Pokemon que você pensou é " + p.getRespostaSim() + "?", "Informe", 0)
				: JOptionPane.showConfirmDialog((Component) null,
						"O Pokemon que você pensou é " + p.getRespostaNao() + "?", "Informe", 0);
	}
	
	public int pergunta(Pokemon p) {
		return JOptionPane.showConfirmDialog((Component)null, "O pokemon que você pensou " + p.getCaracteristica() + "?", "Informe", 0);
	}

	public String entrada(Pokemon p, String mensagem) {
		String valor;
		do {
			valor = JOptionPane.showInputDialog((Component) null, mensagem);
			if (valor != null && valor.trim().equals("")) {
				this.mostraMensagem("Resposta Nao pode ser Vazia!");
			}
		} while (valor != null && valor.trim().equals(""));

		return valor;
	}

	public void mostraMensagem(String mensagem) {
		JOptionPane.showMessageDialog((Component) null, mensagem);
	}
	
	public void mostraMensagemVencedor() {
//		try {
			JOptionPane.showMessageDialog((Component) null,null,"GANHEI !!!!!",1,new ImageIcon("src/imagem/brent.gif"));//ImageIO.read(getClass().getResource("/imagem/brent.gif"))));
//		} catch (HeadlessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
