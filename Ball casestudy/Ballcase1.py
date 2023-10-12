from sklearn import tree

def MarvellousML(weight,surface):
    BallsFeature=[[35,1],[47.1],[90,0],[48,1],[90,0],[35,1],[92,0],[35,1],[35,1],[35,1],[96,0],[43,1],[110,0],[35,1],[95,1]] 

    Names=[1,1,2,1,2,1,2,1,1,1,2,1,2,1,2]

    cif=tree.DecisionTreeClassifier()

    cif=cif.fit(BallsFeature,Names)

    result=cif.predict([[weight,surface]])

    if result==1:
        print("Your object looks like Tennisball")
    elif result==2:
        print("Cricket Ball")


def main():
    print("Enter weight of object")
    weight=input()

    print("what is surface type of our object rough or smooth")
    surface=input()
    if surface.lower()=="rough":
        surface=1
    elif surface.lower()=="smooth":
        surface=0
    else:
        print("Error : Wrong input")
        exit()      

    MarvellousML(weight,surface)

if __name__=="__main__":
    main()