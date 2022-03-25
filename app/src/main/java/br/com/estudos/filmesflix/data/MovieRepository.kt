package br.com.estudos.filmesflix.data

class MovieRepository(private val movieDataSource: MovieDataSource) {

    fun getAllMovieFromDataSource() = movieDataSource.getAllMoviesFromApi()


}