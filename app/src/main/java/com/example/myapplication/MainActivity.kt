package com.example.myapplication

import android.animation.Animator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.TextureView
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var bookIconImageView:ImageView? = null
    var afterAnimationView:RelativeLayout? = null
    var bookITextView:TextView? = null
    var loadingProgressBar:ProgressBar? = null
    var rootView:RelativeLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        System.out.println("----------onCreate()")
        bookITextView = findViewById(R.id.bookITextView)
        loadingProgressBar = findViewById(R.id.loadingProgressBar)
        rootView = findViewById(R.id.rootView)
        bookIconImageView = findViewById(R.id.bookIconImageView)
        afterAnimationView = findViewById(R.id.afterAnimationView)
        start()
    }
    fun start() {
        System.out.println("----------start()")
        object : CountDownTimer(5000, 1000) {
            override fun onFinish() {
                System.out.println("----------onFinish()")
                bookITextView?.visibility = View.GONE
                loadingProgressBar?.visibility = View.GONE
                rootView?.setBackgroundColor(ContextCompat.getColor(this@MainActivity, R.color.colorSplashText))
                bookIconImageView?.setImageResource(R.drawable.background_color_book)
                startAnimation()
            }

            override fun onTick(p0: Long) {}

        }.start()
    }
    private fun startAnimation() {
        bookIconImageView?.animate().apply {
            this?.x(0f)
            this?.y(0f)
            this?.duration = 1000
        }?.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {
            }
            override fun onAnimationEnd(p0: Animator?) {
                System.out.println("----------onAnimationEnd()")
                afterAnimationView?.visibility = View.VISIBLE
            }
            override fun onAnimationCancel(p0: Animator?) {
            }
            override fun onAnimationStart(p0: Animator?) {
                System.out.println("----------onAnimationStart()")
            }
        })
    }
}
