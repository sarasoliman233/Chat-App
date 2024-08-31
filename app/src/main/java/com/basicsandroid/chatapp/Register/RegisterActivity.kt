package com.basicsandroid.chatapp.Register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.basicsandroid.chatapp.R
import com.basicsandroid.chatapp.ui.theme.ChatAppTheme
import com.basicsandroid.chatapp.utils.ChatTobBar
import androidx.lifecycle.viewmodel.compose.viewModel
import com.basicsandroid.chatapp.utils.ChatAuthButton
import com.basicsandroid.chatapp.utils.ChatAuthTextField


class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatAppTheme {
   RegisterActivityContent {
    finish()
   }

            }
        }
    }
}

@Composable
fun RegisterActivityContent(viewModel: RegisterViewModel=viewModel(), onBackPressed:()->Unit){
    Scaffold (
        topBar = {
            ChatTobBar(title = stringResource(id = R.string.createAcount)){
                onBackPressed()
            }
        }
    ){

        paddingValues ->
        paddingValues
        Column (modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
        )
        {
          Spacer(modifier = Modifier.fillMaxHeight(.35F))
            ChatAuthTextField(state = viewModel.firstNameState, errorState = viewModel.firstNameErrorState.value, label = stringResource(
                R.string.first_name
            ) )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            ChatAuthTextField(state = viewModel.emailState, errorState = viewModel.emailErrorState.value, label = stringResource(
                R.string.email
            )
            )
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            ChatAuthTextField(state = viewModel.passwordState, errorState = viewModel.passwordErrorState.value, label = stringResource(
                R.string.password
            )
            )
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            ChatAuthButton(title = stringResource(id = R.string.register), modifier = Modifier.padding(horizontal = 16.dp)) {
                
            }

        }
    }

}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterActivityPreview(){
RegisterActivityContent{}
}
