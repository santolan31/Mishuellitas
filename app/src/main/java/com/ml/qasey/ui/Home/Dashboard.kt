package com.ml.qasey.ui.Home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ml.qasey.R
import com.ml.qasey.ui.component.PetsCard
import com.ml.qasey.ui.component.longCard
import com.ml.qasey.ui.component.principalCard
import com.ml.qasey.ui.theme.QaseyTheme

@Composable
fun dashBoardScreen(modifier: Modifier = Modifier){
Scaffold {
    ConstraintLayout(modifier = Modifier.fillMaxSize().padding(it)) {

        val (firstCard, longCard) = createRefs()

        principalCard(modifier = Modifier.constrainAs(firstCard){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        },
            imageVector = R.drawable.pet_img,
            description = "First Card",

            )
        longCard(modifier = Modifier.padding(10.dp).fillMaxWidth().constrainAs(longCard){
            top.linkTo(firstCard.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        },
        Telefono = "3178219110", Direccion = "Calle 127 A N 51 A"

        )



    }
}

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun previewDashBoardScreen() {
    QaseyTheme {
        dashBoardScreen()
    }
}
