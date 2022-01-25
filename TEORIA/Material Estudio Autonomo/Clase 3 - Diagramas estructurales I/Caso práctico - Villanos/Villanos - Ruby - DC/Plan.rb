# Implementación del diagrama DC - Villanos

module Villanos

  class Plan

      attr_reader :terminado #getTerminado

      #Ojo con no poner atributos de instancia fuera de los métodos, entonces
      #no serían atributos de instancia, sino de instancia de la clase.

      def initialize(nombre, fecha, prioridad, objetivo)
        @nombre = nombre
        @fechaConsecucion = fecha
        @prioridad = prioridad
        @posicionPasoSiguiente = 0
        @terminado = false # Si el atributo toma un valor inicial, no hace falta pasárselo como argumento al constructor
        @pasos = Array.new
        @objetivo = objetivo
      end

      def estaActivo
      end

      def darPasoSiguiente
      end

      def inversionPasoSiguiente
      end

  end

end
