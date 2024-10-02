import unittest
from model_cicd_nzhussup.controller import Controller
from model_cicd_nzhussup.modules.cluster_rec import CB_SVDpp
from model_cicd_nzhussup import config
from surprise import Dataset

class TestController(unittest.TestCase):

    def test_get_model(self):
        model = Controller.get_model()
        self.assertIsInstance(model, CB_SVDpp, "The returned object is not an instance of CB_SVDpp")

    def test_get_data(self):
        data = Controller.get_data()
        self.assertIsInstance(data, Dataset, "The returned object is not an instance of Dataset")

if __name__ == '__main__':
    unittest.main()
