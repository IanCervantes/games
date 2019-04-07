package com.example.games

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.games.MenuActivity
import com.example.games.R
import kotlinx.android.synthetic.main.activity_memorama.*

import java.util.*
import kotlin.collections.ArrayList

class MemoramaActivity : AppCompatActivity() {

    var cardsArray = ArrayList<Int>()

    var shinx1 = R.drawable.shinx
    var pikachu1 = R.drawable.pikachu
    var bulbasaur1 = R.drawable.bulbasaur
    var gardevoir1 = R.drawable.gardevoir
    var moltres1 = R.drawable.moltres
    var victini1 = R.drawable.victini
    var shinx2 = R.drawable.shinx
    var pikachu2 = R.drawable.pikachu
    var bulbasaur2 = R.drawable.bulbasaur
    var gardevoir2 = R.drawable.gardevoir
    var moltres2 = R.drawable.moltres
    var victini2 = R.drawable.victini

    var cardNumber = 1
    var clickedFirst = 0
    var clickedSecond = 0

    var firstCard = 0
    var secondCard = 0

    var playerPoints = 0
    var cpuPoints = 0
    var turn = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memorama)


        var tv_p1 = findViewById<TextView>(R.id.tv_p1)
        var tv_p2 = findViewById<TextView>(R.id.tv_p2)

        var iv_11 = findViewById<ImageView>(R.id.iv_11)
        var iv_12 = findViewById<ImageView>(R.id.iv_12)
        var iv_13 = findViewById<ImageView>(R.id.iv_13)
        var iv_14 = findViewById<ImageView>(R.id.iv_14)
        var iv_21 = findViewById<ImageView>(R.id.iv_21)
        var iv_22 = findViewById<ImageView>(R.id.iv_22)
        var iv_23 = findViewById<ImageView>(R.id.iv_23)
        var iv_24 = findViewById<ImageView>(R.id.iv_24)
        var iv_31 = findViewById<ImageView>(R.id.iv_31)
        var iv_32 = findViewById<ImageView>(R.id.iv_32)
        var iv_33 = findViewById<ImageView>(R.id.iv_33)
        var iv_34 = findViewById<ImageView>(R.id.iv_34)

        cardsArray.add(101)
        cardsArray.add(102)
        cardsArray.add(103)
        cardsArray.add(104)
        cardsArray.add(105)
        cardsArray.add(106)
        cardsArray.add(201)
        cardsArray.add(202)
        cardsArray.add(203)
        cardsArray.add(204)
        cardsArray.add(205)
        cardsArray.add(206)

        iv_11.setTag("0")
        iv_12.setTag("1")
        iv_13.setTag("2")
        iv_14.setTag("3")
        iv_21.setTag("4")
        iv_22.setTag("5")
        iv_23.setTag("6")
        iv_24.setTag("7")
        iv_31.setTag("8")
        iv_32.setTag("9")
        iv_33.setTag("10")
        iv_34.setTag("11")

        frontOfCardResources()

        cardsArray.shuffle()

        tv_p2.setTextColor(Color.GRAY)


        iv_11.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_11, theCard)
        })

        iv_12.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_12, theCard)
        })

        iv_13.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_13, theCard)
        })

        iv_14.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_14, theCard)
        })

        iv_21.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_21, theCard)
        })

        iv_22.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_22, theCard)
        })

        iv_23.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_23, theCard)
        })

        iv_24.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_24, theCard)
        })

        iv_31.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_31, theCard)
        })

        iv_32.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_32, theCard)
        })

        iv_33.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_33, theCard)
        })

        iv_34.setOnClickListener(View.OnClickListener { view ->
            var theCard = view.tag.toString().toInt()
            doStuff(iv_34, theCard)
        })
    }

    fun doStuff(iv: ImageView, card: Int)
    {
        when {
            cardsArray[card] == 101 -> iv.setImageResource(shinx1)
            cardsArray[card] == 102 -> iv.setImageResource(pikachu1)
            cardsArray[card] == 103 -> iv.setImageResource(bulbasaur1)
            cardsArray[card] == 104 -> iv.setImageResource(gardevoir1)
            cardsArray[card] == 105 -> iv.setImageResource(moltres1)
            cardsArray[card] == 106 -> iv.setImageResource(victini1)
            cardsArray[card] == 201 -> iv.setImageResource(shinx2)
            cardsArray[card] == 202 -> iv.setImageResource(pikachu2)
            cardsArray[card] == 203 -> iv.setImageResource(bulbasaur2)
            cardsArray[card] == 204 -> iv.setImageResource(gardevoir2)
            cardsArray[card] == 205 -> iv.setImageResource(moltres2)
            cardsArray[card] == 206 -> iv.setImageResource(victini2)
        }

        if(cardNumber == 1)
        {
            firstCard = cardsArray[card]
            if(firstCard > 200){
                firstCard -= 100
            }
            cardNumber = 2
            clickedFirst = card
            iv.isEnabled = false
        } else if(cardNumber == 2){
            secondCard = cardsArray[card]
            if(secondCard > 200){
                secondCard -= 100
            }
            cardNumber = 1
            clickedSecond = card

            iv_11.isEnabled = false
            iv_12.isEnabled = false
            iv_13.isEnabled = false
            iv_14.isEnabled = false
            iv_21.isEnabled = false
            iv_22.isEnabled = false
            iv_23.isEnabled = false
            iv_24.isEnabled = false
            iv_31.isEnabled = false
            iv_32.isEnabled = false
            iv_33.isEnabled = false
            iv_34.isEnabled = false


            Handler().postDelayed({ calculate() }, 1000)
        }

    }

    @SuppressLint("SetTextI18n")
    fun calculate(){
        if(firstCard == secondCard) {
            when (clickedFirst) {
                0 -> iv_11.setVisibility(View.INVISIBLE)
                1 -> iv_12.setVisibility(View.INVISIBLE)
                2 -> iv_13.setVisibility(View.INVISIBLE)
                3 -> iv_14.setVisibility(View.INVISIBLE)
                4 -> iv_21.setVisibility(View.INVISIBLE)
                5 -> iv_22.setVisibility(View.INVISIBLE)
                6 -> iv_23.setVisibility(View.INVISIBLE)
                7 -> iv_24.setVisibility(View.INVISIBLE)
                8 -> iv_31.setVisibility(View.INVISIBLE)
                9 -> iv_32.setVisibility(View.INVISIBLE)
                10 -> iv_33.setVisibility(View.INVISIBLE)
                11 -> iv_34.setVisibility(View.INVISIBLE)
            }

            when (clickedSecond) {
                0 -> iv_11.visibility = View.INVISIBLE
                1 -> iv_12.visibility = View.INVISIBLE
                2 -> iv_13.visibility = View.INVISIBLE
                3 -> iv_14.visibility = View.INVISIBLE
                4 -> iv_21.visibility = View.INVISIBLE
                5 -> iv_22.visibility = View.INVISIBLE
                6 -> iv_23.visibility = View.INVISIBLE
                7 -> iv_24.visibility = View.INVISIBLE
                8 -> iv_31.visibility = View.INVISIBLE
                9 -> iv_32.visibility = View.INVISIBLE
                10 -> iv_33.visibility = View.INVISIBLE
                11 -> iv_34.visibility = View.INVISIBLE
            }

            if(turn == 1)
            {
                playerPoints++
                tv_p1.text = "P1: $playerPoints"
            }else if(turn == 2){
                cpuPoints++
                tv_p2.text = "P2: $cpuPoints"
            }
        } else{
            iv_11.setImageResource(R.drawable.incognito)
            iv_12.setImageResource(R.drawable.incognito)
            iv_13.setImageResource(R.drawable.incognito)
            iv_14.setImageResource(R.drawable.incognito)
            iv_21.setImageResource(R.drawable.incognito)
            iv_22.setImageResource(R.drawable.incognito)
            iv_23.setImageResource(R.drawable.incognito)
            iv_24.setImageResource(R.drawable.incognito)
            iv_31.setImageResource(R.drawable.incognito)
            iv_32.setImageResource(R.drawable.incognito)
            iv_33.setImageResource(R.drawable.incognito)
            iv_34.setImageResource(R.drawable.incognito)

            if(turn == 1)
            {
                turn = 2
                tv_p1.setTextColor(Color.GRAY)
                tv_p2.setTextColor(Color.BLACK)
            }else if(turn == 2){
                turn = 1
                tv_p2.setTextColor(Color.GRAY)
                tv_p1.setTextColor(Color.BLACK)
            }
        }

        iv_11.isEnabled = true
        iv_12.isEnabled = true
        iv_13.isEnabled = true
        iv_14.isEnabled = true
        iv_21.isEnabled = true
        iv_22.isEnabled = true
        iv_23.isEnabled = true
        iv_24.isEnabled = true
        iv_31.isEnabled = true
        iv_32.isEnabled = true
        iv_33.isEnabled = true
        iv_34.isEnabled = true

        checkEnd()
    }

    fun checkEnd(){
        if(iv_11.visibility == View.INVISIBLE &&
            iv_12.visibility == View.INVISIBLE &&
            iv_13.visibility == View.INVISIBLE &&
            iv_14.visibility == View.INVISIBLE &&
            iv_21.visibility == View.INVISIBLE &&
            iv_22.visibility == View.INVISIBLE &&
            iv_23.visibility == View.INVISIBLE &&
            iv_24.visibility == View.INVISIBLE &&
            iv_31.visibility == View.INVISIBLE &&
            iv_32.visibility == View.INVISIBLE &&
            iv_33.visibility == View.INVISIBLE &&
            iv_34.visibility == View.INVISIBLE)  {

            val alertDialogBuilder = AlertDialog.Builder(this@MemoramaActivity)
            alertDialogBuilder.setMessage("GAME OVER!\nP1: $playerPoints\nP2: $cpuPoints").setCancelable(false)
                .setPositiveButton("NEW"){dialog, which ->
                    DialogInterface.OnClickListener { dialogInterface, i ->
                        val intent = Intent(applicationContext, MenuActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
                .setNegativeButton("EXIT"){dialog, which -> DialogInterface.OnClickListener { dialogInterface, i -> finish() } }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }

    fun frontOfCardResources(){
        var image101 = R.drawable.shinx
        var image102 = R.drawable.pikachu
        var image103 = R.drawable.bulbasaur
        var image104 = R.drawable.gardevoir
        var image105 = R.drawable.moltres
        var image106 = R.drawable.victini
        var image201 = R.drawable.shinx
        var image202 = R.drawable.pikachu
        var image203 = R.drawable.bulbasaur
        var image204 = R.drawable.gardevoir
        var image205 = R.drawable.moltres
        var image206 = R.drawable.victini
    }
}