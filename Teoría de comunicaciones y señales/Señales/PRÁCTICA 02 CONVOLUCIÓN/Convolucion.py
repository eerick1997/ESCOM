# -*- coding: utf-8 -*-
"""
Created on Sat Jun 16 12:58:27 2018

@author: Díaz Medina Jesús Kaimorts
         Hernández Castro Karla Beatriz
         Gómez Ramírez Oswaldo
         Silva Villegas Andree Giovanni
         Vargas Romero Erick Efraín
         
@subject: Theory of Comunications and Signals.
@group: 3CV7.
@title: Second departamental project
@school: Escuela Superior de Cómputo


@Steps:
    1. Run the code
    **Specify the center of function with '*' after the numer
    2. Input the X[n] discrete function
       Input the H[n] discrete function
       
       If the user does not specify the center, 
       the half of the arrangement is set by default: floor.
"""

#Import necessary dependencies
from pylab import *
import matplotlib.pyplot as plt
import numpy as np

#Functions
def whereIsCenter(list):
    indice = 0
    while indice < len(list):
        if '*' in list[indice]:
            return indice
        indice += 1
    return 0


def convertFunc(list):
    indice = 0
    while indice < len(list):
        if '*' in list[indice]:
            list[indice] = list[indice].replace('*','')
        indice += 1
    return list


"""
@name: infoGn
@desc: This function gives information like:
            - G(n) : Elements of function
            - Center G(n): Central element of function
            - Gi : Start index where the function starts from
            - Gf : Final index where the function starts from
            
@param: list, (int)center,Gi,Gf
"""
def infoGn(list,center,Gi,Gf):
    print("G(n) = ",list)
    print("Center G(n): ",center)
    print("Gi: ",Gi)
    print("Gf: ",Gf)

"""
@name: rangeToGraph
@desc: This function return the Xi, initial index, and Xf, final index.
       In others words, indicates where the function starts from,
       and where it ends from
@param: list, (int)center
@return: arange
"""
def rangeToGraph(list,int):
    Gi = getGi(list,int)  #Xi : Inicio de X(n)
    Gf = getGf(list,int)  #Xf : Fin de X(n)
    
    return np.arange(Gi,Gf)


"""
@name: getGi
@desc: This function return the Xi, initial index
@param: (list)Xn, (int)center
@return: Gi: Initial index
"""
def getGi(Xn,center):
    Gi = 0
    if center!=0:
        while Gi < center:         #Vemos desde donde inicia la funcion X(n)
            Gi += 1
        Gi = (-1)*Gi
    else:
        Gi = 0
    
    return Gi

"""
@name: getGf
@desc: This function return the Xf, final index
@param: (list)Xn, (int)center
@return: Gi: Final index
"""
def getGf(Xn,center):
     return len(Xn)-center
     

#Getting inputs of function to convolve
Xn = input("X[n]: ").split(",")
Hn = input("H[n]: ").split(",")

#Getting of function's centers
centerX = whereIsCenter(Xn)
centerH = whereIsCenter(Hn)

if(centerX==0):
    centerX = (int)(len(Xn)/2)   
if(centerH==0):
    centerH = (int)(len(Hn)/2)
    
Xi = getGi(Xn,centerX)  #Xi : Start of X(n)
Xf = getGf(Xn,centerX)  #Xf : End of X(n)
Hi = getGi(Hn,centerH)  #Hi : Start of H(n)
Hf = getGf(Hn,centerH)  #Hf : End of H(n)

rangeXn = rangeToGraph(Xn,centerX)  #Getting range to draw X(n)
rangeHn = rangeToGraph(Hn,centerH)  #Getting range to draw H(n)

#Convert the necessary functions
Xn = [float(i) for i in convertFunc(Xn)] #Convert list to float list
Hn = [float(i) for i in convertFunc(Hn)] #Convert list to float list

"""
#Information of X(n) and H(n)
print("\n_____DATA X(n)_____\n")
infoGn(Xn,centerX,Xi,Xf)
print("\n_____DATA H(n)_____\n")
infoGn(Hn,centerH,Hi,Hf)
"""

#Draw both functions: X(n) and H(n)

#Draw X(n) function
#plt.figure(1)
plt.figure(1)
plt.subplot(121)
markerline, stemlines, baseline = plt.stem(rangeXn, Xn, '-.')
plt.setp(baseline, color='r', linewidth=2)
plt.title("X[n]")
plt.grid(True)

print("\n\n")
#Draw H(n) function
#plt.figure(2)
plt.subplot(122)
markerline, stemlines, baseline = plt.stem(rangeHn, Hn, '-.')
plt.setp(baseline, color='b', linewidth=2)
plt.title("H[n]")
plt.grid(True)

plt.show()

#Convolution of function
Yn = np.convolve(Xn,Hn).tolist()
Yi = Xi+Hi
Yf = Xf+Hf-1
rangeYn = np.arange(Yi,Yf)

print("\nY[n]: ",Yn)
print("Yi: ",Yi)
print("Yf: ",Yf)
print("Range: ",rangeYn)


plt.figure(2)
markerline, stemlines, baseline = plt.stem(rangeYn, Yn, '-.')
plt.setp(baseline, color='r', linewidth=2)
plt.title("Y[n] = X[n]*H[n]")
plt.grid(True)
plt.show()
