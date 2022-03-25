package br.com.estudos.filmesflix.data

import br.com.estudos.filmesflix.domain.Movie


interface MovieDataSource {

    fun getAllMoviesFromApi() : List<Movie>
}