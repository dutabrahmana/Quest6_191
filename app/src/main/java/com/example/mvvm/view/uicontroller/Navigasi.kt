package com.example.mvvm.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvm.view.FormIsian
import com.example.mvvm.view.TampilData

enum class Navigation {
    FormulirKu,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigation.FormulirKu.name,
            modifier = Modifier.padding(paddingValues = isiRuang)
        ) {
            composable(route = Navigation.FormulirKu.name) {
                FormIsian(
                    OnSubmitBtnClick = {
                        navController.navigate(route = Navigation.Detail.name)
                    }
                )
            }
            composable(route = Navigation.Detail.name) {
                TampilData(
                    onBackBtnClick = {
                        cancelAndBackToFormulirKu(navController)
                    }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulirKu(
    navController: NavHostController
) {
    navController.popBackStack(
        route = Navigation.FormulirKu.name,
        inclusive = false
    )
}