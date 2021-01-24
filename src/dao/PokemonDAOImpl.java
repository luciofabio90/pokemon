package dao;

import java.util.ArrayList;
import java.util.List;

import entidade.Pokemon;

public class PokemonDAOImpl implements PokemonDAO {
	

	private List<Pokemon> pokemons = new ArrayList<Pokemon>();

	public PokemonDAOImpl() {
		Pokemon p1 = new Pokemon();
		p1.setId(1);
		p1.setCaracteristica("é Aquatico");
		p1.setRespostaSim("Squirtle");
		p1.setRespostaNao("Charmander");
		p1.setFilhoDaResposta(0);
		this.pokemons.add(p1);
	}

	public void salvar(Pokemon p) {
		if(p != null) {
			this.pokemons.add(p);			
		}
	}

	public List<Pokemon> getPokemon() {
		return this.pokemons;
	}

	public void setAnimais(List<Pokemon> pokemon) {
		this.pokemons = pokemon;
	}


}
