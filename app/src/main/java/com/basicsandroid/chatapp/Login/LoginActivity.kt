package com.basicsandroid.chatapp.Login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.basicsandroid.chatapp.HomeActivity
import com.basicsandroid.chatapp.R
import com.basicsandroid.chatapp.Register.RegisterActivity
import com.basicsandroid.chatapp.ui.theme.ChatAppTheme
import com.basicsandroid.chatapp.ui.theme.black2
import com.basicsandroid.chatapp.ui.theme.textColor
import com.basicsandroid.chatapp.utils.ChatAuthButton
import com.basicsandroid.chatapp.utils.ChatAuthTextField
import com.basicsandroid.chatapp.utils.ChatTobBar

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
                // A surface container using the 'background' color from the theme
LoginScreenContent()
            }
        }
    }
}

@Composable
fun LoginScreenContent(viewModel: LoginViewModel= viewModel()){
    Scaffold(topBar = { ChatTobBar( stringResource(R.string.login)) },
        modifier = Modifier.paint(painter = painterResource(id = R.drawable.background))){ PaddingValues ->
        PaddingValues
        Column(modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )) {
            Spacer(modifier = Modifier.fillMaxHeight(.35F))
            Text(text = "Welcome back!",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 15.dp),
                color = textColor,
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.poppins))
            )
            ChatAuthTextField(state =viewModel.emailState, errorState = viewModel.emailErrorState.value,"Email" )
            Spacer(modifier = Modifier.padding(vertical = 9.dp))
            ChatAuthTextField(state =viewModel.passwordState, errorState = viewModel.passwordErrorState.value,"Password" , isPassword = true)
            Spacer(modifier = Modifier.padding(10.dp))
            ChatAuthButton(
                modifier = Modifier
                    .fillMaxWidth(.9F)
                    .align(Alignment.CenterHorizontally)
                ,title ="Login",
                onButtonClick = {})

            TextButton(onClick = {

              viewModel.navigateToRegistration()

            }, modifier = Modifier.padding(horizontal = 16.dp, vertical = 25.dp)) {
                Text(text = "Or Create My Account",
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.light)),
                    color = black2)
            }

        }

    }
    TriggerEvents(event = viewModel.events.value)

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
LoginScreenContent()
}

@Composable
fun TriggerEvents(event: LoginViewEvent,viewModel:LoginViewModel= viewModel()){
    when (event){
         LoginViewEvent.Idle->{}
        is LoginViewEvent.NavigateToRegistration->{
            val context= LocalContext.current
            LaunchedEffect(Unit) {
                val intent=Intent(context, RegisterActivity::class.java)
                context.startActivity(intent)
                viewModel.events.value=LoginViewEvent.Idle
            }

        }
        is LoginViewEvent.NavigateToHome -> {
            val context= LocalContext.current
            val intent=Intent(context,HomeActivity::class.java)
            context.startActivity(intent)
            viewModel.events.value=LoginViewEvent.Idle
        }
    }

}