from django.urls import path
from .views import about, index, recipe_detail, favorite_recipes, all_recipes

urlpatterns = [
    path('', index, name='index'),
    path('recipes/<int:pk>/', recipe_detail, name='recipe_detail'),
    path('recipes/favorite/', favorite_recipes, name='favorite_recipes'),
    path('recipes/', all_recipes, name='all_recipes'),
    path('about/', about, name='about'),
]