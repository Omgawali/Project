import numpy as np
import pandas as pd
from sklearn import preprocessing
from sklearn.neighbors import KNeighborsClassifier

def MarvellousPlayPredictor(data_path):

    data = pd.read_csv(data_path, index_col=0)

    print("Size of actual dataset", len(data))

    feature_names = ['Whether', 'Temperature']

    print("Names of feature", feature_names)

    weather = data['Whether']
    temperature = data['Temperature']
    play = data['Play']

    le = preprocessing.LabelEncoder()

    weather_encoded = le.fit_transform(weather)
    print(weather_encoded)

    temp_encoded = le.fit_transform(temperature)
    label = le.fit_transform(play)

    print(temp_encoded)

    features = list(zip(weather_encoded, temp_encoded))

    model = KNeighborsClassifier(n_neighbors=3)

    model.fit(features, label)

    predicted = model.predict([[0, 2]])
    print(predicted)

def main():
    print("Play predictor using K Nearest Neighbor algorithm")

    MarvellousPlayPredictor("PlayPredictor.csv")

if __name__ == "__main__":
    main()
