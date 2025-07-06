  # language: es

  Característica: Funcionalidad de pokemon


  Necesidad del negocio: Yo como usuario necesito consultar la informacion de un pokemon

    @tag
    Escenario: Consultar al Pokémon  Bulbasour  desde el endpoint teniendo en cuenta que en la pokedex bulbasaur es el primer pokemon

      Dado que obtengo el endpoint desde la base de datos
      Cuando consulto el servicio de especies Pokémon
      Entonces el primer Pokémon de la respuesta debe ser "bulbasaur"


