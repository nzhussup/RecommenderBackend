import unittest
from surprise import Dataset
from surprise.model_selection import train_test_split
from model_cicd_nzhussup.modules.cluster_rec import CB_SVDpp
from model_cicd_nzhussup import config, controller

class TestCB_SVDpp(unittest.TestCase):

    def setUp(self):
        self.data = controller.Controller.get_data()
        self.trainset, _ = train_test_split(self.data, test_size=0.2)
        self.model = CB_SVDpp(num_clusters=config.NUM_CLUSTER, 
                               alpha=config.ALPHA, 
                               n_epochs=config.N_EPOCHS, 
                               verbose=config.VERBOSE)

    # Fit without error
    def test_fit(self):
        try:
            self.model.fit(self.trainset)
        except Exception as e:
            self.fail(f"fit() raised an exception {e}")

    # Test params
    def test_parameters(self):
        self.assertEqual(self.model.num_clusters, config.NUM_CLUSTER)
        self.assertEqual(self.model.alpha, config.ALPHA)

    # Test Nu calculation
    def test_calc_Nu(self):
        self.model.fit(self.trainset)
        try:
            self.model.calc_Nu(self.trainset)
        except Exception as e:
            self.fail(f"calc_Nu() raised an exception {e}")

if __name__ == "__main__":
    unittest.main()
