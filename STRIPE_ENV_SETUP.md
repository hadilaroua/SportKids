# Configuration des Variables d'Environnement Stripe

## Ajouter les clés Stripe dans le fichier .env

Ouvrez le fichier `.env` dans `C:\Users\hatem\OneDrive\Bureau\Backend\` et ajoutez les lignes suivantes :

```env
# Stripe Configuration
STRIPE_SECRET_KEY=sk_test_your_stripe_secret_key_here
STRIPE_PUBLISHABLE_KEY=pk_test_your_stripe_publishable_key_here
```

## Vérification

Après avoir ajouté ces variables, redémarrez le serveur backend :

```bash
cd C:\Users\hatem\OneDrive\Bureau\Backend
npm run start:dev
```

Le module Payments devrait se charger correctement et les endpoints suivants seront disponibles :

- `POST /payments/create-intent` - Créer un PaymentIntent
- `POST /payments/confirm` - Confirmer un paiement

## Documentation Swagger

Une fois le serveur démarré, vous pouvez voir la documentation des endpoints dans Swagger :
- Ouvrez votre navigateur et allez à : `http://localhost:3000/api`










