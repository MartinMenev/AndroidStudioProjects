package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     Article(
                        stringResource(R.string.article_title),
                        stringResource(R.string.first_paragraph),
                        stringResource(R.string.second_paragraph),
                     )
                }
            }
        }
    }
}

@Composable
fun Article (
    title: String,
    paragraph1: String,
    paragraph2: String,
    modifier: Modifier = Modifier
) {
    Column() {
        Image()
        Text(
            text = title,
            modifier = modifier
        )
        Text(
            text = paragraph1,
            modifier = modifier
        )
        Text(
            text = paragraph2,
            modifier = modifier
        )
    }
}

@Composable
fun Image() {
    Image(
        painter = painterResource(R.drawable.bg_compose_background),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        alpha = 0.5F
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        Article(
            stringResource(R.string.article_title),
            stringResource(R.string.first_paragraph),
            stringResource(R.string.second_paragraph),
        )
    }
}