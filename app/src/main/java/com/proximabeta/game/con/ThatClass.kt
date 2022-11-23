package com.proximabeta.game.con

import android.app.Application
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk

class ThatClass : Application() {
    companion object {
        const val oneS = "ae2246a4-9884-4399-b228-f69f25d2345f"
        var appsCheck = "appsChecker"
        var geo = "geo"
        var C1: String? = "c11"
        var link = "link"
        var MAIN_ID: String? = "mainid"
        var DEEPL: String? = "d11"
        var countryCode: String? = "countryCode"
    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(oneS)
        Hawk.init(this).build()
    }
}
