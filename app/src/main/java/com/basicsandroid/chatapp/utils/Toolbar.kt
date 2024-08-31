package com.basicsandroid.chatapp.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basicsandroid.chatapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTobBar(title:String,onNavigationClick:(()->Unit)?=null){
    TopAppBar(
        navigationIcon = {
            if (onNavigationClick!=null) {
       Image(painter = painterResource(id = R.drawable.icon_back), contentDescription = ""
       , modifier = Modifier
           .padding(start = 16.dp)
               .clickable {
                   onNavigationClick()
               })


            }
        },
        title = { Text(text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.poppins)),
         modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    , color = Color.White)}, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent))
}

  @Preview
  @Composable
fun ChatTobBarPreview() {
    ChatTobBar(title = "jj")
}