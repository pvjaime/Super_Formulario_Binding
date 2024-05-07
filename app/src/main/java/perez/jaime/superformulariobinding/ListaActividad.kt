package perez.jaime.superformulariobinding

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import perez.jaime.superformulariobinding.databinding.ActivityListaActividadBinding

class ListaActividad : AppCompatActivity() {

    lateinit var binding: ActivityListaActividadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Se configura el binding
        binding = ActivityListaActividadBinding.inflate(layoutInflater)
        //vamos a setear a la pantalla la vista que debe mostrar
        setContentView(binding.root)
        //Vamos a crear la lista de peliculas
        val peliculas = arrayOf(
            "Ghost",
            "El silencio de los inocentes",
            "La edad de oro",
            "los paracaidistas del submarino rojo",
            "los muertos luchan por vivir",
            "el discreto encanto de la burguesía",
            "stalker",
            "el séptimo sello",
            "El Padrino",
            "Día de los Santos Inocentes",
            "Top Gun",
            "niño en pijama de rayas",
            "el mundo de wain",
            "en busca de la felicidad",
            "naranja mecanica",
            "El perfecto asesino",
            "Mision Imposible",
            "solaris",
            "el resplandor",
            "Negocio redondo",
            "el guardaespaldas",
            "incendio bajo el mar",
            "la esquina de la casa redonda",
            "agachate que vienen los indios"
        )

        //Vamos a llenar la lista con la informacion de las peliculas con el adaptador
        val adapterPeliculas = ArrayAdapter(this, R.layout.simple_list_item_1, peliculas)
        //se enlaza el adaptador con la lista que definimos en el XML
        binding.listaPeliculas.adapter = adapterPeliculas
    }
}