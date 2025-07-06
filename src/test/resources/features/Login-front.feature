  # language: es

  Característica: Funcionalidad del login


  Necesidad del negocio: Como usuario del sistema OrangeHRM
  Quiero poder iniciar sesión y actualizar mis datos de telefono, correo y dirección
  Para asegurarme de que mi información personal esté actualizada correctamente

  @tag
  Escenario: Actualizar mis datos de telefono, correo y dirección

    Dado que el usuario inicia sesión
    Cuando actualiza sus datos
    Entonces valido que los datos se actualizaron correctamente



