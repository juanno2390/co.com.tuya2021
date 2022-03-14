#Author: Juan Esteban Acevedo Muñoz
# encodig: utf-8
# language: es

@PruebaInterna
Característica: Yo como cliente del almacén demoblaze
  Necesito visualizar los precios de los productos de la categoría Laptops
  Para tomar decisiones de compra

  @Test
  Esquema del escenario: Validacion de productos de la categoria "<categoria>" en navegador <navegadorEligido>
    Dado el usuario se encuetra en la página de portal demoblize
    Cuando el usuario seleccione la categoria <categoria>
    Entonces el usuario debera identificar en la posicion <idPosicion> de la grilla de productos resultantes
          | imagen_esperado   | nombre_esperado   | precio_esperado   | descripcion_esperado   |
          | <imagen_esperado> | <nombre_esperado> | <precio_esperado> | <descripcion_esperado> |

    Ejemplos:
      | categoria | idPosicion | imagen_esperado      | nombre_esperado | precio_esperado | descripcion_esperado                                                               |
      | Laptops   | 1          | imgs/sony_vaio_5.jpg | Sony vaio i5    | $790            | Sony is so confident that the VAIO S is a superior ultraportable laptop that the   |
      | Laptops   | 3          | imgs/macbook_air.jpg | MacBook air     | $700            | 1.6GHz dual-core Intel Core i5 (Turbo Boost up to 2.7GHz) with 3MB shared L3 cache |
