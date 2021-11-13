import random as rand

class CellularAutomaton:

    def __init__(self, b1=3, b2=3, s1=2, s2=3, u1=0, u2=0, r1=0, r2=0, width=10, height=10, cellSize=20, spaceIsToroid=False):
        self.b1 = b1
        self.b2 = b2
        self.s1 = s1
        self.s2 = s2
        self.u1 = u1
        self.u2 = u2
        self.r1 = r1
        self.r2 = r2
        self.width = width
        self.height = height
        self.cellSize = cellSize
        self.spaceIsToroid = spaceIsToroid
        self.evolutionSpace = self.createMatrix()
        self.auxEvolutionSpace = self.createMatrix()
        self.countQ0Cells = 0
        self.countQ1Cells = 0
        self.countQ2Cells = 0
        self.generation = 0

    def createMatrix(self):
        matrix = []
        for i in range(0, 500):
            row = []
            for j in range(0, 500):
                row.append(0)
            matrix.append(row)
        return matrix
    
    def randomEvolutionSpace(self, densityQ0, densityQ1, densityQ2):
        if densityQ0 + densityQ1 + densityQ2 > 1:
            print("Cannot have a density greater than 1")
            return
        
        for i in range(0, self.height):
            for j in range(0, self.width):
                probability = rand.random()
                if 0 <= probability <= densityQ0:
                    self.evolutionSpace[i][j] = 0
                elif densityQ0 < probability <= densityQ0 + densityQ1:
                    self.evolutionSpace[i][j] = 1
                else:
                    self.evolutionSpace[i][j] = 2

    def getValidPosition(self, position, limit):
        if self.spaceIsToroid:
            return (position + limit) % limit
        if position < 0 or position >= limit:
            return -1
        return position

    def countNeighbors(self, row, col):
        #Counting each type of states
        countQ0, countQ1, countQ2 = 0, 0, 0

        for i in range(-1, 2):
            for j in range(-1, 2):
                validRow = self.getValidPosition(i + row, self.height)
                validCol = self.getValidPosition(j + col, self.width)
                if validRow == row and validCol == col:
                    continue
                if validRow == -1 or validCol == -1:
                    continue  
                
                currCell = self.evolutionSpace[validRow][validCol]
                
                if currCell == 0:
                    countQ0 += 1
                elif self.evolutionSpace[validRow][validCol] == 1:
                    countQ1 += 1
                else:
                    countQ2 += 1
                    
        return countQ0, countQ1, countQ2

    def nextGeneration(self):
        for i in range(0, self.height):
            for j in range(0, self.width):
                countQ0, countQ1, countQ2 = self.countNeighbors(i, j)
                #Transition list
                if self.evolutionSpace[i][j] == 0 and self.b1 <= countQ0 <= self.b2:
                    self.auxEvolutionSpace[i][j] = 1
                    self.countQ1Cells += 1
                elif self.evolutionSpace[i][j] == 1:
                    if self.s1 <= countQ1 <= self.s2:
                        self.auxEvolutionSpace[i][j] = 1
                        self.countQ1Cells += 1
                    elif self.u1 <= countQ1 <= self.u2:
                        self.auxEvolutionSpace[i][j] = 2
                        self.countQ2Cells += 1
                    else:
                        self.auxEvolutionSpace[i][j] = 0
                        self.countQ0Cells += 1
                elif self.evolutionSpace[i][j] == 2 and self.r1 <= countQ2 <= self.r2:
                    self.auxEvolutionSpace[i][j] = 2
                    self.countQ2Cells += 1
                else:
                    self.auxEvolutionSpace[i][j] = 0
                    self.countQ0Cells += 1
        #To avoid use a lot of memory we can swap only the positions of those matrix
        self.evolutionSpace, self.auxEvolutionSpace = self.auxEvolutionSpace, self.evolutionSpace
        self.generation += 1