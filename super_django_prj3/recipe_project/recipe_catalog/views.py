from django.shortcuts import render, get_object_or_404
from .models import Recipe


def recipe_list(request):
    recipes = Recipe.objects.all()
    return render(request, 'index.html', {'recipes': recipes})


def recipe(request, pk):
    recipe = get_object_or_404(Recipe, pk=pk)
    return render(request, 'recipe.html', {'recipe': recipe})


def about(request):
    return render(request, 'about.html')
