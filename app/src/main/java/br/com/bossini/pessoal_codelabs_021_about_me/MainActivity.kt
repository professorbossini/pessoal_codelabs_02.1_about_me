package br.com.bossini.pessoal_codelabs_021_about_me

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById <Button> (R.id.done_button).setOnClickListener{
            addNickName(it)
        }
        findViewById<TextView>(R.id.nickname_textview).setOnClickListener{
            updateNickname(it)
        }

    }

    private fun addNickName (view: View){
        val nicknameEditText = findViewById <EditText>( R.id.nickname_edittext)
        val nicknameTextView = findViewById <TextView> (R.id.nickname_textview)
        nicknameTextView.text = nicknameEditText.text
        nicknameEditText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow( view.windowToken, 0)
    }

    private fun updateNickname (view: View){
        val nicknameEditText: EditText = findViewById (R.id.nickname_edittext)
        val doneButton = findViewById<Button>(R.id.done_button)
        nicknameEditText.visibility = View.VISIBLE
        nicknameEditText.text.clear()
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        nicknameEditText.requestFocus()
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput (nicknameEditText, 0)
    }
}
