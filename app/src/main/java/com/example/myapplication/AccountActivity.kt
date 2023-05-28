package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import de.hdodenhof.circleimageview.CircleImageView

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        val circleImageView: CircleImageView = findViewById(R.id.circleImageView)
        circleImageView.borderWidth = 2
        circleImageView.borderColor = ContextCompat.getColor(this, R.color.black)

    }
}