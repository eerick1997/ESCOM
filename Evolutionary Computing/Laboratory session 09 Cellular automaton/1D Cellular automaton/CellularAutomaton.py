import random as rand

class CellularAutomaton:

    def __init__(self, rule=0, width=100, height=100, cellSize=5, spaceIsClosed=False):
        self.rule = rule
        self.width = width
        self.height = height
        self.cellSize = cellSize
        self.spaceIsClosed = spaceIsClosed
        self.evolutionSpace = self.createMatrix()
        self.bitmaskCodes = {}
        self.countQ0Cells = 0
        self.countQ1Cells = 0
        self.generation = 1

    def createMatrix(self):
        matrix = []
        for i in range(0, self.height):
            row = []
            for j in range(0, self.width):
                    row.append(0)
            matrix.append(row)
        return matrix
    
    #Let's assume Q1 is the state which value is 1
    def randomEvolutionSpace(self, densityQ1):
        for j in range(0, self.width):
            probability = rand.random()
            self.evolutionSpace[j][0] = 1 if 0 <= probability <= densityQ1 else 0

    def getValidPosition(self, position, limit):
        if self.spaceIsClosed:
            return (position + limit) % limit
        if position < 0 or position >= limit:
            return -1
        return position

    def getBitmask(self, i):
        positions = [2, 1, 0, -1, -2]
        code = 0
        #We're using a 1-D CA of two layers it means:
        #Two neighbors at each side, XXCXX
        for j in range(len(positions)):
            validJ = self.getValidPosition(positions[j] + i, self.width)
            if validJ == -1:
                continue
            
            code |= self.evolutionSpace[validJ][self.generation - 1] << j
        
        return code
            
        
    def nextGeneration(self):
        for i in range(0, self.width):
            bitmask = self.getBitmask(i)
            self.evolutionSpace[i][self.generation] = self.bitmaskCodes[bitmask]
            
            if(self.evolutionSpace[self.generation][i] == 1):
                self.countQ1Cells += 1
            else: 
                self.countQ0Cells += 1
        self.generation += 1