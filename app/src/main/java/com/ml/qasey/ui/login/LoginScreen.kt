package com.ml.qasey.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ml.qasey.R
import com.ml.qasey.ui.Home.dashBoardScreen
import com.ml.qasey.ui.component.PrymaryButton
import com.ml.qasey.ui.component.SimpleInputTextPasword
import com.ml.qasey.ui.component.SimpleinputText
import com.ml.qasey.ui.component.loader
import com.ml.qasey.ui.navigation.Register
import com.ml.qasey.ui.navigation.DashBoard
import com.ml.qasey.ui.navigation.Login
import com.ml.qasey.ui.theme.QaseyTheme

@Composable
fun LoginRoute(
    navController: NavController,
    viewmodel: LoginViewmodel = hiltViewModel()
) {
    val uiState by viewmodel.uiState.collectAsState()

    when {

        uiState.isloading -> {
            loader()
        }
        uiState.showDialog ->{
            AlertDialog(
                onDismissRequest ={viewmodel.onUpdateShowDialog(false) },
                title = { Text("Error de autenticacion")},
                text = { Text("Correo o contraseña incorrecto")},
                confirmButton = {
                    Button(onClick = {viewmodel.onUpdateShowDialog(false)}) {
                        Text("Aceptar")

                    }
                }

            )
            LoginScreen(uiState) {
                navController.navigate(Login)

            }
        }
    }





}

@Composable
fun LoginScreen(

    uiState: LoginUiState,
    onNavigate: (Any) -> Unit,
) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(brush = Brush.verticalGradient(colors = listOf(

                    Color(0xFFDA7DD8),
                    Color(0xFFF28AB9),
                    Color(0xFFFF8A80)
                )))
        ) {
            LoginBody(
                modifier = Modifier,
                uiState

            ){
                onNavigate(it)

            }


        }
    }
}

@Composable
fun LoginBody(
    modifier: Modifier = Modifier,
    uiState: LoginUiState,
    viewmodel: LoginViewmodel = hiltViewModel(),
    onNavigate: (Any) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFDA7DD8),
                        Color(0xFFF28AB9),
                        Color(0xFFFF8A80)
                    )
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Image(
                painter = painterResource(id = R.drawable.pet_img),
                contentDescription = null,
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.White)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Iniciar Sesión",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(16.dp))

                SimpleinputText(
                    label = "Correo",
                    value = uiState.userName,
                    LendingICon = Icons.Default.Email,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    viewmodel.updateUsernameValue(it)
                }

                Spacer(modifier = Modifier.height(12.dp))

                SimpleInputTextPasword(
                    label = "Contraseña",
                    value = uiState.passWord,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    viewmodel.updatePassword(it)
                }

                Spacer(modifier = Modifier.height(16.dp))

                PrymaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Ingresar"
                ) {
                    viewmodel.login()
                    viewmodel.Loginfirebase {
                        onNavigate(DashBoard)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text("¿No tienes una cuenta?", fontWeight = FontWeight.SemiBold)

            Text(
                text = "REGISTRATE",
                color = Color(0xFFDA7DD8),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable {
                    onNavigate(Register)
                }


            )
        }
    }
}


