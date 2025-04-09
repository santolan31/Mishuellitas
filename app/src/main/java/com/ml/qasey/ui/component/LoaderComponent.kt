package com.ml.qasey.ui.component

import android.widget.ProgressBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.ml.qasey.ui.theme.DarkBlue

@Composable

fun loader(modifier: Modifier = Modifier ) {
    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(Color(0x80FFFFFF))
        .pointerInput(Unit) {}
        .zIndex(2f)) {

        val progressBar = createRef()

        CircularProgressIndicator(modifier = Modifier.constrainAs(progressBar) {
        top.linkTo(parent.top)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom)

        },
         color = DarkBlue
            )
    }

}

