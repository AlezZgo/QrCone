package com.example.qrcone.presentation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.example.qrcone.R
import com.example.qrcone.core.QrConeApp
import com.example.qrcone.databinding.ActivityLoginBinding
import com.example.qrcone.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var options: GoogleSignInOptions

    private lateinit var client: GoogleSignInClient

    @Inject
    lateinit var encryptedSharedPrefs: SharedPreferences

    private val component by lazy {
        (application as QrConeApp).component
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        options = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestServerAuthCode(resources.getString(R.string.server_client_id))
            .requestEmail()
            .build()

        client = GoogleSignIn.getClient(application,options)

        val account = GoogleSignIn.getLastSignedInAccount(this)

        if(account==null){
            finish()
            navigateToLoginActivity()
        }
    }

    private fun navigateToLoginActivity() {
        client.signOut().addOnCompleteListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    companion object{
        private const val USER_ID = "user_id"
    }
}