from django.test import TestCase
from django.urls import reverse

class RouteTests(TestCase):

    def test_recipe_list_route(self):
        response = self.client.get(reverse('index'))
        self.assertEqual(response.status_code, 200)

    def test_about_catalog_route(self):
        response = self.client.get(reverse('about'))
        self.assertEqual(response.status_code, 200)

    def test_recipe_detail_route(self):
        response = self.client.get(reverse('recipe_detail', args=[1]))
        self.assertEqual(response.status_code, 404)
