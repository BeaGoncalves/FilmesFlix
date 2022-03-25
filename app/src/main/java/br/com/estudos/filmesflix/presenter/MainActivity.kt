package br.com.estudos.filmesflix.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import br.com.estudos.filmesflix.databinding.ActivityMainBinding
import br.com.estudos.filmesflix.domain.Movie
import br.com.estudos.filmesflix.framework.f.viewmodel.MovieViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var adapterMovie: MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movieViewModel = ViewModelProvider.NewInstanceFactory().create(MovieViewModel::class.java)
        movieViewModel.init()
        initObserver()
        progressVisibility(true)

    }


    private fun  initObserver(){
        movieViewModel.movieList.observe(this, Observer { list ->
            if (list.isNotEmpty()){
                populateList(list)
                progressVisibility(false)
            }
        })
    }

//    private fun initObserver(){
//        movieViewModel.movieList.observe(this, { list ->
//            if (list.isNotEmpty()) {
//                populateList(list)
//                progressVisibility(false)
//            }
//        })
//    }

    private fun populateList(list: List<Movie>) = with(binding){
          adapterMovie = MovieAdapter(list)
        recyclerMain.apply {
            adapter = adapterMovie
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun progressVisibility(isLoading: Boolean){
        binding.progressCircular.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

}