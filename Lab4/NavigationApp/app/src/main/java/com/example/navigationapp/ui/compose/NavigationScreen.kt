package com.example.navigationapp.ui.compose

sealed class NavigationScreen (val route : String)
{
    object Home : NavigationScreen("home")
    object Search : NavigationScreen("search")
    object Library : NavigationScreen("library")
}