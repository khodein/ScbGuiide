package com.spravochnic.scbguide.catalog.content

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.spravochnic.scbguide.catalog.CatalogComponent
import com.spravochnic.scbguide.catalog.PreviewCatalogComponent
import com.spravochnic.scbguide.uikit.toolbar.ToolbarContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogContent(
    component: CatalogComponent,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            val toolbarStateValue by component.toolbarStateValue.subscribeAsState()
            ToolbarContent(
                modifier = Modifier.fillMaxWidth(),
                state = toolbarStateValue
            )
        }
    ) { paddings ->
        LazyColumn(
            modifier = Modifier
                .padding(paddings)
                .fillMaxWidth()
        ) {
            items(100) {
                Text(
                    text = "2232 + ${it}",
                    color = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewCatalogContent() {
    CatalogContent(PreviewCatalogComponent())
}