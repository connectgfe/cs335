#! /usr/bin/python3
import pickle
import numpy
import example
#from data_loader import LoadModRecData
from tmp2 import test_it
import pprint

#example.example_1(training_data_chunk_14.pkl.part,10,10)

#x = LoadModRecData('training_data_chunk_14.pkl.part',.00000001,.00000001,.00000001)

x = test_it()
x.loadData2('training_data_chunk_14.pkl.part')

#print(x.dataCube.keys())

#tmp_list =x.dataCube[('QAM64', -6)]
tmp_list =x.dataCube[('8PSK', -6)]


#print(x.dataCube[('QAM64', -6)])
tmp_list2 =tmp_list[30]

print(tmp_list2)
print('done')

pp = pprint.PrettyPrinter(indent=1)
pp.pprint(tmp_list2[1])

f = open('8PSK_-6_1B.txt', 'w')
for val in tmp_list2[1]:
	f.write("%s\n" % val)
#	print(val)
