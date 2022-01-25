module Villanos
  class Plan
    def initialize(nombre, fechaConsecucion, prioridad, objetivo)
      @nombre = nombre
      @fechaConsecucion = fechaConsecucion
      @prioridad = prioridad
      @posicionPasoSiguiente = 0
      @terminado = false # si es boolean se le asigna un valor inicial y no se le pasa como parametro
      @pasos = Array.new
      @objetivo = objetivo
    end
    attr_reader :terminado
    #metodos basura
  end
end
