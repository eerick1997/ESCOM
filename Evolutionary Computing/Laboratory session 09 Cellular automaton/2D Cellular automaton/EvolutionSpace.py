
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from PyQt5.QtGui import *
import math

import CellularAutomaton as CA

class EvolutionSpace(QWidget):
    def __init__(self, parent):
        super(EvolutionSpace, self).__init__(parent)
        self.ca = CA.CellularAutomaton()
        self.gui = parent
        self.iStart = 0
        self.jStart = 0
        self.iEnd = 0
        self.jEnd = 0
    
    def nextGeneration(self):
        self.ca.nextGeneration()
        self.gui.txtGeneration.setText("Generation: " + str(self.ca.generation))
        self.gui.txtNumQ0Cells.setText("Q0 Cells: " + str(self.ca.countQ0Cells))
        self.gui.txtNumQ1Cells.setText("Q1 Cells: " + str(self.ca.countQ1Cells))
        self.gui.txtNumQ2Cells.setText("Q2 Cells: " + str(self.ca.countQ2Cells))
        self.update()      
        
    def generateRandomEvolutionSpace(self, probQ0, probQ1, probQ2):
        self.ca.randomEvolutionSpace(probQ0, probQ1, probQ2)  
        self.update()
        
    def cellSizeChanged(self, cellSize):
        self.ca.cellSize = cellSize
        self.resizeRenderSpace()
        self.update()
    
    def dimensionsChanged(self, dimension):
        self.ca.height = dimension
        self.ca.width = dimension
        self.resizeRenderSpace()
        self.update()
    
    def resizeRenderSpace(self):
        cellSize = self.ca.cellSize
        width = self.ca.width
        height = self.ca.height
        self.setFixedSize(width * cellSize, height * cellSize)
        
        
    def mousePressEvent(self, event):
        cellSize = self.ca.cellSize
        i = event.pos().x() // cellSize
        j = event.pos().y() // cellSize
            
        if event.buttons() & Qt.LeftButton:
            self.ca.evolutionSpace[i][j] = (self.ca.evolutionSpace[i][j] + 1) % 3
        elif event.buttons() & Qt.RightButton:
            self.ca.evolutionSpace[i][j] = (self.ca.evolutionSpace[i][j] + 2) % 3
        self.update()
    
    #We just rendet the evolution space that you see in the screen
    #This smart way to render help us to make faster the sumulator
    def renderEvolutionSpace(self, qPainter): 
        cellSize = self.ca.cellSize
        iMin = self.iStart // cellSize
        jMin = self.jStart // cellSize
        iMax = min(math.ceil(self.iEnd / cellSize) + iMin, self.ca.height)
        jMax = min(math.ceil(self.jEnd / cellSize) + jMin, self.ca.width)
        for i in range(iMin, iMax):
            for j in range(jMin, jMax):
                currCell = self.ca.evolutionSpace[i][j]
                qrect = QRect(i * cellSize, j * cellSize, cellSize, cellSize)
                if currCell == 0:   
                    qPainter.fillRect(qrect, QColor(32,178,170))
                elif currCell == 1:
                    qPainter.fillRect(qrect, QColor(0, 100, 0))
                else:
                    qPainter.fillRect(qrect, QColor(50,205,50))
                    
                qPainter.drawRect(qrect)
                    
    def paintEvent(self, event):
        self.renderEvolutionSpace(QPainter(self))
        
        
                    

        