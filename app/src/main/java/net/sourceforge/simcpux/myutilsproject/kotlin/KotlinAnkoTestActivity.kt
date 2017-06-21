package net.sourceforge.simcpux.myutilsproject.kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.setContentView

class KotlinAnkoTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_kotlin_test)
        KotlinTestUi().setContentView(this)
    }

    fun tryLogin(ui: AnkoContext<KotlinAnkoTestActivity>, name: CharSequence?, password: CharSequence?) {

    }
}
