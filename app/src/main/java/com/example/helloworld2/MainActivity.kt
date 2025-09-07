package com.example.helloworld2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworld2.ui.theme.HelloWorld2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorld2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding), // Apply padding from Scaffold
                    ) {
                        Greeting(
                            name = "Wyatt",
                            modifier = Modifier.padding(innerPadding)
                        )
                        ShowEmailButton(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Greeting(name: String = "World", modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ShowEmailButton(modifier: Modifier = Modifier) {
    var emailText by remember { mutableStateOf(value = "") }
    Column {
        Button({ emailText = fetchEmail() }, content = { Text("Show Email") })
        if (emailText.isNotEmpty()) {
            Text("Email: $emailText", modifier = modifier)
        }
    }
}

fun fetchEmail(): String {
    return "wnapier@bu.edu"
}