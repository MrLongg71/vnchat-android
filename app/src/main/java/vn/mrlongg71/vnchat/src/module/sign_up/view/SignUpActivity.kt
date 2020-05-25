package vn.mrlongg71.vnchat.src.module.sign_up.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import vn.mrlongg71.vnchat.R
import vn.mrlongg71.vnchat.src.module.sign_up.viewmodel.SignUpViewModel

class SignUpActivity : AppCompatActivity() {

    private var name: String? = null
    private var phone: String? = null
    private var gender: String? = null
    private var password: String? = null
    private val signUpViewModel: SignUpViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        toolbar_SignUp.setNavigationOnClickListener {
            finish()
        }

        handlerSignUp()
        listenerProgress()
    }

    private fun handlerSignUp() {
        btnFloatSingUp.setOnClickListener {
            name = edtNameSignUp.text.toString()
            phone = edtPhoneSignUp.text.toString()
            gender = (radioGender.checkedRadioButtonId).toString()
            password = edtPasswordSignUp.text.toString()
            signUpViewModel.handlerSignUp(phone!!, name!!, gender!!, password!!)
                .observe(this, Observer {
                    if (it.statusCode == 200) {
                        Toasty.success(this, it.message, Toast.LENGTH_LONG).show()
                        finish()
                    } else {

                        Toasty.error(this, it.message, Toast.LENGTH_LONG).show()
                    }
                })

        }
    }

    private fun listenerProgress() {
        signUpViewModel.isLoading.observe(this, Observer {
            if (it) {
                progressSignUp.visibility = (View.VISIBLE)
            } else {
                progressSignUp.visibility = (View.GONE)

            }
        })
    }
}
