package com.example.games

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlin.collections.ArrayList


class GatoActivity : AppCompatActivity() {

    /*
*
* Completa el código
*
* Crea un Tablero y un JugadorAutomatic
* */


    var player = 1;
    var p1 = ArrayList<Int>()
    var p2 = ArrayList<Int>()
    var tablero = Tablero()
    var jugadorAutomatico = JugadorAutomatic(tablero)
    var handler = Handler();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * Completa el códig:
        *
        * asigna a tu JugadorAutomatic la Ficha con la que juega.
        * * */
        jugadorAutomatico.miFicha = Ficha.BOLA
    }

    fun gameOn(buttonCode:Int, selectedButton:Button){
        if(player == 1){
            selectedButton.text = "X"
            selectedButton.setBackgroundResource(R.color.blue)
            p1.add(buttonCode)
            player = 2


        }else if(player == 2){
            selectedButton.text = "O"
            selectedButton.setBackgroundResource(R.color.green)
            p2.add(buttonCode)
            player = 1
        }
        selectedButton.isEnabled = false
    }



    fun andTheWinnerIs(player :ArrayList<Int>): Boolean{
        var win :Boolean = false
        if(player.contains(1) && player.contains(2)  && player.contains(3) ) win = true
        if (player.contains(4)&&player.contains(5)&&player.contains(6)) win = true
        if (player.contains(7)&&player.contains(8)&&player.contains(9)) win = true
        if (player.contains(1)&&player.contains(4)&&player.contains(7)) win = true
        if (player.contains(2)&&player.contains(5)&&player.contains(8)) win = true
        if (player.contains(3)&&player.contains(6)&&player.contains(9)) win = true
        if (player.contains(1)&&player.contains(5)&&player.contains(9)) win = true
        if (player.contains(3)&&player.contains(5)&&player.contains(7)) win = true

        return win

    }

    fun select(view: View) {
        val selectedButton = view as Button
        var buttonCode = 0
        when(selectedButton.id){
            R.id.button -> buttonCode = 1
            R.id.button2 -> buttonCode = 2
            R.id.button3 -> buttonCode = 3
            R.id.button4 -> buttonCode = 4
            R.id.button5 -> buttonCode = 5
            R.id.button6-> buttonCode = 6
            R.id.button7-> buttonCode = 7
            R.id.button8-> buttonCode = 8
            R.id.button9-> buttonCode =9
        }

        gameOn(buttonCode,selectedButton)

        /*
   Completa el código:
   Llama a la función de "move" utilzando un Handler().postDelayed de 1 segundo
    * */
        val runnable = Runnable { move() }
        handler.postDelayed(runnable, 1000)


        if (andTheWinnerIs(p1) ){
            Toast.makeText(this,
                "AND the winner is PLAYER 1", Toast.LENGTH_LONG).show()
        }else if(andTheWinnerIs(p2)){
            Toast.makeText(this,
                "AND the winner is PLAYER 2", Toast.LENGTH_LONG).show()
        }

    }


    /*
    Completa el código:
    Debes mapear el renglo y la columna para regrar un Pair.... WHAAAAATTTTT, investiga qué es un Pair
    El Pair debe regresar:
        1. el número de la ficha, del 1 al 9
        2. el Button correspondiente con la interfaz
     * */
    fun nextFicha(renglon : Int, columna : Int): Pair<Int, Button> {
        var numFicha = 0
        var boton = findViewById<Button>(R.id.button)
        when(renglon){
            0 -> when(columna){
                0 -> {
                    numFicha = 1
                    boton = findViewById(R.id.button)
                }
                1 -> {
                    numFicha = 2
                    boton = findViewById(R.id.button2)
                }
                2 -> {
                    numFicha = 3
                    boton = findViewById(R.id.button3)
                }
            }
            1 -> when(columna){
                0 -> {
                    numFicha = 4
                    boton = findViewById(R.id.button4)
                }
                1 -> {
                    numFicha = 5
                    boton = findViewById(R.id.button5)
                }
                2 -> {
                    numFicha = 6
                    boton = findViewById(R.id.button6)
                }
            }
            2 -> when(columna){
                0 -> {
                    numFicha = 7
                    boton = findViewById(R.id.button7)
                }
                1 -> {
                    numFicha = 8
                    boton = findViewById(R.id.button8)
                }
                2 -> {
                    numFicha = 9
                    boton = findViewById(R.id.button9)
                }
            }
        }

        return Pair(numFicha, boton)
    }

    /*
    Completa el código:
    Completa la funcjón y realiza lo siguiente:
    1. Ejecuta: ___TU JUGADORAUTOMATIC__.tablero.setTablero(p1, p2)
    2. Obten el siguiente movimiento automático
    3. Ejecuta la función de nextFicha y obten el pair
    4. Manda el pair a gameOn como corresponde
     * */
    fun move(){
        jugadorAutomatico.tablero.setTablero(p1,p2);
        var siguienteMovimiento = jugadorAutomatico.calculaMovimiento();
        var (numFicha, boton) = nextFicha(siguienteMovimiento!![0], siguienteMovimiento!![1])
        gameOn(numFicha, boton)
    }


}