package com.spravochnic.scbguide.content.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.spravochnic.scbguide.component.home.HomeComponent
import com.spravochnic.scbguide.component.home.PreviewHomeComponent

@Composable
fun HomeContent(
    component: HomeComponent,
    modifier: Modifier = Modifier
) {

}

@Preview
@Composable
internal fun HomeContentPreview() {
    HomeContent(PreviewHomeComponent())
}