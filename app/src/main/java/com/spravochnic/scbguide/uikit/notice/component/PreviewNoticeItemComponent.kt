package com.spravochnic.scbguide.uikit.notice.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.spravochnic.scbguide.utils.preview.PreviewComponentContext

class PreviewNoticeItemComponent
    : NoticeItemComponent,
    ComponentContext by PreviewComponentContext {

    override val stateValue: Value<NoticeItemComponent.State> = MutableValue(
        NoticeItemComponent.State(
            title = "Slskdksdklsklsdklsd",
            description = "skdkjsdjkskjsdksjdjksdjksdjksdsjkdjksdjsdk\nsjkdkkjsdkjsdjkslsdlkskdlklsdklsdkldsklsdklsdklsdsdkldsklsdklsdklsdklsdklsdklsdklsdklsdklskdlsdklskldskldskldklsddklklsdklsdklsdklsdklsdklsdklsdklsdklsdksldklsdklsdklsdklsdklsdlksdlksdsdlklksdklsdlksdlksdklsdklsdlksdkldskldskldskldslk"
        )
    )
}