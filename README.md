# SportKids
> 📱 **Sporty Kids – Application Mobile Android Frontend (Kotlin / Jetpack Compose)**

[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-purple.svg?style=flat&logo=kotlin)](https://kotlinlang.org)
[![Android SDK](https://img.shields.io/badge/Android%20SDK-24%20--%2034-brightgreen.svg?style=flat&logo=android)](https://developer.android.com)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose%20%2F%20Material%203-blue.svg?style=flat&logo=jetpackcompose)](https://developer.android.com/jetpack/compose)
[![Architecture](https://img.shields.io/badge/Architecture-MVVM%20Clean%20Code-orange.svg?style=flat)](#architecture)
[![Stripe](https://img.shields.io/badge/Payment-Stripe%20SDK-635bff.svg?style=flat&logo=stripe)](https://stripe.com)
[![Firebase](https://img.shields.io/badge/Cloud-Firebase-ffca28.svg?style=flat&logo=firebase)](https://firebase.google.com)
[![Gemini](https://img.shields.io/badge/AI-Google%20Gemini%20SDK-8e75ff.svg?style=flat&logo=googlegemini)](https://ai.google.dev)

**Sporty Kids** est une application mobile native développée en **Kotlin** sous **Android Studio**, dédiée à la gestion moderne, centralisée et simplifiée d’une académie sportive pour enfants. 

Elle offre une expérience utilisateur fluide et intuitive pour les différents acteurs de l'académie : **parents, enfants, entraîneurs et administrateurs**, en intégrant le suivi d'entraînement, la gestion des tournois, le paiement en ligne sécurisé et l'assistance intelligente par IA.

---

## 🎯 Objectif de l'Application

Faciliter la gestion quotidienne et l'organisation globale d'une académie sportive grâce à une plateforme mobile complète permettant :
- Une administration dématérialisée et sans friction des inscriptions et cotisations.
- Un accompagnement pédagogique et sportif rigoureux de chaque enfant.
- Une communication fluide et instantanée entre les coachs et les parents.
- Une visibilité en temps réel sur les plannings, les tournois et les événements sportifs.

---

## ✨ Fonctionnalités Principales

### 🏆 Gestion des Tournois & Compétitions
- **Création et Programmation** : Organisation des tournois, définition des catégories d'âge, règles et dates de match.
- **Affichage Dynamique** : Consultation des tournois à venir, en cours et terminés avec filtres par discipline sportive.
- **Gestion des Participations** : Inscription des enfants, validation des listes d'équipes et des compositions.
- **Détails & Suivi en Direct** : Scores, classements, statistiques de match et calendriers des rencontres.

### 👶 Suivi Pédagogique & Profils Enfants
- **Fiches Enfants Détaillées** : Informations personnelles, historique médical/sportif, catégorie et progression.
- **Suivi des Performances** : Évaluation des compétences motrices et techniques acquises, présences aux entraînements.
- **Communication avec le Coach** : Échanges directs, retours individualisés et consignes spécifiques d'entraînement.
- **Attribution aux Activités** : Affectation personnalisée de chaque enfant aux groupes et disciplines adaptés.

### ⚽ Gestion des Activités Sportives & Entraînements
- **Catalogue des Activités** : Liste complète des disciplines proposées (Football, Basketball, Natation, Tennis, Gymnastique, etc.).
- **Plannings Hebdomadaires** : Horaires des séances, terrains assignés et coachs référents.
- **Gestion des Disponibilités & Présences** : Pointage numérique en début de séance par les entraîneurs.

### 💳 Paiements & Abonnements Sécurisés
- **Paiement In-App (Stripe)** : Règlement sécurisé des cotisations, stages et activités via carte bancaire.
- **Historique des Transactions** : Suivi transparent de tous les paiements effectués avec reçus numériques.
- **Gestion des Forfaits & Abonnements** : Alertes automatiques de renouvellement et suivi du statut des paiements.

### 💬 Communication & Notifications Temps Réel
- **Messagerie & Chat** : Messagerie instantanée intégrée via WebSockets / Socket.IO pour les échanges coachs-parents.
- **Notifications Push (Firebase Cloud Messaging)** : Alertes instantanées pour les annonces importantes, changements d'horaire ou rappels de tournoi.

### 🤖 Assistant Intelligent (Google Gemini AI)
- **Conseils Personnalisés** : Suggestions d'exercices, d'échauffements et de plans nutritionnels adaptés aux enfants grâce au SDK Gemini.
- **Support Interactif** : Assistant conversationnel capable de répondre aux questions courantes sur l'académie et la pratique sportive.

### 🗺️ Géolocalisation & Cartes (OSMDroid)
- **Localisation des Terrains & Événements** : Affichage interactif OpenStreetMap des infrastructures sportives et lieux de compétition.

### 📲 Widget Écran d'Accueil (Jetpack Glance)
- **Accès Rapide** : Widget Android Material 3 affichant directement sur l'écran d'accueil les prochains entraînements et alertes urgentes.

---

## 🏗️ Architecture Logicielle

L'application repose sur le pattern architectural **MVVM (Model - View - ViewModel)** conforme aux recommandations officielles de Google (Android Architecture Components) et respectant les principes du Clean Architecture :

```
┌─────────────────────────────────────────────────────────────┐
│                       UI LAYER                              │
│  - Jetpack Compose Screens & Reusable Components            │
│  - Material 3 Design System & Theme                         │
│  - Navigation Compose                                       │
└──────────────────────────────┬──────────────────────────────┘
                               │ Observes UI State (StateFlow)
                               ▼
┌─────────────────────────────────────────────────────────────┐
│                    VIEWMODEL LAYER                          │
│  - TournamentsViewModel, ActivitiesViewModel                │
│  - AuthViewModel, PaymentViewModel, ChildrenViewModel       │
│  - Coroutines & CoroutineScope management                   │
└──────────────────────────────┬──────────────────────────────┘
                               │ Calls methods
                               ▼
┌─────────────────────────────────────────────────────────────┐
│                   REPOSITORY LAYER                          │
│  - TournamentsRepository, PaymentRepository, UserRepository │
│  - Abstraction de la source de données                      │
└──────────────┬──────────────────────────────┬───────────────┘
               │                              │
               ▼                              ▼
┌──────────────────────────────┐ ┌────────────────────────────┐
│      NETWORK (REMOTE)        │ │        LOCAL DATA          │
│  - Retrofit / OkHttp Client  │ │  - DataStore Preferences   │
│  - Socket.IO (Realtime)      │ │  - Token & Session Cache   │
│  - Firebase Auth / FCM       │ │  - Offline State Cache     │
└──────────────────────────────┘ └────────────────────────────┘
```

---

## 🛠️ Stack Technique

| Domaine | Technologie / Bibliothèque | Description |
|---|---|---|
| **Langage** | [Kotlin 2.0.21](https://kotlinlang.org/) | Langage moderne, concis et sécurisé |
| **Framework UI** | [Jetpack Compose (BOM 2024.10)](https://developer.android.com/jetpack/compose) | Interface déclarative réactive |
| **Design System** | [Material 3](https://m3.material.io/) | Composants modernes et charte graphique dynamique |
| **Navigation** | [Navigation Compose 2.7.7](https://developer.android.com/guide/navigation) | Gestion du graphe de navigation Compose |
| **Asynchronisme** | [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & Flow | Gestion asynchrone non-bloquante |
| **Réseau HTTP** | [Retrofit 2.9.0](https://square.github.io/retrofit/) + [OkHttp 4.12.0](https://square.github.io/okhttp/) | Consommation des API REST avec Logging Interceptor |
| **Sérialisation** | [Gson 2.11.0](https://github.com/google/gson) | Conversion JSON ↔ Modèles Kotlin |
| **Temps Réel** | [Socket.IO Client 2.0.1](https://socket.io/) | Communication bidirectionnelle en temps réel |
| **Paiement** | [Stripe Android SDK 21.5.0](https://stripe.com/docs/android) | Paiements par carte et composants sécurisés |
| **Intelligence Artificielle** | [Google Generative AI SDK 0.9.0](https://ai.google.dev/) | Intégration Gemini pour conseils sportifs |
| **Services Cloud** | [Firebase BOM 32.7.0](https://firebase.google.com/) | Auth, Cloud Messaging (FCM), Firestore |
| **Cartographie** | [OSMDroid 6.1.16](https://github.com/osmdroid/osmdroid) | Affichage de cartes OpenStreetMap libres |
| **Chargement d'Images** | [Coil Compose 2.6.0](https://coil-kt.github.io/coil/compose/) | Chargement et mise en cache asynchrone des médias |
| **Widgets** | [Jetpack Glance Material 3](https://developer.android.com/jetpack/compose/glance) | Widgets Android pour l'écran d'accueil |
| **Stockage Local** | [DataStore Preferences 1.0.0](https://developer.android.com/topic/libraries/architecture/datastore) | Stockage sécurisé des clés et sessions utilisateur |

---

## 📂 Structure du Projet

```text
app/src/main/java/com/example/dam_front/
├── DamApplication.kt          # Classe d'application globale (initialisations Firebase, Stripe, etc.)
├── MainActivity.kt            # Point d'entrée principal avec configuration Compose Navigation
├── api/                       # Définition des interfaces Retrofit (Auth, Tournois, Activités, etc.)
├── network/                   # Client HTTP, intercepteurs JWT, configuration Retrofit & Socket.IO
├── repository/                # Repositories orchestrant les appels réseau et le cache local
├── viewmodels/                # ViewModels MVVM gérant l'état UI et les cas d'usage métier
├── models/                    # Data classes Kotlin (User, Child, Tournament, Payment, Activity, etc.)
├── ui/
│   ├── screens/               # Écrans Compose (Tournois, Profils, Activités, Paiement, Chat, etc.)
│   ├── components/            # Composants graphiques réutilisables (Boutons, Cartes, Dialogs, etc.)
│   ├── navigation/            # Routes, graph d'écrans et BottomNavigationBar
│   ├── theme/                 # Charte graphique (Couleurs, Typographie, Shapes Material 3)
│   └── map/                   # Composants d'intégration de la carte OSMDroid
├── services/                  # Services Android en arrière-plan (FirebaseMessagingService, etc.)
├── utils/                     # Fonctions d'extension, constantes, formateurs de date/monnaie
└── widget/                    # Implémentation du widget écran d'accueil avec Jetpack Glance
```

---

## 🚀 Installation & Lancement

### Prérequis
- **Android Studio** : Koala, Ladybug ou version plus récente
- **JDK** : Version 17 (Java 17 requis pour Gradle et Android Gradle Plugin 8+)
- **Android SDK** : 
  - `compileSdk` : 34
  - `minSdk` : 24 (Android 7.0 Nougat ou supérieur)
  - `targetSdk` : 34 (Android 14)
- **Émulateur Android ou Appareil physique** : avec les Google Play Services activés

### Étapes de Configuration

1. **Cloner le dépôt et basculer sur la branche frontend** :
   ```bash
   git clone -b frontend-android https://github.com/hadilaroua/SportKids.git
   cd SportKids
   ```

2. **Configuration des Services Google & Firebase** :
   - Assurez-vous que le fichier `google-services.json` est présent dans le dossier `app/`.
   - Ce fichier contient la configuration de votre projet Firebase (Auth, Notifications FCM).

3. **Configuration de l'URL du Backend** :
   - Ouvrez le fichier de configuration réseau (ex. `com/example/dam_front/network/RetrofitClient.kt` ou `ApiConstants.kt`).
   - Adaptez l'adresse IP de base :
     - Pour un émulateur Android officiel : `http://10.0.2.2:3000/`
     - Pour un appareil physique sur le même réseau Wi-Fi : `http://<VOTRE_IP_LOCALE>:3000/`

4. **Synchronisation du projet** :
   - Ouvrez le projet dans Android Studio.
   - Cliquez sur **File > Sync Project with Gradle Files**.

5. **Exécution de l'application** :
   - Sélectionnez un émulateur ou votre appareil cible.
   - Cliquez sur **Run 'app'** (`Shift + F10`).

---

## 🤝 Contribution & Bonnes Pratiques

- **Formatage du code** : Respectez les conventions officielles de Kotlin (`ktlint` / style standard Android).
- **Gestion des branches** : Créez des branches thématiques (`feature/nom-fonctionnalite` ou `fix/nom-bug`) basées sur `frontend-android`.
- **Commits conventionnels** : Utilisez les préfixes standard (`feat:`, `fix:`, `refactor:`, `docs:`, `style:`).

---

## 📄 Licence

Ce projet est réalisé dans le cadre du projet **SportKids**. Tous droits réservés.
