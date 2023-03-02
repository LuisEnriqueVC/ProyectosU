#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat Jul 30 14:59:22 2022

@author: el-vak
"""

#funciones en python

#importar librerias
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from scipy import stats
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn import metrics

#cargando el set de datos
fichero= '/home/el-vak/Documentos/datasets/train-data.csv'

#inicio de funciones
def cargaDatos(ruta, fichero,separador=','):  #escribir bien la ruta // y el nombre del dataset que quieres cargar
    datos = pd.read_csv(ruta+fichero,sep=separador)
    return datos

def dameColumnas(datos):#si no encuentras las columnas es porque no hay
    return datos.columns

def cambiaNombreColumnas(datos,columnas):
    datos.columns = columnas
    return datos

def renombrarcolumna(datos,cambio):
    datos.rename(columns=cambio,inplace=True)
    return datos

def guardarDatos(datos,ruta,fichero):
    datos.to_csv(ruta+fichero)
    return True

def remplazarNulos(columna):
    media = columna.mean()
    columna.replace(np.nan, media, inplace=True)
    return columna

#falta probar con dataset sucio
def localiza_duplicados_Xfilas(datos,columns):
    new_val = datos.duplicated(subset=columns, keep='first')
    datos_duplicados= datos.loc[new_val == True]
    return datos_duplicados


def cambiaTipoDatoFloat(columna, tipo='float64'):#revisar
    #columna = columna.astype(tipo)
    #datos['potencia']= pd.to_numeric(datos['potencia'],errors = 'coerce'))
    columna = pd.to_numeric(columna,errors='coerce')
    return columna

def normalizacionColumna(columna):#dependiendo los valores de dataset
   columna=columna/columna.max()
   return columna

def obtenerDummies(datos,columna):
    columnas = pd.get_dummies(columna)
    return columnas

def Nulos(columna):
    data=columna.fillna(method='ffill',inplace=True)
    return data

def Nulos2(columna):
    data=columna.fillna(0,inplace=True)
    return data

def crearDataSet(filas, columnas,nombre_columnas,inicial=0,final=1000):
    datos= pd.DataFrame(np.random.randint(inicial,final,(filas,columnas)),columns=nombre_columnas)
    return datos

def agruparDatos(datos, columna):
    datos_agrupados= datos.groupby(columna,as_index=False)
    return datos_agrupados

#VISUALIZACIONES DE DATOS
def graficaBoxPlot(columna, titulo=''):
    plt.boxplot(columna)
    plt.title(titulo)
    plt.show()

def graficaScatter(x,y,titulo='',etiquetaX='X',etiquetaY='Y'):
    plt.scatter(x, y)
    plt.title(titulo)
    plt.xlabel(etiquetaX)
    plt.ylabel(etiquetaY)
    plt.show()    


#regresiones
def regresionLineal(X,y):
    X_train, X_test, y_train, y_test = train_test_split(X,y, 
                    test_size=0.2,random_state=0)
    X = X
    y = y
    lm= LinearRegression()
    lm.fit(X_train, y_train)
    return lm

def damePredicciondeRL(lm,X):
    prediccion=lm.predict(X)
    #print(lm.score(X, y))
    return prediccion


#Estadisticos
def coeficientePearson(columna1,columna2):
    pearson_coef,p_valor= stats.pearsonr(columna1,columna2)
    return pearson_coef,p_valor

def dimeEstadisticas(datos,tipo ='numerico'):
    if tipo =='numerico':
     return datos.describe()
    else:
     return datos.describe(include='all')
 
def errorCuadratico(y_real,prediccion):
   ECM= metrics.mean_squared_error(y_real, prediccion)
   #print(ECM)
   return ECM
def rCuadrado(y_real,prediccion):
    r_cuadrado= metrics.r2_score(y_real, prediccion)
    #print(r_cuadrado)
    return r_cuadrado

#----------------------------PRUEBAS----------------------------------------------
#datos=cargaDatos('//home//el-vak//Descargas//','Data Science Jobs Salaries.csv')
#cargando datos en un dataframe pandas (pd)
#print(datos.head)#visualiza tus datos
#print(datos.dtypes)#visualiza tus columnas y sus tipos de dato que albergan
#print('*'*40)
#para ver las columnas y sus datos 
#print(datos.work_year)
#print(datos.experience_level)
#print(datos.salary_currency,datos.company_size,datos.remote_ratio)
#ya vistos los encabezados puedes cambiar el nombre de estos
#nuevosEncabezados = ['anio_laboral','nivel_experiencia', 'tipo_de_empleo',
#                     'puesto', 'salario', 'moneda_de_pago', 'salario_en_usd',
#                     'recidencia_del_empleado','proporcion_de_remitente',
#                     'localizacion_compania','tamanio_compania']

#cambiaNombreColumnas(datos, nuevosEncabezados)
#print(datos.dtypes)
#datos.isnull().sum()#verifica que no existan nulos
                    #encontrar codigo para encontrar espacios
                    #quitar espacios (youtube tutorial encontrado)
                    #si un valor no coincide con los otros
#cambia un simbolo por otro
#datos['anio_laboral'] = datos['anio_laboral'].apply(lambda x: x.replace("$",""))
datos['salario']=cambiaTipoDatoFloat(datos['salario'])
print(datos['nivel_experiencia'].duplicated())#datos duplicados 
#cambiaTipoDato(datos['nivel_experiencia'])
#print(datos.dtypes)
# new_val = datos[datos.duplicated(datos['nivel_experiencia'])]
# print("datos duplicados:")
# print(new_val)
#print (datos.duplicated(datos['nivel_experiencia']))
#print(datos['nivel_experiencia'])

#datos.columns
#print(datos)
#type(datos)

# if __name__ == '__main__':
#     ruta = '//home//el-vak//Documentos//datasets//'
#     fichero = 'train-data.csv'
#     datos=cargaDatos(ruta,fichero)
#     print(datos.head(7))
#     print('*'*40)
    
#     print(dameColumnas(datos))
    
#     #guardarDatos(datos, ruta, 'ficheroCopiaFunciones.csv')
    
#     #ejemplo para la libreria cambianombrescolumnas
#     titulos_cabecera = ['Indice', 'nombre', 'Localizacion', 'anio', 'Kilometros recorridos',
#            'combustible', 'Transmicion', 'tipo escape', 'Millas', 'motor','potencia',
#            'asientos', 'Nuevo precio','precio']
#     cambiaNombreColumnas(datos, titulos_cabecera)
#     print(datos.dtypes)
    
#    # print(dimeEstadisticas(datos))
#     #print(dimeEstadisticas(datos, 'todos'))

#     #remplazarNulosPorMedia(datos,'todos')
#    # columna=datos['Kilometros recorridos']
#     #cambiaTipoDato(columna, 'float')
#     #print(columna.dtypes)
#     #print(columna)
    
#     #renombrarcolumna(datos,{'Kilometros recorridos':'Kilometros'})
#     #print(datos.dtypes)
    
#     #datos=normalizacionColumna(datos, 'Kilometros')
#     #print(datos['Kilometros'])
    
#     graficaBoxPlot(datos['Kilometros recorridos'],'Potencia')
    
#     datos= crearDataSet(100, 5, ['A','B','C','D','E'])
#     print(datos.head())
#     x= datos['A']
#     y= datos['E']
#     graficaScatter(x, y,titulo='Pruebas')
    
#     print(coeficientePearson(x, y))
    
#     X = np.array(x).reshape(1,-1).T#.t es para realizar la transpuestas porque los shapes se voltearon al hacer la funcion
#     lm=regresionLineal(X, y)
#     prediccion = damePredicciondeRL(lm, X)
#     print(y,prediccion)
    
#     print(rCuadrado(y,prediccion))

#pruebas de nuevos codigos 2023-febrero
#new_val = datos.duplicated(subset=datos.columns, keep='first')
#datos_duplicados= datos.loc[new_val == True]
    
    
    
    