# tests/test_data.py

import unittest
from surprise import Dataset, Reader
from surprise.model_selection import train_test_split
from model_cicd_nzhussup import config
import os

class TestDataLoading(unittest.TestCase):

    def setUp(self):
        self.data_path = os.path.join(config.DATA_PATH, config.DATA_NAME)

    def test_data_file_exists(self):
        self.assertTrue(os.path.isfile(self.data_path), f"Data file {self.data_path} does not exist.")

    def test_load_data(self):
        reader = Reader(line_format='user item rating timestamp', sep='\t')
        data = Dataset.load_from_file(self.data_path, reader=reader)
        self.assertIsNotNone(data, "Failed to load data.")
        
    def test_data_split(self):
        reader = Reader(line_format='user item rating timestamp', sep='\t')
        data = Dataset.load_from_file(self.data_path, reader=reader)
        trainset, testset = train_test_split(data, test_size=0.2)
        self.assertIsNotNone(trainset, "Trainset should not be None.")
        self.assertIsNotNone(testset, "Testset should not be None.")
        
if __name__ == "__main__":
    unittest.main()
