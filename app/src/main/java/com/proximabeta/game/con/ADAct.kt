package com.proximabeta.game.con

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.orhanobut.hawk.Hawk
import com.proximabeta.game.con.ThatClass.Companion.MAIN_ID
import com.proximabeta.game.con.ThatClass.Companion.appsCheck
import com.proximabeta.game.con.loop.LOneAct
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class ADAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adact)
        checkCountry()
    }

    private fun getShData(): String? {
        val restCheck: String? = Hawk.get(appsCheck)
        Log.d("ADACt Data", restCheck.toString())
        return restCheck
    }

    private fun checkCountry() {

        val check = getShData()

        if (check == "0") {
            intALone()
        } else {
            GlobalScope.launch(Dispatchers.Default) {
                getAdId()
            }
                intAfb()
        }
    }

    private fun getAdId(){
        val adInfo = AdvertisingIdClient(applicationContext)
        adInfo.start()
        val adIdInfo = adInfo.info.id
        Log.d("getAdvertisingId = ", adIdInfo.toString())
        Hawk.put(MAIN_ID, adIdInfo)
    }

    private fun intALone() {
        val intent = Intent(this@ADAct, LOneAct::class.java)
        startActivity(intent)
        finish()
    }

    private fun intAfb() {
        val intent = Intent(this@ADAct, AsfAct::class.java)
        startActivity(intent)
        finish()
    }
}