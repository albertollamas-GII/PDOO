module Villanos
  class Paso
    def initialize(descripcion, fechaLimite, inversion, ganancia)
      @descripcion = descripcion
      @fechaLimite = fechaLimite
      @inversion = inversion
      @ganancia = ganancia
      @terminado = false
    end
    attr_reader :inversion, :ganancia
    attr_writer :terminado
  end
end
