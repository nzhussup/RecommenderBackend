import sys
import os
sys.path.append(os.path.dirname(os.path.abspath(__file__)) + "/../")
from model_cicd_nzhussup.modules.cluster_rec import CB_SVDpp
from model_cicd_nzhussup import config
from surprise import Dataset, Reader
from surprise.model_selection import train_test_split
import pickle

def train():

    reader = Reader(line_format='user item rating timestamp', sep='\t')
    data = Dataset.load_from_file(os.path.join(config.DATA_PATH, config.DATA_NAME), reader=reader)
    trainset, _ = train_test_split(data, test_size=0.2)
    
    model = CB_SVDpp(num_clusters=config.NUM_CLUSTER, 
                     alpha=config.ALPHA, 
                     n_epochs=config.N_EPOCHS, 
                     verbose=config.VERBOSE)

    model.fit(trainset)
    model.calc_Nu(trainset)
    
    print("Training completed")
    
    with open(os.path.join(config.MODEL_SAVE_PATH, config.MODEL_NAME), 'wb') as f:
        pickle.dump(model, f)
    

    print("Model saved")
    
if __name__ == "__main__":
    
    train()
