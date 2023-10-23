import math 
import numpy as np 
import pandas as pd
import seaborn as sns
from seaborn import countplot
import matplotlib.pyplot as plt 
from matplotlib.pyplot import figure,show
from sklearn.metrics import accuracy_score
from sklearn.metrics import confusion_matrix
from sklearn.metrics import classification_report
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression

def MarvellousTitanicLogistic():

    titanic_data=pd.read_csv('MarvellousTitanicDataset.csv')

    print("First 5 entries from loaded datset")
    print(titanic_data.head())

    print("Number of passenger are"+str(len(titanic_data)))

    #step 2 analyze data
    print("visualization survived and non survived passengers")
    figure()
    target="Survived"

    countplot(data=titanic_data,x=target).set_title("Survived and non survived passenger")
    show()
    
    print("visualisation :Survived and non survived passenger based on gender")
    target="Survived"

    countplot(data=titanic_data,x=target,hue="Sex").set_title("survived and nonsurvived passenger based on gender")
    show()

    print("Visualization :Survived and non survived pasenger based on the passenger class")
    figure()
    target="Survived"

    countplot(data=titanic_data,x=target,hue="Pclass").set_title("Survived and non survived pasenger based on the passenger class")
    show()

    print("Visualization : Survived and non survived passenger based on Age")
    figure()
    titanic_data["Age"].plot.hist().set_title("Survived and non survied based on age")
    show()

    print("visualization : Survived and non survived passenger based on the fare")
    figure()

    titanic_data["Fare"].plot.hist().set_title("Surviveed and non survived based on fare")
    show()


    #step 3 Data cleaning
    titanic_data.drop("zero",axis=1,inplace=True)

    print("first 5 entries from loaded dataset after removing zero column")
    print(titanic_data.head(5))

    print("values of sex column")
    print(pd.get_dummies(titanic_data["Sex"]))

    print("Values of Sex column after remaining one field ")
    Sex=pd.get_dummies(titanic_data["Sex"],drop_first=True)
    print(Sex.head(5))

    print("Values of Pclass column after removing one field ")
    Pclass=pd.get_dummies(titanic_data["Pclass"],drop_first=True)
    print(Pclass.head(5))

    print("values of dataset after concatenating new column")
    titanic_data=pd.concat([titanic_data,Sex,Pclass],axis=1)
    print(titanic_data.head(5))

    print("Values of dataset after removing irrelevant column")
    titanic_data.drop(["Sex","sibsp","Parch","Embarked"],axis=1,inplace=True)
    print(titanic_data.head(5))

    x=titanic_data.drop("Survived",axis=1)
    y=titanic_data["Survived"]

    #Step 4 data training
    xtrain,xtest,ytrain,ytest=train_test_split(x,y,test_size=0.5)
    
    xtrain.columns=xtrain.columns.astype(str)
    xtest.columns = xtest.columns.astype(str)
    logmodel=LogisticRegression()
    logmodel.fit(xtrain,ytrain)

    #Step 4 data testing
    prediction=logmodel.predict(xtest)

    #step 5 calculate accuracy

    print("classification report or logistic regression is:")
    print(classification_report(ytest,prediction))

    print("Confusion Matrix of logistic regression is:")
    print(confusion_matrix(ytest,prediction))

    print("Accuracy of logistic regression is")
    print(accuracy_score(ytest,prediction))

def main():
    print("Supervised M L")
    print("Logistic Regression on Titanic dataset")

    MarvellousTitanicLogistic()

if __name__=="__main__":
    main()