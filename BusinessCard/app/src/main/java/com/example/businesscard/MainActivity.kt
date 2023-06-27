package com.example.businesscard

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DisplayCard()
                }
            }
        }
    }
}

@Composable
fun PersonalSection(
    fullName: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.cdnlogo_com_hpe_png),
            contentDescription = "Hewlett Packard Enterprise",
            contentScale = ContentScale.Fit,
            modifier = Modifier.sizeIn(maxHeight = 150.dp)
        )
        Text(
            text = fullName,
            fontSize = 36.sp,
            lineHeight = 116.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp,
        )
    }

}

@Composable
fun ContactSection() {
    Column() {
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(id = R.drawable.smartphone_black_24dp),
                contentDescription = "smartphone"
            )
            Text(
                text = stringResource(R.string.phone_number)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(id = R.drawable.share_black_24dp),
                contentDescription = "share"
            )
            Text(
                text = stringResource(R.string.social_share)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(id = R.drawable.mail_outline_black_24dp),
                contentDescription = "email"
            )
            Text(
                text = stringResource(R.string.email_contact)
            )
        }
    }
}

@Composable
fun DisplayCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(25.dp)
    ) {
        PersonalSection(
            stringResource(R.string.full_name),
            stringResource(R.string.company_position)
        )
        ContactSection()
    }
}




@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    DisplayCard()
}