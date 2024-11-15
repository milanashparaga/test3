from django.contrib import admin
from .models import Ingredient, Recipe, RecipeIngredient

class IngredientInline(admin.StackedInline):
    """В рецепте есть ингредиенты."""
    model = RecipeIngredient
    extra = 5

class RecipeAdmin(admin.ModelAdmin):
    """Настройка формы админки для рецепта."""
    inlines = [IngredientInline]
    list_display = ["name"]

admin.site.register(Recipe, RecipeAdmin)

class IngredientAdmin(admin.ModelAdmin):
    """Настройка формы админки для ингредиента."""
    list_display = ["name"]

admin.site.register(Ingredient, IngredientAdmin)
