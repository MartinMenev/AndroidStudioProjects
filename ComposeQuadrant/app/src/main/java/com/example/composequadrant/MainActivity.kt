package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen(
                        stringResource(R.string.text_name1),
                        stringResource(R.string.displays_description1),
                        stringResource(R.string.text_name2),
                        stringResource(R.string.displays_description2),
                        stringResource(R.string.text_name3),
                        stringResource(R.string.displays_description3),
                        stringResource(R.string.text_name4),
                        stringResource(R.string.displays_description4)
                    )
                }
            }
        }
    }
}

@Composable
fun Quandrant(name: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = name,
            modifier = modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = description,
            modifier = modifier
        )
    }
}

@Composable
fun Screen(
    name1: String, description1: String,
    name2: String, description2: String,
    name3: String, description3: String,
    name4: String, description4: String,
) {
    Row {
        Column () {
            Quandrant(name1, description1)
            Quandrant(name2, description2)
        }
        Column {
            Quandrant(name3, description3)
            Quandrant(name4, description4)
        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        Screen(
            stringResource(R.string.text_name1),
            stringResource(R.string.displays_description1),
            stringResource(R.string.text_name2),
            stringResource(R.string.displays_description2),
            stringResource(R.string.text_name3),
            stringResource(R.string.displays_description3),
            stringResource(R.string.text_name4),
            stringResource(R.string.displays_description4)
        )
    }
}