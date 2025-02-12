package com.spravochnic.scbguide

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.defaultComponentContext
import com.spravochnic.scbguide.component.root.DefaultRootComponent
import com.spravochnic.scbguide.content.root.RootContent
import com.spravochnic.scbguide.ui.theme.ScbGuiideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))

        val root =
            DefaultRootComponent(
                componentContext = defaultComponentContext(),
            )

        setContent {
            ScbGuiideTheme {
                RootContent(
                    component = root,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}