package vn.mrlongg71.vnchat.src.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import vn.mrlongg71.vnchat.R
import vn.mrlongg71.vnchat.src.module.sign_in.view.SignInActivity
import vn.mrlongg71.vnchat.src.module.sign_up.view.SignUpActivity


class SplashScreenActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        btnSignUpSplash.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
        btnSignInSplash.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }


    }
}
