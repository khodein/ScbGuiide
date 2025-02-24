package com.spravochnic.scbguide.uikit.notice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.spravochnic.scbguide.uikit.R
import com.spravochnic.scbguide.uikit.theme.color.Secondary
import com.spravochnic.scbguide.uikit.theme.color.TextPrimaryInverse
import com.spravochnic.scbguide.uikit.theme.style.ExtraBold_16
import com.spravochnic.scbguide.uikit.theme.style.Regular_14

@Composable
fun NoticeItemContent(
    state: NoticeItemComponent.State,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(CircleShape.copy(CornerSize(20.dp)))
            .background(Secondary)
            .padding(top = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Image(
                modifier = Modifier.size(34.dp),
                painter = painterResource(R.drawable.ic_lamp),
                contentDescription = "NoticeItem.Lamp.Icon"
            )
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically),
                textAlign = TextAlign.Start,
                text = state.title,
                style = ExtraBold_16,
                color = TextPrimaryInverse
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, start = 20.dp),
        ) {
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    .padding(bottom = 20.dp),
                textAlign = TextAlign.Start,
                text = state.description,
                style = Regular_14,
                color = TextPrimaryInverse,
            )

            Image(
                modifier = Modifier
                    .height(160.dp)
                    .width(100.dp)
                    .align(Alignment.Bottom),
                painter = painterResource(R.drawable.art_worker),
                contentDescription = "NoticeItem.Description.Art",
            )
        }
    }
}

@Preview
@Composable
internal fun PreviewNoticeItemContent() {
    NoticeItemContent(
        NoticeItemComponent.State(
            title = "Slskdksdklsklsdklsd",
            description = "skdkjsdjkskjsdksjdjksdjksdjksdsjkdjksdjsdk\nsjkdkkjsdkjsdjkslsdlkskdlklsdklsdkldsklsdklsdklsdsdkldsklsdklsdklsdklsdklsdklsdklsdklsdklskdlsdklskldskldskldklsddklklsdklsdklsdklsdklsdklsdklsdklsdklsdksldklsdklsdklsdklsdklsdlksdlksdsdlklksdklsdlksdlksdklsdklsdlksdkldskldskldskldslk"
        )
    )
}