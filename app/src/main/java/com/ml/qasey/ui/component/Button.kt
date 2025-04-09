package com.ml.qasey.ui.component

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.ml.qasey.ui.theme.DarkBlue

import com.ml.qasey.ui.theme.white

@Composable

fun PrymaryButton(
    modifier: Modifier,
    text: String,
    onClickAction : () -> Unit
){

  Button(onClick = {
      onClickAction()
  },
  modifier = modifier,
     colors = ButtonDefaults.buttonColors(
         containerColor = DarkBlue,
         contentColor = white
     )
  ) {
      Text(text = text, fontWeight = FontWeight.Bold)
  }

}


