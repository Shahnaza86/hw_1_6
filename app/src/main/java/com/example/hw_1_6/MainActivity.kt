package com.example.hw_1_6

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.hw_1_6.SecondActivity.Companion.TEXT_2
import com.example.hw_1_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }
    private fun initClickers() {
        registerForActivity()
        with(binding) {
            btnNext.setOnClickListener {
                val data = binding.etTitle.text
                if (data == null || data.toString() == "") {
                    Toast.makeText(
                        this@MainActivity,
                        "Поле не может быть пустым!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra(TEXT_1, etTitle.text.toString())
                    resultLauncher.launch(intent)
                }
            }
        }
    }
    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
                if (activityResult.resultCode == Activity.RESULT_OK && activityResult.data != null) {
                    binding.etTitle.setText(activityResult.data!!.getStringExtra(TEXT_2))
                }
            }
    }
    companion object {
        const val TEXT_1 = "text_1"
    }
}
