package com.example.mememach

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform