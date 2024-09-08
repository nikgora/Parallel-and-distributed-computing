# Dockerfile для Java-додатка
FROM openjdk:22-jdk-slim

# Створимо робочу директорію всередині контейнера
WORKDIR /app

# Копіюємо наш файл Main.java в контейнер
COPY src/Main.java /app

# Компіляція Java-файла
RUN javac Main.java

# Вказуємо команду, яку виконає Docker при запуску контейнера
CMD ["java", "Main"]
