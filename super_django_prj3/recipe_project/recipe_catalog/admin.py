from django.contrib import admin
from .models import Recipe, Ingredient, RecipeIngredient, Unit


class RecipeIngredientInline(admin.TabularInline):
    model = RecipeIngredient
    extra = 1


class RecipeAdmin(admin.ModelAdmin):
    inlines = [RecipeIngredientInline]


class IngredientAdmin(admin.ModelAdmin):
    pass


class UnitAdmin(admin.ModelAdmin):
    pass


admin.site.register(Recipe, RecipeAdmin)
admin.site.register(Ingredient, IngredientAdmin)
admin.site.register(RecipeIngredient)
admin.site.register(Unit, UnitAdmin)
