package perez.jaime.superformulariobinding

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CAMERA
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import perez.jaime.superformulariobinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val MY_PERMISSIONS_REQUEST_CAMERA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Se configura el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        //vamos a setear a la pantalla la vista que debe mostrar
        setContentView(binding.root)

        pedirPermisos()

        binding.btnGuardar.setOnClickListener {
            val nombre = binding.txtNombre.text.toString()
            val correo = binding.txtCorreo.text.toString()
            val edad = binding.txtEdad.toString().toIntOrNull()

            //Validando los datos
            if (nombre.isBlank()) {
                binding.txtNombreLayout.error = "Ingresa el nombre"
            } else {
                binding.txtNombreLayout.error = null
            }
            if (correo.isBlank()) {
                binding.txtCorreoInput.error = "Ingresa el correo"
            } else {
                binding.txtCorreoInput.error = null
            }
            if (edad == null) {
                binding.txtEdadInput.error = "Ingresa la edad"
            } else {
                binding.txtEdadInput.error = null
            }

            if (nombre.isNotBlank() && correo.isNotBlank() && edad != null) {
                binding.txtDatosIngresados.text =
                    "Hola $nombre \n Este es tu email: $correo \n Tu edad es: $edad"
            }
        }

        binding.irLista.setOnClickListener {
            val intent = Intent(this, ListaActividad::class.java)
            startActivity(intent)
        }

    }

    private fun pedirPermisos() {
        if (ContextCompat.checkSelfPermission(this, CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            // El permiso no ha sido otorgado, solicítalo al usuario
            ActivityCompat.requestPermissions(
                this, arrayOf(CAMERA, ACCESS_FINE_LOCATION), MY_PERMISSIONS_REQUEST_CAMERA
            )
        } else {
            // El permiso ya ha sido otorgado, puedes realizar las operaciones necesarias
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions:
        Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA) {
            if (grantResults.isNotEmpty() && grantResults[0] ==
                PackageManager.PERMISSION_GRANTED
            ) {
                // Permiso otorgado, puedes realizar las operaciones necesarias
            } else {
                // Permiso denegado, debes manejar esta situación (por ejemplo, mostrar un mensaje de error)
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Androidly Alert")
                builder.setMessage("No me diste acceso a la camara")

                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    pedirPermisos()
                }
                builder.show()
            }
        }
    }

    companion object {
        val tituloPantalla = "Pantalla Ingreso Datos"

        fun saludo() {
            println("Hola Mundo")
        }
    }
}
