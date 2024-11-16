# SegundoParcialTopicos
# Aplicación de Registro y Consulta de Personajes

## Descripción

Esta aplicación móvil, desarrollada en Kotlin con vistas en XML, permite registrar y consultar información de personajes. Ofrece dos opciones de navegación: mediante Tabs.

## Características

* **Navegación flexible:** Permite elegir entre navegación por Tabs.
    * Si se usa Tabs, la barra de navegación (NavBar) se oculta.
* **Secciones principales:**
    * **Presentación:** Muestra información del proyecto y del desarrollador.
    * **Registro de personaje:** Permite registrar personajes con nombre, descripción, tipo (Principal, Secundario, Extra) e imagen.
    * **Consulta de personajes:** Muestra un listado de los personajes registrados con su información e imagen.
* **Almacenamiento local:** Utiliza SQLite para guardar la información de los personajes en el dispositivo.
* **Interfaz de usuario:**
    * Implementada con Fragments y una única Activity.
    * Las listas de personajes se muestran con RecyclerView.
    * Se siguen buenas prácticas de desarrollo, como el uso correcto de recursos (values y drawable).

## Instalación

1. Clona este repositorio: `git clone [URL del repositorio]`
2. Abre el proyecto en Android Studio.
3. Compila y ejecuta la aplicación en un dispositivo o emulador Android.

## Uso

1. **Presentación:** Al iniciar la aplicación, se muestra la información del proyecto y del desarrollador.
2. **Registro de personaje:** Navega a la sección de registro y completa el formulario con la información del personaje. Selecciona los tipos de personaje que correspondan y carga una imagen desde tu dispositivo.
3. **Consulta de personajes:** Navega a la sección de consulta para ver la lista de personajes registrados. Cada elemento muestra la imagen, el nombre, la descripción y los tipos de personaje en chips.

## Tecnologías utilizadas

* Kotlin
* Vistas en XML
* SQLite
* Fragments
* Activity
* RecyclerView
* Tabs / Drawer Navigation
* CheckBox
* ImageView
* ChipGroup

