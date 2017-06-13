package net.sourceforge.simcpux.myutilsproject.kotlin

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import org.jetbrains.anko.AnkoContext

/**
 * Created by huiping.guo on 17/6/13.
 */
class RichView : LinearLayout {
    private lateinit var image: ImageView
    private lateinit var text: TextView

    private fun init() = AnkoContext.createDelegate(this).apply {

    }

    constructor(context: Context?) : super(context){
        init()
    }

}