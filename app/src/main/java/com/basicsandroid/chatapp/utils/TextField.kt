package com.basicsandroid.chatapp.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.basicsandroid.chatapp.R
import com.basicsandroid.chatapp.ui.theme.cyne
import com.basicsandroid.chatapp.ui.theme.darkGrey
import com.basicsandroid.chatapp.ui.theme.grey

@Composable
fun ChatAuthTextField(state:MutableState<String>,errorState:String?,label:String,isPassword:Boolean=false){
    Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        TextField(value =state.value , onValueChange ={newText->
            state.value=newText

        }, colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            errorContainerColor = Color.Transparent,
            focusedIndicatorColor = cyne,
            unfocusedIndicatorColor = grey,
            errorIndicatorColor = Color.Red,
            focusedLabelColor = darkGrey,
            unfocusedLabelColor = darkGrey
        ),
            keyboardOptions =if (isPassword) KeyboardOptions(keyboardType = KeyboardType.Password) else KeyboardOptions(),
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth(.9F),
            label={
                Text(text = label, fontFamily = FontFamily(Font(R.font.light)))
            })
        if (errorState !==null && errorState.isNotEmpty()){
            Text(text = errorState, color = Color.Red, fontSize = 20.sp)

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ChatAuthTextFieldPreview(){
    val email= remember {
        mutableStateOf("mohamed@gmail.com")
    }
    ChatAuthTextField(email ,"","")
}