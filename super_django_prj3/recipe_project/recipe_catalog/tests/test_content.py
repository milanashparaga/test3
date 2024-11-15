from django.test import TestCase
from recipe_catalog.models import Recipe, Ingredient, RecipeIngredient, Unit


class ContentTests(TestCase):
    def setUp(self):
        gram_unit = Unit.objects.create(name="Граммы")

        ingredient1 = Ingredient.objects.create(name="Мука", base_weight_grams=100)
        ingredient2 = Ingredient.objects.create(name="Сахар", base_weight_grams=50)

        recipe = Recipe.objects.create(name="Пирог")
        RecipeIngredient.objects.create(recipe=recipe, ingredient=ingredient1, quantity=100, unit=gram_unit)
        RecipeIngredient.objects.create(recipe=recipe, ingredient=ingredient2, quantity=50, unit=gram_unit)

    def test_recipe_creation(self):
        recipe = Recipe.objects.get(name="Пирог")
        self.assertEqual(recipe.name, "Пирог")

    def test_ingredient_attributes(self):
        ingredient = Ingredient.objects.get(name="Мука")
        self.assertEqual(ingredient.base_weight_grams, 100)

    def test_total_weight_calculation(self):
        recipe = Recipe.objects.get(name="Пирог")
        total_weight = recipe.get_total_weight()
        self.assertAlmostEqual(total_weight, 150)

    def test_ingredients_ordered_alphabetically(self):
        recipe = Recipe.objects.get(name="Пирог")
        ingredients = [ri.ingredient.name for ri in recipe.recipeingredient_set.all()]
        self.assertEqual(ingredients, sorted(ingredients))
