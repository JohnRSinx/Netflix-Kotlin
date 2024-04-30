package com.example.appfilmes.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appfilmes.R
import com.example.appfilmes.databinding.ActivityFormLoginBinding


class FormLogin : AppCompatActivity() {

    private lateinit var binding : ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.editEmail.requestFocus()

        binding.btEnter.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.EditPassword.text.toString()
            when{
                email.isEmpty() -> {
                    binding.ContainerEmail.helperText = "Preencha o email!"
                }
                password.isEmpty()-> {
                    binding.ContainerPassword.helperText= "Preencha a senha!"
                }
            }
        }
        binding.txtRegister.setOnClickListener {
            val intent = Intent(this, FormCadastro::class.java)
            startActivity(intent)
        }

    }
}