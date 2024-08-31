package com.basicsandroid.chatapp.utils
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basicsandroid.chatapp.R
import com.basicsandroid.chatapp.ui.theme.cyne


@Composable
fun ChatAuthButton(modifier : Modifier=Modifier,title:String,onButtonClick:()->Unit){
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = cyne),
        shape = RoundedCornerShape(6.dp),
        contentPadding = PaddingValues(vertical = 19.dp, horizontal = 22.dp),
        onClick = {onButtonClick()},
        modifier = modifier) {
        Spacer(modifier = Modifier.weight(.05F))
        Text(text = title , fontSize = 15.sp, fontFamily = FontFamily(Font(R.font.semibold)))
        Spacer(modifier = Modifier.weight(1F))
        Image(painter = painterResource(id = R.drawable.arrow_icon), contentDescription ="" ,Modifier.size(22.dp))
        Spacer(modifier = Modifier.weight(.05F))



    }
}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ChatAuthButtonPreview(){
    ChatAuthButton(title = "Login", modifier = Modifier) {
        
    }
}