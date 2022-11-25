package com.proximabeta.game.con.loop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.proximabeta.game.con.R
import com.proximabeta.game.con.databinding.ActivityCupBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CupActivity : AppCompatActivity() {
    private lateinit var bindGame: ActivityCupBinding
    lateinit var cvPlaneOne: CardView
    lateinit var cvPlaneTwo: CardView
    lateinit var cvPlaneThree: CardView
    lateinit var cvPlaneFour: CardView
    lateinit var cvPlaneFive: CardView
    lateinit var cvPlaneSix: CardView

    var img1: Int = 0
    var img2: Int = 0
    var img3: Int = 0
    var img4: Int = 0
    var img5: Int = 0
    var img6: Int = 0

    lateinit var planeOne: ImageView
    lateinit var planeTwo: ImageView
    lateinit var planeThree: ImageView
    lateinit var planeFour: ImageView
    lateinit var planeFive: ImageView
    lateinit var planeSix: ImageView

    lateinit var textScore: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindGame = ActivityCupBinding.inflate(layoutInflater)
        setContentView(bindGame.root)

        cvPlaneOne = bindGame.cvPlaneOne
        cvPlaneTwo = bindGame.cvPlaneTwo
        cvPlaneThree = bindGame.cvPlaneThree
        cvPlaneFour = bindGame.cvPlaneFour
        cvPlaneFive = bindGame.cvPlaneFive
        cvPlaneSix = bindGame.cvPlaneSix

        planeOne = bindGame.planeOne
        planeTwo = bindGame.planeTwo
        planeThree = bindGame.planeThree
        planeFour = bindGame.planeFour
        planeFive = bindGame.planeFive
        planeSix = bindGame.planeSix

        textScore = bindGame.scoreText



        var txtFromTXT = textScore.text.toString().toInt()

        cvPlaneOne.setOnClickListener{

            setPicture()
            if(img1 == 1) {
                txtFromTXT += 1
                textScore.text = txtFromTXT.toString()
            } else {
                txtFromTXT -= 1
                textScore.text = txtFromTXT.toString()
            }

            Handler(Looper.getMainLooper()).postDelayed({
                planeSix.setBackgroundResource(R.color.blue)
                planeOne.setBackgroundResource(R.color.blue)
                planeTwo.setBackgroundResource(R.color.blue)
                planeThree.setBackgroundResource(R.color.blue)
                planeFour.setBackgroundResource(R.color.blue)
                planeFive.setBackgroundResource(R.color.blue)
            }, 4000)
        }

        cvPlaneTwo.setOnClickListener{

            setPicture()
            if(img2 == 1) {
                txtFromTXT += 1
                textScore.text = txtFromTXT.toString()
            } else {
                txtFromTXT -= 1
                textScore.text = txtFromTXT.toString()
            }

            Handler(Looper.getMainLooper()).postDelayed({
                planeSix.setBackgroundResource(R.color.blue)
                planeOne.setBackgroundResource(R.color.blue)
                planeTwo.setBackgroundResource(R.color.blue)
                planeThree.setBackgroundResource(R.color.blue)
                planeFour.setBackgroundResource(R.color.blue)
                planeFive.setBackgroundResource(R.color.blue)
            }, 4000)
        }

        cvPlaneThree.setOnClickListener{

            setPicture()
            if(img3 == 1) {
                txtFromTXT += 1
                textScore.text = txtFromTXT.toString()
            } else {
                txtFromTXT -= 1
                textScore.text = txtFromTXT.toString()
            }

            Handler(Looper.getMainLooper()).postDelayed({
                planeSix.setBackgroundResource(R.color.blue)
                planeOne.setBackgroundResource(R.color.blue)
                planeTwo.setBackgroundResource(R.color.blue)
                planeThree.setBackgroundResource(R.color.blue)
                planeFour.setBackgroundResource(R.color.blue)
                planeFive.setBackgroundResource(R.color.blue)
            }, 4000)
        }

        cvPlaneFour.setOnClickListener{
            setPicture()

            if(img4 == 1) {
                txtFromTXT += 1
                textScore.text = txtFromTXT.toString()
            } else {
                txtFromTXT -= 1
                textScore.text = txtFromTXT.toString()
            }
            Handler(Looper.getMainLooper()).postDelayed({
                planeSix.setBackgroundResource(R.color.blue)
                planeOne.setBackgroundResource(R.color.blue)
                planeTwo.setBackgroundResource(R.color.blue)
                planeThree.setBackgroundResource(R.color.blue)
                planeFour.setBackgroundResource(R.color.blue)
                planeFive.setBackgroundResource(R.color.blue)
            }, 4000)
        }

        cvPlaneFive.setOnClickListener{
            setPicture()

            if(img5 == 1) {
                txtFromTXT += 1
                textScore.text = txtFromTXT.toString()
            } else {
                txtFromTXT -= 1
                textScore.text = txtFromTXT.toString()
            }
            Handler(Looper.getMainLooper()).postDelayed({
                planeSix.setBackgroundResource(R.color.blue)
                planeOne.setBackgroundResource(R.color.blue)
                planeTwo.setBackgroundResource(R.color.blue)
                planeThree.setBackgroundResource(R.color.blue)
                planeFour.setBackgroundResource(R.color.blue)
                planeFive.setBackgroundResource(R.color.blue)
            }, 4000)
        }

        cvPlaneSix.setOnClickListener{
            setPicture()

            if(img6 == 1) {
                txtFromTXT += 1
                textScore.text = txtFromTXT.toString()
            } else {
                txtFromTXT -= 1
                textScore.text = txtFromTXT.toString()
            }
            Handler(Looper.getMainLooper()).postDelayed({
                planeSix.setBackgroundResource(R.color.blue)
                planeOne.setBackgroundResource(R.color.blue)
                planeTwo.setBackgroundResource(R.color.blue)
                planeThree.setBackgroundResource(R.color.blue)
                planeFour.setBackgroundResource(R.color.blue)
                planeFive.setBackgroundResource(R.color.blue)
            }, 4000)
        }
    }

    private fun setPicture() {
        img1 = (1..6).random()
        img2 = (1..6).random()
        img3 = (1..6).random()
        img4 = (1..6).random()
        img5 = (1..6).random()
        img6 = (1..6).random()

        when (img1) {
            1 ->
                planeOne.setBackgroundResource(R.drawable.ball)
            else ->
                planeOne.setBackgroundResource(R.color.blue)

        }
        when (img2) {
            1 ->
                planeTwo.setBackgroundResource(R.drawable.ball)
            else ->
                planeTwo.setBackgroundResource(R.color.blue)
        }

        when (img3) {
            1 ->
                planeThree.setBackgroundResource(R.drawable.ball)
            else ->
                planeThree.setBackgroundResource(R.color.blue)
        }

        when (img4) {
            1 ->
                planeFour.setBackgroundResource(R.drawable.ball)
            else ->
                planeFour.setBackgroundResource(R.color.blue)
        }

        when (img5) {
            1 ->
                planeFive.setBackgroundResource(R.drawable.ball)
            else ->
                planeFive.setBackgroundResource(R.color.blue)

        }

        when (img6) {
            1 ->
                planeSix.setBackgroundResource(R.drawable.ball)
            else ->
                planeSix.setBackgroundResource(R.color.blue)
        }

    }


}