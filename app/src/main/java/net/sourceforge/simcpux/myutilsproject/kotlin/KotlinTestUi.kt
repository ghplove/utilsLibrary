package net.sourceforge.simcpux.myutilsproject.kotlin

import android.text.InputType.TYPE_CLASS_TEXT
import android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import net.sourceforge.simcpux.myutilsproject.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by huiping.guo on 17/6/13.
 */
class KotlinTestUi : AnkoComponent<KotlinAnkoTestActivity>{
    private val customStyle = { v: Any ->
        when (v) {
            is Button -> v.textSize = 26f
            is EditText -> v.textSize = 24f
        }
    }
    override fun createView(ui: AnkoContext<KotlinAnkoTestActivity>): View = with(ui){
        verticalLayout {
            padding = dip(32)

            imageView(android.R.drawable.ic_menu_manage).lparams {
                margin = dip(16)
                gravity = Gravity.CENTER
            }

            val name = editText {
                hintResource = R.string.name
            }
            val password = editText {
                hintResource = R.string.password
                inputType = TYPE_CLASS_TEXT or TYPE_TEXT_VARIATION_PASSWORD
            }

            button("Log in") {
                onClick {
                    ui.owner.tryLogin(ui, name.text, password.text)
                }
            }

//            myRichView()
        }.applyRecursively(customStyle)
    }

}