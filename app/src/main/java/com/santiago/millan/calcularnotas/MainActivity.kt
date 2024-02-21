package com.santiago.millan.calcularnotas


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.titulo1)
        contador = findViewById(R.id.counter)
        edicionT = findViewById(R.id.editText)
        nextButton = findViewById(R.id.next)
        instrucciones = findViewById(R.id.instructions)
        finishButton = findViewById(R.id.finish)

    }

    lateinit var title: TextView
    lateinit var contador: TextView
    lateinit var edicionT: EditText
    lateinit var nextButton: Button
    lateinit var instrucciones: TextView
    lateinit var finishButton: Button
    var proceso = 0

    var listaEstudiantes: MutableList<Estudiante> = mutableListOf()

    var estudianteActual: Estudiante = Estudiante()

    var listaPorcentajes: MutableList<Int> = mutableListOf()


    var listaNotas: MutableList<Double> = mutableListOf()

    var porcentaje = 0

    fun validacion() {


        when (proceso) {
            0 -> {
                //crearEstudiante(edicionT.text.toString())
                estudianteActual.nombre = edicionT.text.toString()
                instrucciones.text = "Digite el porcentaje"

            }

            1 -> {
                val porcentajeNuevo = edicionT.text.toString().toInt()
                if(validarPorcentaje(porcentajeNuevo)){
                    porcentaje += porcentajeNuevo
                    listaPorcentajes.add(porcentajeNuevo)
                    instrucciones.text = "Digite la nota"
                    contador.text = "$porcentaje%"
                }else{
                    instrucciones.text = "Digite un porcentaje valido"
                    return
                }
            }

            2 -> {
              val notaNueva =  listaNotas.add((edicionT.text.toString()).toDouble())
                if(validarNota(notaNueva)){
                    instrucciones.text = "Digite el porcentaje"

                }else {
                    instrucciones.text = "Digite una nota valida"
                }

            }

            else -> {

            }
        }

        proceso++
    }

    fun validarPorcentaje(pIngresado: Int): Boolean {
        return pIngresado + porcentaje <= 100
    }


    fun validarNota(nIngresada: Double) : Boolean{
        return (nIngresada <= 5.0) && (nIngresada >= 0.0)
    }

        fun crearEstudiante(nombre: String) {


        }


        fun cambio() {
            when (nextButton.setOnClickListener {
            }

        }


    }


    class Estudiante() {
        var nombre: String = ""
        var notas = arrayOf<Double>()
        var porcentajes = arrayOf<Int>()

        fun promedio(): Double {
            var resultado: Double = 0.0


            var contador = 0
            var indice = 0
            for (n in notas) {

                resultado += (n * porcentajes[indice]) / 100
                indice++





                if (resultado > 5.0) {
                    println("El resultado final no es concluso, por favor revise la informacion digitada")
                } else if (resultado < 3.0) {

                    println("El estudiante reprobó" + resultado)
                } else if (resultado >= 3.0) {
                    println("el estudiante aprobó" + resultado)
                } else if (resultado < 0.0) {
                    println("El resultado final no es concluso, por favor revise la informacion digitada")
                }

            }










            return resultado

        }


    }