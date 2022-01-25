module domotica

  class Habitacion

    attr_reader :idHabitacion, :luminosidadActual

    def initialize(id, luminosidad)
      @idHabitacion = id
      @luminosidadActual = luminosidad
      @bombillas = Array.new
      @instalacion_persiana = nil
    end

    #No es posible implementar el diagrama tan cual en Ruby,
    #porque en Ruby no existe la visibilidad de paquete
    def ajustarLuzNatural(nivel)
    end

    def ajustarLuzArtificial(nivel)
    end

    def comprobarMantenimiento
    end

    def incluirBombilla(localizacion)
    end

    def incluirPersiana(fechaEstimadaDuracion)
    end

  end

end
