#language:es

Característica: Inicio de sesion Banistmo
  Yo como automatizador
  Quiero hacer pruebas con Playwright y Screenplay
  Para conocer el nuevo framework

  @LoginBanistmo
  Escenario: Auntenticacion Exitosa
    Cuando Andres ingresa con el usuario: elizabeth1234 y la clave: Prueba123##
    Entonces el puede observar sus productos

  @LoginBanistmo2
  Escenario: Auntenticacion Exitosa full playwright
    Cuando Andres ingreso con el usuario: elizabeth1234 y la clave: Prueba123##
    Entonces  el puede observar sus productos con playwright