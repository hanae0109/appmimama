package fr.isen.lopez.appmimama.model

import com.google.gson.annotations.SerializedName
import fr.isen.lopez.appmimama.model.Data


data class DataResult (

  @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()

):java.io.Serializable