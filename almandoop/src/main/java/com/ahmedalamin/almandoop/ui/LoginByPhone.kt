package com.ahmedalamin.almandoop.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.ahmedalamin.almandoop.R
import com.ahmedalamin.almandoop.util.CountryData

class LoginByPhone : AppCompatActivity() {

    private var spinner: Spinner? = null
    private var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_by_phone)

        spinner = findViewById<Spinner>(R.id.spinnerCountries) as Spinner
        spinner!!.setAdapter(
            ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                CountryData.countryNames
            )
        )

        editText = findViewById<EditText>(R.id.editTextPhone) as EditText



        findViewById<View>(R.id.buttonContinue).setOnClickListener(View.OnClickListener {
            val code: String = CountryData.countryAreaCodes.get(spinner!!.getSelectedItemPosition())
            val number: String = editText!!.getText().toString().trim { it <= ' ' }
            if (number.isEmpty() || number.length < 10) {
                editText!!.setError("Valid number is required")
                editText!!.requestFocus()
                return@OnClickListener
            }
            val phoneNumber = "+$code$number"
            val intent = Intent(this@LoginByPhone, HomeActivity::class.java)
            intent.putExtra("phonenumber", phoneNumber)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        })
    }

}
