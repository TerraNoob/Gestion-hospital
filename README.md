# Gestion-hospital
Proyecto de **Programación Avanzada**

INF2236 · PUCV · Segundo semestre 2026

---

## Objetivo

El proyecto consiste en un sistema de gestión hospitalaria (SIA). Su objetivo es permitir que el personal encargado registre, consulte y administre las áreas clínicas, la ocupación de camas y el estado de los pacientes de manera ordenada.

El sistema trabaja principalmente con tres tipos de datos:

* **Áreas:** identificadas por un código único, nombre, capacidad máxima y una colección de camas.


* **Camas:** identificadas por un ID, categoría (básica, crítica, pediátrica), estado de disponibilidad y paciente asignado.


* **Pacientes:** identificados por su RUT, nombre, edad, signos vitales y gravedad, divididos en atención de adultos o pediátrica.


La relación principal del sistema es que un área médica contiene varias camas clínicas y cada cama puede albergar a un paciente, manteniendo además una lista de pacientes en espera para su asignación.

## Grupo

| Amanda Letelier|
| Benjamín González |
| Martín Lira|

## Herramientas utilizadas

JDK 8 · Eclipse IDE

---

## INSTRUCCIONES DE INSTALACION Y USO

### Cómo abrir el proyecto

1. Extraer el ZIP en una carpeta de tu computador.
2. Abrir Eclipse.
3. Seleccionar `File` > `Import...`.
4. Desplegar la carpeta `General`, elegir `Existing Projects into Workspace` y presionar `Next`.
5. En `Select root directory`, hacer clic en `Browse...` y buscar la carpeta extraída del proyecto.
6. Seleccionar el proyecto y presionar `Finish`.

### Cómo ejecutar el proyecto

1. Seleccionar `Run As` > `Java Application`.
2. Interactua con el sistema mediante la pestaña `Console` en la parte inferior de Eclipse, ahí podrás elegir si utilizarlo vía consola/ventana.
