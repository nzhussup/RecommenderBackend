# tests/test_train.py

import unittest
from model_cicd_nzhussup.training.train import train
from model_cicd_nzhussup import config
from surprise import Dataset
from surprise.model_selection import train_test_split
from sklearn.metrics import mean_squared_error
import numpy as np
import pickle
import os



class TestTrainFunction(unittest.TestCase):

    def setUp(self):
        self.data = Dataset.load_builtin('ml-100k')
        self.trainset, self.testset = train_test_split(self.data, test_size=0.2)

    def test_train(self):
        try:
            train()
        except Exception as e:
            self.fail(f"train() raised an exception {e}")

    def test_model_saved(self):
        train()
        model_path = os.path.join(config.MODEL_SAVE_PATH, config.MODEL_NAME)
        self.assertTrue(os.path.isfile(model_path), "Model was not saved!")

    def test_rmse(self):
        model_path = os.path.join(config.MODEL_SAVE_PATH, config.MODEL_NAME)
        self.assertTrue(os.path.isfile(model_path), "Model was not saved, cannot compute RMSE!")

        with open(model_path, 'rb') as f:
            trained_model = pickle.load(f)

        y_pred, y_true = trained_model.predict_df(self.testset)
        rmse = np.sqrt(mean_squared_error(y_true, y_pred))
        print(f"RMSE: {rmse}")

        self.assertLessEqual(rmse, 1.5, "RMSE is higher than expected!")  # Adjust based on your use case

if __name__ == "__main__":
    unittest.main()
