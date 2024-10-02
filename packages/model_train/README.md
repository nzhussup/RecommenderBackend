# Model CICD Nzhussup

## Overview

**Model CICD Nzhussup** is a Python package designed for building and managing Clustering Based SVDpp algorithm.

The package includes tools for data handling, model training, and evaluation, along with utilities for managing model versions and deployments.

## Directory Structure

```
.
├── LICENSE
├── MANIFEST.in
├── README.md
├── dist                  # Distribution files
├── pyproject.toml       # Build configuration
├── src
│   ├── model_cicd_nzhussup  # Main package
│   │   ├── data           # Data files
│   │   │   └── u.data
│   │   ├── models         # Model files
│   │   │   └── model.pkl
│   │   ├── modules        # Module implementations
│   │   └── training       # Training scripts
└── tests                 # Unit tests for the package
```

## Installation

You can install the package via pip from the source. Clone the repository and run the following command from the root directory:

```bash
pip install .
```

Alternatively, you can install from the distribution files located in the `dist` directory:

```bash
pip install dist/model_cicd_nzhussup-0.0.1-py3-none-any.whl
```

## Usage

### Loading Data

To load the `u.data` file, you can use the following code snippet:

```python
from model_cicd_nzhussup.controller import Controller

data = Controller.load_data()
```

### Training a Model

You can train a model using the training module provided in the package:

```python
from model_cicd_nzhussup.training import train

train.train()
```

### Loading a Trained Model

You can load a trained model from the package:

```python
from model_cicd_nzhussup.controller import Controller

model = Controller.get_model()
```

## Running Tests

To run the tests, navigate to the `tests` directory and execute:

```bash
pytest
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
