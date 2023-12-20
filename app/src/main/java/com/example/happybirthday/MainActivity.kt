package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        stringResource(R.string.happy_bday_text),
                        stringResource(R.string.sender_info)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(messege: String,sender: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidcake)
    Column(
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.Center,
        ) {


        Text(
            text = messege,
            fontSize = 90.sp,
            lineHeight = 100.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 20.dp)
            )
        Image (
            painter = image,
            contentDescription = null,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally).height(height = 200.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = sender,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun GreetingImage(messege: String,from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)

    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.8F
        )

        GreetingText(
            messege = messege,
            sender = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}


@Preview(
    showBackground = true
    )
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage( stringResource(R.string.happy_bday_text),
            stringResource(R.string.sender_info))
    }
}


