package perez.jaime.superformulariobinding.adapter

import android.view.LayoutInflater
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

    //Enlaza el archivo xml con la clase ViewHolder que generamos arriba
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Creando una nueva vista, que define la celda que vamos a pintar la informacion
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fila, parent, false)

        return ViewHolder(view)
    }

    //Esta funcion tiene que devolver la cantidad de items que va a mostrar el Recycler
    override fun getItemCount(): Int {
        return listaPeliculas.size
    }

    //Aca vamos a configurar la informacion en cada celda que vamos a mostrar en la lista
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Obtiene el elemento desde ls lista con su posicion y pinta esta informacion
        // en los diferentes views que tenga la vista
        //Aca estamos mostrando el titulo de la pelicula
        holder.tituloPelicula.text = listaPeliculas[position]
        //Vamos a agregar un texto en el subtitulo
        holder.subtituloPelicula.text = "Estoy en la posición $position"
    }

}