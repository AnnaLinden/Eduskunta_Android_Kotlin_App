package com.example.eduskunta_feedback_app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.eduskunta_feedback_app.ui.screens.MPDetailScreen
import com.example.eduskunta_feedback_app.ui.screens.MPListScreen
import com.example.eduskunta_feedback_app.ui.screens.PartyListScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "party_list") {
        composable("party_list") {
            PartyListScreen(navController)
        }
        composable(
            "mp_list/{party}",
            arguments = listOf(navArgument("party") { type = NavType.StringType })
        ) { backStackEntry ->
            val party = backStackEntry.arguments?.getString("party") ?: ""
            MPListScreen(navController, party)
        }
        composable(
            "mp_detail/{mpId}",
            arguments = listOf(navArgument("mpId") { type = NavType.IntType })
        ) { backStackEntry ->
            val mpId = backStackEntry.arguments?.getInt("mpId") ?: 0
            MPDetailScreen(mpId)
        }
    }
}