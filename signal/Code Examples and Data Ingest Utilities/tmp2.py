#! /usr/bin/python3
import pickle
import numpy as np
#from data_loader import LoadModRecData
TAG = '[Data L] - '

#x = LoadModRecData('training_data_chunk_14.pkl.part',.00000001,.00000001,.00000001)

class test_it:

    def loadData2(self, fname):
        '''  Load dataset from pickled file '''

        # load data from files
        with open(fname, 'rb') as f:
#            if self.python_version_3:
                self.dataCube = pickle.load(f, encoding='latin-1')
                dataCubeKeyIndices = list(zip(*self.dataCube))
#            else:
#                self.dataCube = pickle.load(f)
#                dataCubeKeyIndices = zip(*self.dataCube)

        # get all mod types
        self.modTypes = np.unique(dataCubeKeyIndices[0])

        # get all SNR values
        self.snrValues = np.unique(dataCubeKeyIndices[1])

        # create one-hot vectors for each mod type
        oneHotArrays = np.eye(len(self.modTypes), dtype=int)

        # Count Number of examples
        print(TAG + "Counting Number of Examples in Dataset...")
        number_of_examples = 0
        for modType in self.modTypes:
            for snrValue in self.snrValues:
                number_of_examples = number_of_examples + len(self.dataCube[modType, snrValue])

        print (TAG + 'Number of Examples in Dataset: ' + str(number_of_examples))



	





