package br.com.estudos.filmesflix

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.estudos.filmesflix.databinding.ItemListBinding
import br.com.estudos.filmesflix.model.Movie
import coil.load

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
         return MovieViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = movieList[position]
        holder.itemView.apply {
            holder.movieTitle.text = item.titulo
            holder.movieImage.load(item.imagem) {
                placeholder(R.drawable.ic_baseline_image_24)
                fallback(R.drawable.ic_baseline_image_24)
            }
        }
    }

    override fun getItemCount() : Int = movieList.size

}

class MovieViewHolder(binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root){
    val movieTitle: TextView = binding.textIcon
    val movieImage: ImageView = binding.imageMovieItem

}