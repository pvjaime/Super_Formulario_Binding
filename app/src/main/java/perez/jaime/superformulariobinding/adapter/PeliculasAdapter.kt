package perez.jaime.superformulariobinding.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import perez.jaime.superformulariobinding.R

class PeliculasAdapter(private val listaPeliculas: Array<String>)
    : RecyclerView.Adapter<PeliculasAdapter.ViewHolder>() {

    /**
     * Esta clase define los diferentes elementos que estan definidos en la
     * fila que va a mostrar la informacion
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tituloPelicula: TextView
        val subtituloPelicula: TextView

        init {
            // se enlazan los ids con las vistas
            tituloPelicula = view.findViewById(R.id.titulo_pelicula)
            subtituloPelicula = view.findViewById(R.id.subtitulo_pelicula)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}