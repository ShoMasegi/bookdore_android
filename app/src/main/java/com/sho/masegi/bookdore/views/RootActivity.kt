package com.sho.masegi.bookdore.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sho.masegi.bookdore.R
import com.sho.masegi.bookdore.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityRootBinding>(this, R.layout.activity_root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding
    }
}