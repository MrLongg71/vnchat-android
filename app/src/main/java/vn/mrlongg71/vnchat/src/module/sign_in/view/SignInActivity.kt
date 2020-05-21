package vn.mrlongg71.vnchat.src.module.sign_in.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_sign_in.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.mrlongg71.vnchat.R
import vn.mrlongg71.vnchat.src.module.sign_in.viewmodel.SignInViewModel
import vn.mrlongg71.vnchat.src.ui.BottomNavigationActivity

class SignInActivity : AppCompatActivity() {

    //  private var signInViewModel: SignInViewModel? = null
    private var email: String? = null
    private var password: String? = null
    private val signInViewModel: SignInViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        btnFloatSingIn.setOnClickListener {
            email = edtPhoneSignIn.text.toString()
            password = edtPasswordSignIn.text.toString()
            signInViewModel.handlerSignIn(email!!, password!!).observe(this, Observer {
                if (it.statusCode == 200) {
                    Toasty.success(this, it.message, Toast.LENGTH_LONG).show()
                    val intent = Intent(this, BottomNavigationActivity::class.java)
                    startActivity(intent)
                } else {
                    Toasty.error(this, it.message, Toast.LENGTH_LONG).show()
                }
            })

        }
        signInViewModel.isLoading.observe(this, Observer {
            if (it) {
                progressSignIn.visibility = (View.VISIBLE)
            } else {
                progressSignIn.visibility = (View.GONE)

            }
        })


    }


}
