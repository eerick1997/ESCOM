from PyQt5 import QtWidgets
import sys

import GUI as gui

app = QtWidgets.QApplication(sys.argv)
window = gui.Ui()
app.exec_()