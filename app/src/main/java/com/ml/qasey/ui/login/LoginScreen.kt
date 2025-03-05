package com.ml.qasey.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ml.qasey.R
import com.ml.qasey.ui.theme.QaseyTheme

@Composable
fun LoginRoute() {

}

@Composable
fun LoginScreen() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LoginBody(modifier = Modifier)
        }
    }
}

@Composable
fun LoginBody(modifier: Modifier) {
    ConstraintLayout(
        modifier.fillMaxSize()
    ) {
        val (imageCustomer) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.img_customer),
            contentDescription = null,
            modifier = Modifier.size(300.dp).constrainAs(imageCustomer) {
                top.linkTo(parent.top, 60.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    QaseyTheme {
        LoginScreen()
    }
}