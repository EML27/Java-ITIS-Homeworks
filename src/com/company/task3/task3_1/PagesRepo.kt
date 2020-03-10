package com.company.task3.task3_1

import java.util.*

//some kotlin here
object PagesRepo : LinkedList<Page>() {
    init {
        addNewPage("home", listOf("shop", "contacts", "api"))
        addNewPage("shop", listOf("home", "order"))
        addNewPage("contacts", listOf("home"))
        addNewPage("api", listOf("home", "contacts"))
        addNewPage("order", listOf("home"))
    }

    fun getPageByName(str: String): Page {
        for (x: Page in this) {
            if (x.name == str) {
                return x
            }
        }
        throw IllegalArgumentException()
    }

    private fun addNewPage(name: String, list: List<String>) {
        add(Page(name, list as LinkedList<String>))
    }
}
