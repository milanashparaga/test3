from django.db import models

class Recipe(models.Model):
    title = models.CharField(max_length=200)  # Название рецепта
    description = models.TextField()  # Описание рецепта
    ingredients = models.TextField()  # Ингредиенты
    instructions = models.TextField()  # Инструкции по приготовлению

    def __str__(self):
        return self.title
