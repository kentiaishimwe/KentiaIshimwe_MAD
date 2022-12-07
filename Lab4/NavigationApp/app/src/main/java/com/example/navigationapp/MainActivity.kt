package com.example.navigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationapp.ui.screens.HomeScreen
import com.example.navigationapp.ui.screens.LibraryScreen
import com.example.navigationapp.ui.screens.SearchScreen
import com.example.navigationapp.ui.compose.BottomNavItem
import com.example.navigationapp.ui.compose.BottomNavigationBar
import com.example.navigationapp.ui.theme.NavigationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    Scaffold(
                        bottomBar = { BottomNavigationBar(navController)}
                    ) {
                        ScreenSetup(navController = navController)
                    }


                }
            }
        }
    }
}



@Composable
fun ScreenSetup(navController: NavHostController) {
//    BottomNavigationBar(navController = NavHostController)
//
//    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {

        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }

        composable(BottomNavItem.Search.route) {
            SearchScreen()
        }

        composable(BottomNavItem.Library.route) {

            LibraryScreen()
        }


    }

}

