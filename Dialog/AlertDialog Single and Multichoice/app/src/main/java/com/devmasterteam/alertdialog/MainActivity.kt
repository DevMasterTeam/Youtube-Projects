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
        * Multi choice and Single choice options replace the message of the AlertDialog.
        * It's not possible to have 'choices' and a message at the same time.
        *
        * [Português]
        * Opções sinlge choice e multi choice substituem a mensagem da AlertDialog.
        * Não é possível ter uma lista de opções e uma mensagem ao mesmo tempo.
        * */

        val items = arrayOf("Option 1", "Option 2", "Option 3")
        val checkedItems = BooleanArray(items.size)

        AlertDialog.Builder(this)
            // .setMessage(getString(R.string.dialog_message))
            .setTitle(getString(R.string.dialog_title))

            .setPositiveButton(getString(R.string.ok),
                DialogInterface.OnClickListener { dialog, id ->
                    Toast.makeText(applicationContext, getString(R.string.ok), Toast.LENGTH_SHORT)
                        .show()
                })

            // [EN] Single OR Multi - Not possible to have both
            // [PT] Single OU Multi - Não é possível os dois ao mesmo tempo
            .setSingleChoiceItems(items, 1, DialogInterface.OnClickListener { dialog, id ->
                Toast.makeText(applicationContext, "$id", Toast.LENGTH_SHORT).show()
            })

            // [EN] Single OR Multi - Not possible to have both
            // [PT] Single OU Multi - Não é possível os dois ao mesmo tempo
            .setMultiChoiceItems(
                items,
                checkedItems,
                DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->

                    // Which - Which option was clicked
                    // isChecked - True or false

                    Toast.makeText(
                        applicationContext,
                        "Position: $which, cheched: $isChecked",
                        Toast.LENGTH_SHORT
                    ).show()
                })

            .create()
            .show()
    }
}