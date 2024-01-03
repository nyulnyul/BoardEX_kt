package com.example.board.domain.util

sealed class PostOrder(val orderType: OrderType) {
    class Title(orderType: OrderType) : PostOrder(orderType)
    class Date(orderType: OrderType) : PostOrder(orderType)
    class content(orderType: OrderType) : PostOrder(orderType)
    class arthur(orderType: OrderType) : PostOrder(orderType)
}