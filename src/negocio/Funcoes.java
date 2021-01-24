package negocio;

import java.util.Iterator;
import java.util.List;

import entidade.Pokemon;
import visao.Mensagem;

public class Funcoes {
	
	public Pokemon retornaFilho(List<Pokemon> pokemons, Pokemon p, int respostaPergunta) {
		Iterator<Pokemon> var5 = pokemons.iterator();

		Pokemon pokemon;
		do {
			if (!var5.hasNext()) {
				return null;
			}

			pokemon = (Pokemon) var5.next();
		} while (pokemon.getIdPai() != p.getId() || pokemon.getFilhoDaResposta() != respostaPergunta);

		return pokemon;
	}

	public int retornaMaiorId(List<Pokemon> animais) {
		return animais.size() + 1;
	}

	public Pokemon cadastraNovo(int id, Pokemon pokemon, int respostaPergunta, int flag) {
		Mensagem mensagem = new Mensagem();
		Pokemon novopokemon = new Pokemon();
		
		String pkm = mensagem.entrada(pokemon, "Qual Pokemon você pensou?");
		
		if(pkm != null && !pkm.equals("")) {
			novopokemon.setId(id);
			novopokemon.setRespostaSim(pkm);
			novopokemon.setidPai(pokemon.getId());
			novopokemon.setFilhoDaResposta(respostaPergunta);
			if (respostaPergunta == 0) {
				novopokemon.setRespostaNao(pokemon.getRespostaSim());
				novopokemon.setCaracteristica(mensagem.entrada(pokemon, "O que o(a) " + novopokemon.getRespostaSim()
						+ " tem diferente do(a) " + pokemon.getRespostaSim() + "."));
			} else {
				novopokemon.setRespostaNao(pokemon.getRespostaNao());
				novopokemon.setCaracteristica(mensagem.entrada(pokemon, "O que o(a) " + novopokemon.getRespostaSim()
						+ " tem diferente do(a) " + pokemon.getRespostaNao() + "."));
			}
			
			return novopokemon;
		}

		return null;
	}

}
