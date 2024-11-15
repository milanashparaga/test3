from django.db import models
from django.core.validators import MaxValueValidator, MinValueValidator


class Unit(models.Model):
    """Единица измерения для ингредиентов (граммы, ложки, стаканы и т.д.)."""
    name = models.CharField(max_length=50)
    factor = models.FloatField(default=1.0)
    def __str__(self):
        return self.name


class Ingredient(models.Model):
    """Составная часть рецепта."""
    name = models.CharField(max_length=255)
    price = models.FloatField(
        validators=[MinValueValidator(0.0), MaxValueValidator(10000.0)],
        default=0.0
    )
    base_weight_grams = models.FloatField(
        default=100,
        validators=[MinValueValidator(0.0)],
    )

    def __str__(self):
        return self.name


class Recipe(models.Model):
    """Вкусное делается по рецепту."""
    name = models.CharField(max_length=300)
    ingredients = models.ManyToManyField(Ingredient, through="RecipeIngredient")

    def __str__(self):
        return self.name

    def get_total_weight(self):
        """Метод для расчета общего веса рецепта на основе ингредиентов и их количества."""
        total_weight = 0
        for recipe_ingredient in self.recipeingredient_set.all():
            total_weight += recipe_ingredient.get_weight()
        return total_weight


class RecipeIngredient(models.Model):
    """Модель для связи ингредиентов с рецептами."""
    recipe = models.ForeignKey(Recipe, on_delete=models.CASCADE)
    ingredient = models.ForeignKey(Ingredient, on_delete=models.CASCADE)
    quantity = models.FloatField(validators=[MinValueValidator(0.0)])
    unit = models.ForeignKey(Unit, on_delete=models.CASCADE)

    def __str__(self):
        return f'{self.recipe.name} - {self.ingredient.name}'

    def get_weight(self):
        """Метод для расчета веса одного ингредиента с учетом его количества и единицы измерения."""
        return self.quantity * self.unit.factor

    class Meta:
        constraints = [
            models.UniqueConstraint(
                fields=['recipe', 'ingredient'],
                name='unique_recipe_ingredient'
            )
        ]
