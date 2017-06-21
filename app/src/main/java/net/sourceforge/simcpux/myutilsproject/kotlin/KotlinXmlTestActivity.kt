package net.sourceforge.simcpux.myutilsproject.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin_xml_test.*
import net.sourceforge.simcpux.myutilsproject.R

class KotlinXmlTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_xml_test)
        button.setOnClickListener {
            button.setText("test")
        }
    }
}
