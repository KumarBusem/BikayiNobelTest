package com.busem.data.models

data class Prize(
    val year: String,
    val category: String,
    val laureates: List<Person>
)
