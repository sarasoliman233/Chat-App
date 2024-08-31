package com.basicsandroid.chatapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.basicsandroid.chatapp.Login.LoginActivity
import com.basicsandroid.chatapp.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Handler(Looper.getMainLooper()).postDelayed({
val intent=Intent(this@MainActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()

            },2500)
            ChatAppTheme {
                // A surface container using the 'background' color from the theme
   SplashActivityContent()
            }
        }
    }
}

@Composable
fun SplashActivityContent(){
Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
    Image(painter = painterResource(id = R.drawable.logo), contentDescription ="Chat Logo Image" )

}
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashActivityPreview() {
    SplashActivityContent()
}