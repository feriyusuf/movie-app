package id.kotlin.mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import id.kotlin.mvvm.R
import id.kotlin.mvvm.model.User
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(toolbar_detail)
        supportActionBar?.apply {/*TODO*/ }
    }

    override fun onResume() {
        super.onResume()
        initialModel()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun initialModel() {
        val user = intent.getParcelableExtra<User>(User::class.java.simpleName)

        val name = "My name is ${user?.name}"
        tv_name.text = name

        val age = "I'm ${user?.age} years old"
        tv_age.text = age
    }
}