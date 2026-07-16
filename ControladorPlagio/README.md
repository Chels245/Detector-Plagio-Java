-Detector de Plagio de Código Fuente mediante Isomorfismo de Grafos

Aplicación de escritorio desarrollada en Java utilizando interfaces gráficas nativas de Swing. El sistema automatiza la detección de copias lógicas y camuflaje estructural en programas independientes mediante la abstracción de Grafos de Flujo de Control (CFG) y el análisis métrico de correspondencia topológica.

-Requisitos Previos

Para instalar y ejecutar este proyecto en su entorno local, se requiere disponer de los siguientes componentes:
* Java Development Kit (JDK): Versión 8 o superior instalado en el sistema operativo.
* Entorno de Desarrollo (IDE): NetBeans, Eclipse, IntelliJ IDEA o herramientas compatibles con la gestión de proyectos Java Estándar.

-Instalación y Configuración

Siga estos pasos secuenciales para configurar el entorno de ejecución desde este repositorio:

1. Obtención del Código Fuente:
   *Haga clic en el botón verde `Code` situado en la parte superior de este repositorio de GitHub.
   *Seleccione la opción `Download ZIP` para descargar el árbol de archivos completo, o clone el repositorio directamente utilizando el comando en su terminal Git: https://github.com/Chels245/Detector-Plagio-Java.git.

3. Apertura en el IDE:
   * Inicie su Entorno de Desarrollo (IDE).
   * Seleccione la opción `File > Open Project` (Abrir Proyecto).
   * Navegue hasta el directorio local donde descargó y extrajo la carpeta raíz del repositorio y selecciónela. El IDE reconocerá automáticamente la estructura del proyecto.

4. Resolución de Dependencias: El proyecto ha sido desarrollado utilizando de forma exclusiva las librerías nativas de la API estándar de Java (`java.util.*`), por lo cual no requiere la configuración ni descarga de librerías externas o repositorios Maven/Gradle, garantizando una portabilidad inmediata.

- Ejecución del Sistema

Para levantar la aplicación y visualizar el flujo lógico:
1. Localice el archivo principal de ejecución situado en la ruta: `src/main/Main.java`.
2. Haga clic derecho sobre el archivo `Main.java` y seleccione la opción `Run File` (Ejecutar Archivo), o presione la combinación de teclas correspondiente de su IDE (por ejemplo, `Shift + F6` en NetBeans).
3. El hilo de eventos de Swing inicializará de manera asíncrona la ventana del Menú Principal del software.
