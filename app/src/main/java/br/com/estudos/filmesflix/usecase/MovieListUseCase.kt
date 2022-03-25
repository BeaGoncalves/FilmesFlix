package br.com.estudos.filmesflix.usecase

import br.com.estudos.filmesflix.data.MovieRepository

class MovieListUseCase(private val movieRepository: MovieRepository) {

    //irá executar a chamada para o metodo getAllMoviedata do movieRepository
    operator fun invoke() = movieRepository.getAllMovieFromDataSource()
}