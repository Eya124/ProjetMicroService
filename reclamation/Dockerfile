FROM php:8.2-fpm

# Mettre à jour les dépôts
RUN apt-get update

# Installer les dépendances
RUN apt-get install -y \
    libicu-dev \
    libxml2-dev \
    libzip-dev \
    zip \
    unzip \
    libpq-dev \
    && docker-php-ext-install pdo_pgsql \
    && docker-php-ext-install intl \
    && docker-php-ext-install zip

# Copier Composer
COPY --from=composer:latest /usr/bin/composer /usr/bin/composer

# Définir le répertoire de travail
WORKDIR /var/www/html

# Copier les fichiers de l'application
COPY . /var/www/html

# Installer les dépendances de l'application et afficher les logs d'erreur
RUN COMPOSER_ALLOW_SUPERUSER=1 composer install --no-interaction --optimize-autoloader


# Exposer le port
EXPOSE 9000

# Démarrer PHP-FPM
CMD ["php-fpm"]
