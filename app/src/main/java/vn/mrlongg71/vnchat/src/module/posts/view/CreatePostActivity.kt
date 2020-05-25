package vn.mrlongg71.vnchat.src.module.posts.view

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_create_post.*
import kotlinx.android.synthetic.main.custom_bottom_sheet_add_details_post.*
import kotlinx.android.synthetic.main.custom_bottom_sheet_change_limits_post.*
import vn.mrlongg71.vnchat.R

class CreatePostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
//        limits.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_diary,0,0,0)
//        limits.setOnClickListener {
//            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
//                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
//            } else {
//                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
//            }
//        }
//        this.window.setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
//        )
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
//                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY


        val bottomSheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        val bottomSheetBehaviorLimits = BottomSheetBehavior.from(bottom_sheet_limits)

        edtContentPost.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            Log.d("oonKeyBord", hasFocus.toString())

            if (hasFocus) {
                Log.d("oonKeyBord", "show")
                //got focus
            } else {
                Log.d("oonKeyBord", "hide")
                //lost focus
            }
        }

        limits.setOnClickListener {
            if (bottomSheetBehaviorLimits.state != BottomSheetBehavior.STATE_EXPANDED) {
                bottom_sheet.visibility = (View.GONE)
                bottomSheetBehaviorLimits.setState(BottomSheetBehavior.STATE_EXPANDED)
            } else {
                bottom_sheet.visibility = (View.VISIBLE)
                bottomSheetBehaviorLimits.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
        }

        img_arrow_up.setOnClickListener {
            if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            } else {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
            }
        }
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }
    }
}
