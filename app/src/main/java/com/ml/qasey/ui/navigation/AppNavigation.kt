package com.ml.qasey.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ml.qasey.ui.Home.dashBoardScreen
import com.ml.qasey.ui.Register.reGisterScreen
import com.ml.qasey.ui.login.LoginRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginRoute(navController)
        }
      composable<DashBoard> {
          dashBoardScreen()
      }

      composable<Register> {
            reGisterScreen()
      }
    }
}