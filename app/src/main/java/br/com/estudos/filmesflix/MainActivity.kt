package br.com.estudos.filmesflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import br.com.estudos.filmesflix.databinding.ActivityMainBinding
import br.com.estudos.filmesflix.databinding.ItemListBinding
import br.com.estudos.filmesflix.model.Movie
import br.com.estudos.filmesflix.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var movieViewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movieViewModel = ViewModelProvider.NewInstanceFactory().create(MovieViewModel::class.java)
        movieViewModel.init()
        initObserver()
        progressVisibility(true)

    }

    private fun initObserver(){
        movieViewModel.movieList.observe(this, Observer {
            if (it.isNotEmpty()) {
                populateList(it)
                progressVisibility(false)
            }
        })
    }

    private fun populateList(list: List<Movie>) {
        binding.recyclerMain.apply {
            hasFixedSize()
            adapter = MovieAdapter(list)
        }
    }

    private fun progressVisibility(isLoading: Boolean){
        binding.progressCircular.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}