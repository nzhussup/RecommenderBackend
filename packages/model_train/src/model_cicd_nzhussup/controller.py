from model_cicd_nzhussup.modules.cluster_rec import CB_SVDpp
from model_cicd_nzhussup import config
from surprise import Dataset, Reader
from surprise.model_selection import train_test_split
from sklearn.metrics import mean_squared_error
import numpy as np
import pandas as pd
import io
import pickle
import os

class Controller:
    
    
    @staticmethod
    def get_model() -> CB_SVDpp:
        
        with open(os.path.join(config.MODEL_SAVE_PATH, config.MODEL_NAME), "rb") as f:
            model = pickle.load(f)
        return model

    @staticmethod
    def get_data() -> Dataset:
        
        reader = Reader(line_format='user item rating timestamp', sep='\t')
        data = Dataset.load_from_file(os.path.join(config.DATA_PATH, config.DATA_NAME), reader=reader)
        return data
    
    @staticmethod
    def split_data():
        reader = Reader(line_format='user item rating timestamp', sep='\t')
        data = Dataset.load_from_file(os.path.join(config.DATA_PATH, config.DATA_NAME), reader=reader)
        return train_test_split(data, test_size=0.2)
        
    @staticmethod
    def get_testset():
        
        trainset, _ = Controller.split_data()
        return trainset
    
    @staticmethod
    def get_testset():
        
        _, testset = Controller.split_data()
        return testset
    
    @staticmethod
    def get_rmse() -> float:
        
        y_pred, y_true = Controller.get_model().predict_df(Controller.get_testset())
        return np.sqrt(mean_squared_error(y_true, y_pred))

    
    @staticmethod
    def append_data(u_data: str) -> dict:
        
        try:
            data_io = io.StringIO(u_data)
            df = pd.read_csv(data_io, sep='\t', names=["user", "item", "rating", "timestamp"])
            reader = Reader(line_format='user item rating timestamp')
            data = Dataset.load_from_df(df[['user', 'item', 'rating']], reader)
        
        except Exception as e:
            return {
                "status": "fail",
                "message": e
            }


        try:
            with open(os.path.join(config.DATA_PATH, config.DATA_NAME), 'a') as f:
                f.write(u_data + '\n')
        except Exception as e:
            return {
                "status": "fail",
                "message": f"Error writing to file: {e}"
            }
        
        return {
            "status": "success"
        }

        
        