#!/usr/bin/python3


import operator
import csv

with open('test.csv') as csvfile:
  csv = csv.reader(csvfile, delimiter=',')
  sor = sorted(csv,key=operator.itemgetter(1), reverse=True)



  for row in sor:
    print(row)





print('ok it works')


