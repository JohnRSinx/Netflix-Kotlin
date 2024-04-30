package com.example.appfilmes.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appfilmes.R
import com.example.appfilmes.databinding.ActivityFormCadastroBinding

class FormCadastro : AppCompatActivity() {

    private lateinit var binding: ActivityFormCadastroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormCadastroBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        binding.editEmail.requestFocus()

        binding.btNext.setOnClickListener {
            val email = binding.editEmail.text.toString()
            val password = binding.EditPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                Toast.makeText(this,"Cadastro realizado com sucesso!",Toast.LENGTH_SHORT).show()
            }else if (email.isEmpty()) {
                binding.ContainerEmail.helperText = "Preencha o email!"
            }else if (password.isEmpty()){
                binding.ContainerPassword.helperText= "Preencha a senha!"
            }
        }
        binding.txtEnter.setOnClickListener {
            val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
        }

    }

}