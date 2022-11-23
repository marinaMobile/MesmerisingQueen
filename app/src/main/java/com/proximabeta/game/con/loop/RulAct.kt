package com.proximabeta.game.con.loop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.proximabeta.game.con.R
import com.proximabeta.game.con.databinding.ActivityCupBinding
import com.proximabeta.game.con.databinding.ActivityLoneBinding
import com.proximabeta.game.con.databinding.ActivityRulBinding

class RulAct : AppCompatActivity() {
    lateinit var iGamerBind: ActivityRulBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iGamerBind = ActivityRulBinding.inflate(layoutInflater)
        setContentView(iGamerBind.root)

        iGamerBind.strtGm.setOnClickListener{
                val intent = Intent(this, CupActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
}