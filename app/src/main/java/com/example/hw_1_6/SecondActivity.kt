package com.example.hw_1_6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hw_1_6.MainActivity.Companion.TEXT_1
import com.example.hw_1_6.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initClickers()
    }
    private fun initClickers() {
        with(binding) {
            btnBack.setOnClickListener {
                val data2 = binding.title.text
                if (data2 == null || data2.toString() == "") {
                    Toast.makeText(
                        this@SecondActivity,
                        "Поле не может быть пустым!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intent = Intent()
                    intent.putExtra(TEXT_2, binding.title.text.toString())
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
            }
        }
    }
    private fun initView() {
        val text = intent.getStringExtra(TEXT_1)
        binding.title.setText(text)
    }
    companion object {
        const val TEXT_2 = "text_2"
    }
}