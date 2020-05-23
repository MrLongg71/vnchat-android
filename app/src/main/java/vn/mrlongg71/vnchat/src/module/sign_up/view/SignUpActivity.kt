package vn.mrlongg71.vnchat.src.module.sign_up.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*
import vn.mrlongg71.vnchat.R

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        toolbar_SignUp.setNavigationOnClickListener{
            finish()
        }
    }
}
