
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
        
        if self.ca.generation == self.ca.width:
            return
        
        self.ca.nextGeneration()    
        self.gui.txtGeneration.setText("Generation: " + str(self.ca.generation - 1))
        self.gui.txtNumQ0Cells.setText("Q0 Cells: " + str(self.ca.countQ0Cells))
        self.gui.txtNumQ1Cells.setText("Q1 Cells: " + str(self.ca.countQ1Cells))
        self.update()      
        
    def generateRandomEvolutionSpace(self, probQ1):
        self.ca.randomEvolutionSpace(probQ1)  
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
            self.ca.evolutionSpace[i][j] ^= 1
            
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
                    qPainter.fillRect(qrect, QColor(0,0,0))
                else:
                    qPainter.fillRect(qrect, QColor(255,255,255))
                    
                qPainter.drawRect(qrect)

    def paintEvent(self, event):
        self.renderEvolutionSpace(QPainter(self))
        
        
                    

        