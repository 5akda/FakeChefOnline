package iam5akda.fakechef.core.util

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Pixel 3 Day", device = Devices.PIXEL_3, uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Pixel 3 Night", device = Devices.PIXEL_3, uiMode = UI_MODE_NIGHT_YES)
annotation class PhonePreviewDayAndNight