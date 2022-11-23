package com.proximabeta.game.con.loop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.proximabeta.game.con.R
import com.proximabeta.game.con.databinding.ActivityLoneBinding

class LOneAct : AppCompatActivity() {
    lateinit var iGamerBind: ActivityLoneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

            iGamerBind = ActivityLoneBinding.inflate(layoutInflater)
            setContentView(iGamerBind.root)

            val nameTxt = iGamerBind.nameET

            iGamerBind.strtGm.setOnClickListener{

                if (TextUtils.isEmpty(nameTxt.text.toString())) {
                    nameTxt.error = "Field is empty"
                } else {
                    val intent = Intent(this, RulAct::class.java)
                    intent.putExtra("name", nameTxt.text.toString())
                    startActivity(intent)
                    finish()
                }
            }
        }
    }