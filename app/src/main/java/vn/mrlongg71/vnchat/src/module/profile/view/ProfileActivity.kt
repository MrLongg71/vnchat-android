package vn.mrlongg71.vnchat.src.module.profile.view

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import kotlinx.android.synthetic.main.activity_profile.*
import vn.mrlongg71.vnchat.R

internal class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        toolbar.title = ""
//        main_appbar!!.addOnOffsetChangedListener(this)
//        mToolbar!!.inflateMenu(R.menu.menu_profile)
    }


}