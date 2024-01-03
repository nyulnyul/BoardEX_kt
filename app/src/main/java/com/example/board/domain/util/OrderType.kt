package com.example.board.domain.util

abstract class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()

}