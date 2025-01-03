package com.geraxiquin.restapi.utils

class Constants {
    companion object {
        private const val URL_API_BASE = "/api"
        private const val URL_API_VERSION = "/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION

        //BASE API endpoint para usuarios
        const val URL_BASE_USUARIOS = "$URL_BASE/usuarios"

        //BASE API endpoint para usuarios
        const val URL_BASE_PACIENTES = "$URL_BASE/pacientes"
    }

}