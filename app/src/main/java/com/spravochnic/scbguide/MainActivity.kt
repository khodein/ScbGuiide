package com.spravochnic.scbguide

import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.ActivityInfo
import android.graphics.Color
import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.spravochnic.scbguide.component.root.DefaultRootComponent
import com.spravochnic.scbguide.content.root.RootContent
import com.spravochnic.scbguide.ui.theme.ScbGuiideTheme
import com.spravochnic.scbguide.utils.ResManagerImpl

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

        enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))

        val rootComponent =
            DefaultRootComponent(
                componentContext = defaultComponentContext(),
                resManager = ResManagerImpl(context = this)
            )

        setContent {
            ScbGuiideTheme {
                RootContent(
                    component = rootComponent,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}