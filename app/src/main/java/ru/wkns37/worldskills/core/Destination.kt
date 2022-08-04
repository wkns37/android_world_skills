package ru.wkns37.worldskills.core

abstract class Destination(val route: String) {

    abstract class Bottom(route: String, val icon: Int) : Destination(route)
}