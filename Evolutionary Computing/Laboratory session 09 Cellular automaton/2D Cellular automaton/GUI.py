from PyQt5 import QtWidgets, uic
from PyQt5.QtCore import QTimer
from EvolutionSpace import EvolutionSpace


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
        #Getting sliders to set probability of each state
        self.txtProbQ0 = self.findChild(QtWidgets.QLabel, 'txtProbQ0')
        self.sldProbQ0 = self.findChild(QtWidgets.QSlider, 'sldProbQ0')
        self.sldProbQ0.valueChanged.connect(self.sldProbQ0ValueChanged)
        
        self.txtProbQ1 = self.findChild(QtWidgets.QLabel, 'txtProbQ1')
        self.sldProbQ1 = self.findChild(QtWidgets.QSlider, 'sldProbQ1')
        self.sldProbQ1.valueChanged.connect(self.sldProbQ1ValueChanged)
        
        self.txtProbQ2 = self.findChild(QtWidgets.QLabel, 'txtProbQ2')
        self.sldProbQ2 = self.findChild(QtWidgets.QSlider, 'sldProbQ2')
        self.sldProbQ2.valueChanged.connect(self.sldProbQ2ValueChanged)
        #Geting state to known if the evolution space will be a toroid
        self.chkSpaceIsToroid = self.findChild(QtWidgets.QCheckBox, 'chkUseToroid')
        self.chkSpaceIsToroid.stateChanged.connect(self.checkSpaceIsToroidChanged)
        #Getting evolution conditions
        #Survival conditions
        self.spbSurvival1 = self.findChild(QtWidgets.QSpinBox, 'spbS1')
        self.spbSurvival1.valueChanged.connect(self.spbSurvival1Changed)
        self.spbSurvival2 = self.findChild(QtWidgets.QSpinBox, 'spbS2')
        self.spbSurvival2.valueChanged.connect(self.spbSurvival2Changed)
        #Born conditions
        self.spbBorn1 = self.findChild(QtWidgets.QSpinBox, 'spbB1')
        self.spbBorn1.valueChanged.connect(self.spbBorn1Changed)
        self.spbBorn2 = self.findChild(QtWidgets.QSpinBox, 'spbB2')
        self.spbBorn2.valueChanged.connect(self.spbBorn2Changed)
        #Update conditions
        self.spbUpgrade1 = self.findChild(QtWidgets.QSpinBox, 'spbU1')
        self.spbUpgrade1.valueChanged.connect(self.spbUpgrade1Changed)
        self.spbUpgrade2 = self.findChild(QtWidgets.QSpinBox, 'spbU2')
        self.spbUpgrade2.valueChanged.connect(self.spbUpgrade2Changed)
        #Remain conditions
        self.spbRemaining1 = self.findChild(QtWidgets.QSpinBox, 'spbR1')
        self.spbRemaining1.valueChanged.connect(self.spbRemaining1Changed)
        self.spbRemaining2 = self.findChild(QtWidgets.QSpinBox, 'spbR2')
        self.spbRemaining2.valueChanged.connect(self.spbRemaining2Changed)
        #Getting evolution space dimensions
        self.spbDimensions = self.findChild(QtWidgets.QSpinBox, 'spbDimensions')
        self.spbDimensions.valueChanged.connect(self.spbDimensionsChanged)
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
        #Getting label to display current generation
        self.txtNumQ2Cells = self.findChild(QtWidgets.QLabel, 'txtnQ2Cells')
        
        self.probQ0 = 0.0
        self.probQ1 = 0.0
        self.probQ2 = 0.0
        
        self.evolutionSpace.iEnd = self.scrollArea.width()
        self.evolutionSpace.jEnd = self.scrollArea.height()
        
        self.show()
    
    def vScrollBarValueChanged(self, value):
        self.evolutionSpace.jStart = value
    
    def hScrollBarValueChanged(self, value):
        self.evolutionSpace.iStart = value
        
    def spbDimensionsChanged(self, value):
        self.evolutionSpace.dimensionsChanged(value)
            
    def spbCellSizeChanged(self, value):
        self.evolutionSpace.cellSizeChanged(value)
    
    def spbSurvival1Changed(self, value):
        self.evolutionSpace.ca.s1 = value
        
    def spbSurvival2Changed(self, value):
        self.evolutionSpace.ca.s2 = value
        
    def spbBorn1Changed(self, value):
        self.evolutionSpace.ca.b1 = value
    
    def spbBorn2Changed(self, value):
        self.evolutionSpace.ca.b2 = value
        
    def spbUpgrade1Changed(self, value):
        self.evolutionSpace.ca.u1 = value    
    
    def spbUpgrade2Changed(self, value):
        self.evolutionSpace.ca.u2 = value    
        
    def spbRemaining1Changed(self, value):
        self.evolutionSpace.ca.r1 = value    
        
    def spbRemaining2Changed(self, value):
        self.evolutionSpace.ca.r2 = value    
        
    def checkSpaceIsToroidChanged(self, state):
        self.evolutionSpace.ca.spaceIsToroid = self.chkSpaceIsToroid.isChecked()
        
    def sldProbQ0ValueChanged(self):
        self.probQ0 = float(self.sldProbQ0.value()) / 100
        self.txtProbQ0.setText("Probability Q0: " + str(self.probQ0))
        
    def sldProbQ1ValueChanged(self):
        self.probQ1 = float(self.sldProbQ1.value()) / 100
        self.txtProbQ1.setText("Probability Q0: " + str(self.probQ1))
    
    def sldProbQ2ValueChanged(self):
        self.probQ2 = float(self.sldProbQ2.value()) / 100
        self.txtProbQ2.setText("Probability Q0: " + str(self.probQ2))
        
    def actionSimulation(self):
        if self.btnAction.text() == "Start":
            self.btnAction.setText("Stop")
            self.timer.timeout.connect(self.evolutionSpace.nextGeneration)
            self.timer.start(100)
        else:
            self.btnAction.setText("Start")
            self.timer.stop()
            
    def generateEvolutionSpace(self):
        self.evolutionSpace.generateRandomEvolutionSpace(self.probQ0, self.probQ1, self.probQ2)
    