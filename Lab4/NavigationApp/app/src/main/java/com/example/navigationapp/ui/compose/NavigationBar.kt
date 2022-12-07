package com.example.navigationapp.ui.compose

import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.navigationapp.R
import com.example.navigationapp.ui.theme.NavigationAppTheme

// referred to https://www.valueof.io/blog/bottom-navigation-in-jetpack-compose

sealed class BottomNavItem(
    val route : String,
    @StringRes val text: Int,
    val icon : ImageVector

)
{
    object Home : BottomNavItem(
        route = NavigationScreen.Home.route,
        text = R.string.home,
        icon =Icons.Filled.Home
    )

    object Search : BottomNavItem(
        route = NavigationScreen.Search.route,
        text = R.string.search,
        icon = Icons.Filled.Search
    )

    object Library : BottomNavItem(
        route = NavigationScreen.Library.route,
        text = R.string.library,
        icon = Icons.Filled.List
    )

}


@Composable
fun BottomNavigationBar(navController: NavController){

    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Library
    )

    BottomNavigation()
    {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val selectedItem = navBackStackEntry?.destination?.route

        items.forEach {item ->
                BottomNavigationItem(
                    icon = { Icon(imageVector = item.icon, contentDescription = null)},
                    label = { Text(text = stringResource(id = item.text))},
                    selected = selectedItem == item.route,
                    onClick = { navController.navigate(item.route) {

                        launchSingleTop = true
                        restoreState = true

                    }
                    }
                )


            }
        }


}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationAppTheme {

    }
}