package vn.mrlongg71.vnchat.src.utils

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<VM : BaseViewModel?> : AppCompatActivity() {
    protected var viewModel: VM? = null

    @NonNull
    protected abstract fun createViewModel(): VM
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = createViewModel()
    }

}
