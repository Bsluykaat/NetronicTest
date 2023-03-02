package com.kerumitbsl.netronictest.ui.splashScreen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kerumitbsl.netronictest.databinding.ActivitySplashBinding
import com.kerumitbsl.netronictest.ui.mainActivity.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        Thread.sleep(2000)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}