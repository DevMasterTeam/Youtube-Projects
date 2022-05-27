package com.devmasterteam.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.devmasterteam.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set the click event for the button
        binding.buttonAlertDialog.setOnClickListener { showAlertDialog() }
    }

    /**
     * Show the Alert Dialog with Yes or No options
     */
    private fun showAlertDialog() {
        /* [English]
        * AlertDialog can be created without message, title or button.
        * All the configurations below are optional.
        * Neutral button is set on the left, while positive and negative on the right.
        *
        * [Português]
        * AlertDialog pode ser criado sem mensagem, título ou botão.
        * Todas as configurações abaixo são opcionais.
        * O botão neutro é definido à esquerda, enquanto positivo e negativo à direita.
        * */
        AlertDialog.Builder(this)
            .setMessage(getString(R.string.dialog_message))
            .setTitle(getString(R.string.dialog_title))
            .setPositiveButton(getString(R.string.yes),
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(applicationContext, getString(R.string.yes), Toast.LENGTH_SHORT)
                        .show()
                })
            .setNegativeButton(getString(R.string.no),
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(applicationContext, getString(R.string.no), Toast.LENGTH_SHORT)
                        .show()
                })
            .setNeutralButton(getString(R.string.neutral),
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(
                        applicationContext,
                        getString(R.string.neutral),
                        Toast.LENGTH_SHORT
                    )
                        .show()
                })
            .create()
            .show()

        /* [English]
        * AlertDialog can be set to a variable and triggered at an specific time.
        *
        * [Portguês]
        * AlertDialog pode ser atribuída a uma variável e disparada em um momento específico.
        * */
        // val alert = AlertDialog.Builder(this)
        // lines of code and logic...
        // alert.create().show()
    }
}