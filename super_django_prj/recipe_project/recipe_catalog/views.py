from django.http import HttpResponse
from django.shortcuts import render, get_object_or_404
from .models import Recipe

def about(request):
    return render(request, 'about.html')

def index(request):
    recipes = Recipe.objects.all()
    return render(request, 'index.html', {'recipes': recipes})

def recipe_detail(request, pk):
    recipe = get_object_or_404(Recipe, pk=pk)
    context = {
        'title': recipe.title,
        'recipe_id': pk,
        'ingredients': recipe.ingredients,
        'instructions': recipe.instructions,
    }
    return render(request, 'recipe.html', context)

def favorite_recipes(request):
    return HttpResponse('Избранные рецепты')

def all_recipes(request):
    return HttpResponse('Все рецепты')