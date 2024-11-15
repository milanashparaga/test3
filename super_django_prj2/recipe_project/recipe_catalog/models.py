from django.db import models
from django.core.validators import MaxValueValidator, MinValueValidator

class Ingredient(models.Model):
    """Составная часть рецепта."""
    name = models.CharField(max_length=255)
    price = models.FloatField(
        validators=[MinValueValidator(0.0), MaxValueValidator(10000.0)],
        default=0.0
    )

    def __str__(self):
        return self.name

class Recipe(models.Model):
    """Вкусное делается по рецепту."""
    name = models.CharField(max_length=300)
    ingredients = models.ManyToManyField(Ingredient, through="RecipeIngredient")

    def __str__(self): #магические методы
        return self.name

class RecipeIngredient(models.Model):
    """Один ингредиент может быть в нескольких рецептах, как и в одном рецепте может быть несколько ингредиентов."""
    recipe = models.ForeignKey('Recipe', on_delete=models.CASCADE)
    ingredient = models.ForeignKey(Ingredient, on_delete=models.CASCADE)

    def __str__(self):
        return f'{self.recipe.name} - {self.ingredient.name}'

    class Meta: #чтобы не было нескольких одинаковых ингридиентов в рецепте (ограниченность целостности)
        constraints = [
            models.UniqueConstraint(
                fields=['recipe', 'ingredient'],
                name='unique_recipe_ingredient'
            )
        ]
