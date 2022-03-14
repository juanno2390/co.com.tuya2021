# co.com.proyectobase.tuya2021
# 06/10/2021 
# Juan Esteban Acevedo Muñoz


proyecto de automatización Cucumber + Serenity en lenguaje Java y gestor de dependencias Gradle (patron Screenplay)

Realizado en intellij IDEA 2019.3.3 (COMUNITY EDITION) con
gradle v6.4.1,
maven v3.6.3,
jdk v1.8,
jvm/jre v1.8.0_241,
Ejecucion en Navegador Google Chrome:ChromeDriver

::IMPORTANTE::
Pasos para su correcto funcionamiento y utilizacion:
-Asegurarse de tener instalado y configurado las variablers de entorno jdk, gradle y mavencomo con las versiones igual o superiores a las utilizadas en el proyecto. 

-Clonar desde github a traves del enlace https://gitlab.com/juanno2390/co-com-tuya2021-10-06.git en su maquina local

-Importar el proyecto con gradle (preferencia en Intellij)

- El setting.Gradle contiene: rootProject.name = 'co.com.proyectobase.tuya2021'


-Para la ejecución se puede dirigir a los Runners a continuacion (todos comparten el mismo .feature y se diferencian en la estructura utilizada para la automatización)
		*Automatizacion en Screenplay:        src->test->java->co.com.proyectobase->screenplay->runners->RunnerTags
        *features:                            src->test->resources->features->appTest.feature

-Para visualizacion del reporte en serenity de la ultima ejecucion realizadas: Abrir "index.html" ubicado en la siguiente ruta:
	target->site->serenity->index.html
	Nota: En intellij puede requerir en settings Buid toold Gradle->Run test using: Gradle(Default)
	

Quedo atento a cualquier inquietud, pueden escribirme al correo juanno23@hotmail.com



