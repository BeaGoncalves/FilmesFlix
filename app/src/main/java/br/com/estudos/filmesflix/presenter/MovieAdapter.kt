package br.com.estudos.filmesflix.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.estudos.filmesflix.R
import br.com.estudos.filmesflix.databinding.ItemListBinding
import br.com.estudos.filmesflix.domain.Movie
import coil.load

class MovieAdapter(private val movieList: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val movieTitle : TextView = itemView.findViewById(R.id.text_icon)
        val movieImage: ImageView = itemView.findViewById(R.id.image_movie_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return MovieViewHolder(view)
    //return MovieViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
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



