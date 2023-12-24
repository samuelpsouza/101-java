package dev.ssouza.javamodules.services;

import dev.ssouza.javamodules.domain.entity.Pokemon;

public class PokemonService implements Service<Pokemon> {

	@Override
	public Pokemon create(Pokemon pokemon) {
		throw new UnsupportedOperationException("Unimplemented method 'create'");
	}

	@Override
	public Pokemon read(Integer id) {
		throw new UnsupportedOperationException("Unimplemented method 'read'");
	}

	@Override
	public Pokemon update(Pokemon t) {
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public Boolean delete(Integer id) {
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}
