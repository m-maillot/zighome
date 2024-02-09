package com.example.zighome

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform