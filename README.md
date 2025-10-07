# Reglas del juego

Al iniciar, ingresa tu nombre de usuario.

Cada nivel contiene 5 sumas.

Tienes un tiempo límite (iniciando en 10 segundos por pregunta).

Cada respuesta correcta = +100 puntos.

Si completas las 5 sumas correctamente, avanzas al siguiente nivel y el tiempo se reduce en 2 segundos (mínimo 2s).

Si se acaba el tiempo o fallas una respuesta, el juego termina.

El juego mantiene un ranking de los 5 mejores jugadores usando una lista doblemente enlazada.

# Ejemplo de partida

Ingresa tu nombre de usuario: Julian

Nivel 1 | Tiempo: 10s
¿Cuánto es 12 + 7? 19
✅ ¡Correcto!

Nivel 1 | Tiempo: 10s
¿Cuánto es 25 + 30? 55
✅ ¡Correcto!

 ¡Avanzas al nivel 2! Nuevo tiempo: 8s


# Juego de Sumas Rápidas

**Juego de Sumas Rápidas (Fast Sums Game)** es un sencillo **juego de consola en Java** que reta al jugador a resolver sumas lo más rápido posible.  
Cada respuesta correcta aumenta tu puntaje y te permite avanzar de nivel, pero el tiempo límite disminuye en cada nivel.

---

## Cómo compilar y ejecutar

### 1. Compilar
Desde la raíz del proyecto (donde está `FastSumsGame/Main.java`), ejecutar:

```bash
javac FastSumsGame/Main.java
java -cp FastSumsGame Main
