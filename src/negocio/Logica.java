package negocio;

import dao.PokemonDAOImpl;
import entidade.Pokemon;
import visao.Mensagem;

public class Logica {
	public void inicia() {
		Mensagem mensagem = new Mensagem();
		Funcoes funcoes = new Funcoes();
		PokemonDAOImpl dao = new PokemonDAOImpl();
		boolean controle = false;
		int flag = 0;

		int respostaInicio;
		do {
			respostaInicio = mensagem.inicio();
			
			int respostaPergunta = 0;
			int respostaEhPokemon = -1;
			
			if (respostaInicio > -1 && respostaInicio < 2) {
				if(respostaInicio == 0) {
					respostaPergunta = 0;
				} else if (respostaInicio == 1 ) {
					respostaPergunta = 1;
				}
				do {
					Pokemon pokemon = (Pokemon) dao.getPokemon().get(flag);
					Pokemon filho = funcoes.retornaFilho(dao.getPokemon(), (Pokemon) dao.getPokemon().get(flag), respostaPergunta);
					
					if(flag != 0) {
						respostaPergunta = mensagem.pergunta(pokemon);					
					}
					
					if(respostaPergunta == 1 && flag == 0) {
						respostaEhPokemon = mensagem.perguntaSeEh(pokemon, respostaPergunta);						
					}	

					if (filho == null || respostaEhPokemon == 0) {
						if (respostaEhPokemon == 0) {
							mensagem.mostraMensagemVencedor();
							controle = true;
						} else {
							dao.salvar(funcoes.cadastraNovo(funcoes.retornaMaiorId(dao.getPokemon()), pokemon,
									respostaPergunta, flag));
							controle = true;
						}
					} else {
						flag = dao.getPokemon().indexOf(filho);
						respostaPergunta = 0;
					}
				} while (!controle);

				flag = 0;
				controle = false;
			}
		} while (respostaInicio > -1 && respostaInicio < 2);
	}
}
