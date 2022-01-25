module domotica

  class Domo

    def initialize
      @habitaciones = Array.new #Atributo de referencia
    end

    #Los métodos por defecto en Ruby son públicos...
    def gestionarMantenimiento
    end

    def subirLuz(nivel, idHabitacion)
    end

    def bajarLuz(nivel, idHabitacion)
    end

    def incluirHabitacion(idHabitacion)
    end

    def incluirBombilla(idHabtiacion, localizacion)
    end

    def incluirPersiana(idHabitacion, fechaEstimadaDuracion)
    end

    #... a no ser que indiquemos lo contrario
    private #OJO! todos los métodos que declare después de esta palabra clave serán privados

    def buscarHabitacion(idHabitacion)
    end

  end
end
