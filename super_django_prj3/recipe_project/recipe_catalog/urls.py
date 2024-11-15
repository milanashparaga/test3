from django.urls import path
from . import views

urlpatterns = [
    path('', views.recipe_list, name='index'),
    path('recipe/<int:pk>/', views.recipe, name='recipe_detail'),
    path('about/', views.about, name='about'),
]
