package com.ml.qasey.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ml.qasey.R

@Composable
fun principalCard(modifier: Modifier,imageVector: Int, description: String){

Card(shape = RoundedCornerShape(16.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 9.dp),
    modifier = modifier.width(160.dp)
        .wrapContentWidth()
    ) {

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.background(Color.White)) {

        Image(
            painter = painterResource(id = imageVector),
            contentDescription = description,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(140.dp)
                .fillMaxWidth()
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
    }

}

}

@Composable
fun PetsCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(160.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFEAF0D9)) // Fondo similar al de la imagen
            .padding(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF5F5F5)), // Color claro neutro
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.pet_img), // Reemplaza con tu imagen
                contentDescription = "Dog",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 4.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.pet_img), // Reemplaza con tu imagen
                contentDescription = "Cat",
                modifier = Modifier
                    .size(64.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Tus mascotas",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun longCard(modifier: Modifier, Telefono:String, Direccion:String) {
    Card(modifier = modifier.fillMaxWidth().height(125.dp).clip(RoundedCornerShape(16.dp)), colors = CardDefaults.cardColors(containerColor = Color.White), elevation = CardDefaults.cardElevation(10.dp) ) {

        ConstraintLayout(Modifier.fillMaxWidth()) {

            val (image, layoutInfo) = createRefs()

            Image(painter = painterResource(R.drawable.pet_img), contentDescription = null, Modifier.width(153.dp).constrainAs(image){
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)

            })

            Column(Modifier.constrainAs(layoutInfo){
                start.linkTo(image.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }) {
             Row(horizontalArrangement = Arrangement.SpaceBetween,) {

                 Text("Telefono", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                 Spacer(Modifier.width(100.dp))
                 Icon(imageVector = Icons.Outlined.Favorite, contentDescription = null, tint = Color.Red) }

                Text(Telefono, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                Text("Direccion", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)
                Text(Direccion, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold)


            }
        }
    }

}