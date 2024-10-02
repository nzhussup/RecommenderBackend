from model_cicd_nzhussup.controller import Controller
from model_cicd_nzhussup.training import train
from model_cicd_nzhussup.modules.cluster_rec import CB_SVDpp
from surprise import Dataset


def load_cbsvdpp() -> CB_SVDpp:
    return Controller.get_model()

def get_cbsvdpp() -> CB_SVDpp:
    return load_cbsvdpp()
    
def train_cbsvdpp() -> CB_SVDpp:
    train.train()
    return Controller.get_rmse()

def load_data() -> Dataset:
    return Controller.get_data()

def add_data(data) -> dict:
    
    data_str = f"{data.user_id}\t{data.item_id}\t{data.score}\t{data.timestamp}"
    return Controller.append_data(data_str)

def get_testset() -> Dataset:
    return Controller.get_testset()

def get_data_len() -> int:
    data = load_data()
    data = data.build_full_trainset()
    return data.n_ratings




