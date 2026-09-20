package com.example.dam_front.config

object ApiConfig {
    // Pour l'émulateur Android, utilisez 10.0.2.2 au lieu de localhost
    // Pour un appareil physique, utilisez l'IP de votre ordinateur (ex: 192.168.1.100)
    // Changez cette valeur selon votre environnement

    const val BASE_URL = "https://sprotifkids.onrender.com/" // Appareil physique (remplacez par votre IP)
    //const val BASE_URL = "http://10.0.2.16:3000/" // Si 10.0.2.2 ne fonctionne pas, essayez cette IP

    // URL pour Socket.IO (même base que l'API REST)
    const val SOCKET_URL = "https://sprotifkids.onrender.com/"

    // AI Configuration
    // ⚠️ Set your Gemini API key in local.properties: GEMINI_API_KEY=your_key_here
    // Then expose it via BuildConfig (see README for setup instructions)
    const val GEMINI_API_KEY = BuildConfig.GEMINI_API_KEY
}


