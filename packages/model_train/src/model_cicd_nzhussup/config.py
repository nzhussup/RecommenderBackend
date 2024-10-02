import os

PACKAGE_PATH = os.path.dirname(os.path.abspath(__file__))

MODEL_SAVE_PATH = os.path.join(PACKAGE_PATH, "models")
MODEL_NAME = "model.pkl"

DATA_PATH = os.path.join(PACKAGE_PATH, "data")
DATA_NAME = "u.data"
# MODEL CONFIG

NUM_CLUSTER = 50
ALPHA = 0.15
N_EPOCHS = 20
VERBOSE = True