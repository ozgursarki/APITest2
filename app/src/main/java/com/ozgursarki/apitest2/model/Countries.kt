package com.ozgursarki.apitest2.model

sealed class Countries(){
    class Flags(
        val flags: com.ozgursarki.apitest2.model.Flags
    ): Countries()

    class CountryName(
        val name : Name
    ) : Countries()
}