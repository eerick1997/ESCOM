from PyQt5 import QtWidgets, uic, QtCore
from EvolutionSpace import EvolutionSpace
from PyQt5.QtWidgets import *
from PyQt5.QtCore import *
from PyQt5.QtGui import *

class Ui(QtWidgets.QMainWindow):
    def __init__(self):
        super(Ui, self).__init__()
        uic.loadUi('Practice09.ui', self)
        self.timer = QTimer()
        
        #Getting the widget to paint the evolution space
        self.evolutionSpace = EvolutionSpace(self)
        
        self.scrollArea = self.findChild(QtWidgets.QScrollArea, 'scrollArea')
        self.scrollArea.setWidget(self.evolutionSpace)
        self.scrollArea.setWidgetResizable(True)
        #Signals to nextGeneration button
        self.btnNextGeneration = self.findChild(QtWidgets.QPushButton, 'btnNextGeneration')
        self.btnNextGeneration.clicked.connect(self.evolutionSpace.nextGeneration)
        #Signals to start button
        self.btnAction = self.findChild(QtWidgets.QPushButton, 'btnAction')
        self.btnAction.clicked.connect(self.actionSimulation)
        #Signals to generate a random evolution space
        self.btnRandomEvolutionSpace = self.findChild(QtWidgets.QPushButton, 'btnGetRandomSpace')
        self.btnRandomEvolutionSpace.clicked.connect(self.generateEvolutionSpace)
        #Getting sliders to set probability of Q1 state
        
        self.txtProbQ1 = self.findChild(QtWidgets.QLabel, 'txtProbQ1')
        self.sldProbQ1 = self.findChild(QtWidgets.QSlider, 'sldProbQ1')
        self.sldProbQ1.valueChanged.connect(self.sldProbQ1ValueChanged)
        
        #Geting state to known if the evolution space will be closed
        self.chkSpaceIsClosed = self.findChild(QtWidgets.QCheckBox, 'chkClosed')
        self.chkSpaceIsClosed.stateChanged.connect(self.checkSpaceIsClosedChanged)
        
        #Getting cell size
        self.spbCellSize = self.findChild(QtWidgets.QSpinBox, 'spbCellSize')
        self.spbCellSize.valueChanged.connect(self.spbCellSizeChanged)
        #Getting vertical and horizontal scroll bars
        self.vScrollBar = self.scrollArea.verticalScrollBar()
        self.vScrollBar.valueChanged.connect(self.vScrollBarValueChanged)
        self.hScrollBar = self.scrollArea.horizontalScrollBar()
        self.hScrollBar.valueChanged.connect(self.hScrollBarValueChanged)
        #Getting label to display current generation
        self.txtGeneration = self.findChild(QtWidgets.QLabel, 'txtGeneration')
        #Getting label to display current generation
        self.txtNumQ0Cells = self.findChild(QtWidgets.QLabel, 'txtnQ0Cells')
        #Getting label to display current generation
        self.txtNumQ1Cells = self.findChild(QtWidgets.QLabel, 'txtnQ1Cells')
        
        #Getting layout to add rules
        self.layoutRules = QtWidgets.QVBoxLayout()
        self.widget = QtWidgets.QWidget()
        self.widget.setLayout(self.layoutRules)
        self.rulesArray = []
        
        maxConfigurations = 0
        
        while maxConfigurations < 64:
            currValue = maxConfigurations
            labelCheckBox = ""
            maxBits = 5
            while maxBits > 0:
                labelCheckBox += str(currValue & 1)
                currValue >>= 1
                maxBits -= 1
            self.evolutionSpace.ca.bitmaskCodes[currValue] = 0
            checkBox = QtWidgets.QCheckBox(labelCheckBox[::-1])
            checkBox.stateChanged.connect(self.checkBoxRuleChanged)
            self.rulesArray.append(checkBox)
            self.layoutRules.addWidget(checkBox)
            maxConfigurations += 1
            
        self.scrollRules.setWidget(self.widget)
        self.scrollRules.setWidgetResizable(True)
        
        self.txtRule = self.findChild(QtWidgets.QLineEdit, 'txtRule')
        self.txtRule.installEventFilter(self)
        
        self.probQ1 = 0.0
        
        self.evolutionSpace.iEnd = self.scrollArea.width()
        self.evolutionSpace.jEnd = self.scrollArea.height()
        
        self.btnSetRule = self.findChild(QtWidgets.QPushButton, 'btnSetRule')
        self.btnSetRule.clicked.connect(self.setRule)
        self.show()
    
    def setRule(self):
        self.evolutionSpace.ca.rule = int(self.txtRule.text())
    
    def checkBoxRuleChanged(self):
        decimalValue = 0
        currBit = 0
        for chkBoxRule in (self.rulesArray):
            decimalValue |= chkBoxRule.isChecked() << currBit
            self.evolutionSpace.ca.bitmaskCodes[currBit] = chkBoxRule.isChecked() & 1
            currBit += 1
        self.txtRule.setText(str(decimalValue))
    
    def eventFilter(self, obj, event):
        if event.type() == QtCore.QEvent.KeyPress and obj is self.txtRule:
            if event.key() == QtCore.Qt.Key_Return and self.txtRule.hasFocus():
                rule = self.txtRule.text().strip()
                if len(rule) > 0:
                    value = int(rule)
                    i = 0
                    while value > 0:
                        self.rulesArray[i].setChecked(value & 1)
                        value >>= 1
                        i += 1
        return super().eventFilter(obj, event)
    
    def vScrollBarValueChanged(self, value):
        self.evolutionSpace.jStart = value
    
    def hScrollBarValueChanged(self, value):
        self.evolutionSpace.iStart = value
        
    def spbDimensionsChanged(self, value):
        self.evolutionSpace.dimensionsChanged(value)
            
    def spbCellSizeChanged(self, value):
        self.evolutionSpace.cellSizeChanged(value)
        
    def checkSpaceIsClosedChanged(self, state):
        self.evolutionSpace.ca.spaceIsClosed = self.chkSpaceIsClosed.isChecked()
        
    def sldProbQ1ValueChanged(self):
        self.probQ1 = float(self.sldProbQ1.value()) / 100
        self.txtProbQ1.setText("Probability Q1: " + str(self.probQ1))
        
    def actionSimulation(self):
        if self.btnAction.text() == "Start":
            self.btnAction.setText("Stop")
            self.timer.timeout.connect(self.evolutionSpace.nextGeneration)
            self.timer.start(100)
        else:
            self.btnAction.setText("Start")
            self.timer.stop()
            
    def generateEvolutionSpace(self):
        self.evolutionSpace.generateRandomEvolutionSpace(self.probQ1)
    