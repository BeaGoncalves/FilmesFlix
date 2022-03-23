package br.com.estudos.filmesflix.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable
import com.google.gson.annotations.SerializedName

@Parcelize
data class Movie(
    val id: Int,
    val titulo: String,
    val imagem: String?,
    val descricao: String?,
    @SerializedName("data_lancamento")
    val dataLancamento: String?
): Parcelable