#! /usr/bin/python3
import pickle
import numpy

#print("hello")

file = open('training_data_chunk_8.pkl.part', 'rb')

data = pickle.load(file)

file.close()

print('Showing the pickled data:')

cnt = 0
for item in data:
    print('The data ', cnt, ' is : ', item)
    cnt += 1


#with open('training_data_chunk_8.pkl.part', 'rb') as f:
#    data = pickle.load(f)


#data= pickle.load( open("training_data_chunk_8.pkl", "rb"))     
#    data = pickle.load(f)
print(data)
