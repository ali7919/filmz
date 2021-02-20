package com.codersan.filmz.ui.about

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.lifecycle.AndroidViewModel

class AboutViewModel(application: Application) : AndroidViewModel(application) {

    fun link_clicked(view: View) {
        val type = Integer.valueOf(view.tag.toString())
        val c = view.context
        when (type) {
            0 -> {
                //telegram
                val url = "https://t.me/cdrsn"
                val i = Intent(Intent.ACTION_VIEW)
                i.data = Uri.parse(url)
                c.startActivity(i)
            }
            1 -> {
                //email
                val emailIntent = Intent(
                    Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", "ali7919mb@yahoo.com", null
                    )
                )
                c.startActivity(Intent.createChooser(emailIntent, "Send Email"))
            }
            2 -> {
                //github
                val url1 = "https://github.com/ali7919/filmz"
                val i1 = Intent(Intent.ACTION_VIEW)
                i1.data = Uri.parse(url1)
                c.startActivity(i1)
            }
            3-> {
                //linkedin
                val url1 = "https://ir.linkedin.com/in/ali-mobarekati-00b851156"
                val i1 = Intent(Intent.ACTION_VIEW)
                i1.data = Uri.parse(url1)
                c.startActivity(i1)
            }
        }
    }

}