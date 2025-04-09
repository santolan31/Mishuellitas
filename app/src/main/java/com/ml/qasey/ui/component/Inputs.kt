package com.ml.qasey.ui.component


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Key
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ml.qasey.ui.theme.DarkBlue
import com.ml.qasey.ui.theme.QaseyTheme
import com.ml.qasey.ui.theme.white


@Composable
fun SimpleinputText(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    LendingICon: ImageVector ? = null,
    onTextchange: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onTextchange (it) },
        label = { Text(text = label) },
        leadingIcon = {
            when {
                LendingICon != null -> {
                    Icon(
                        imageVector =
                        LendingICon,
                        contentDescription = null
                    )
                }
            }

        }

    )

}

@Composable
fun SimpleInputTextPasword(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onTextchange: (String) -> Unit

) {
    var isShowPasword by rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = value, onValueChange = onTextchange,
        label = { Text(text = label) },

        trailingIcon = {
            IconButton(onClick = { isShowPasword = !isShowPasword }) { }
            Icon(
                imageVector = if (isShowPasword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                contentDescription = null
            )
        },
        leadingIcon = { Icon(imageVector = Icons.Outlined.Key, contentDescription = null)},
        visualTransformation = if (isShowPasword) VisualTransformation.None else PasswordVisualTransformation(),
        colors = TextFieldDefaults.colors(
            focusedTextColor = DarkBlue,
            unfocusedTextColor = DarkBlue,
            focusedContainerColor = white,
            focusedIndicatorColor = DarkBlue,
            focusedLabelColor = DarkBlue,
            disabledContainerColor = white,
            unfocusedContainerColor = white


        ),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier




        )

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowUI(){
    QaseyTheme {
        Column(Modifier.fillMaxSize().padding(vertical = 40.dp, horizontal = 40.dp)) { SimpleInputTextPasword(label = "Pasword", value = "123342"){}}
    }
}