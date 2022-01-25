# Implementación del diagrama DC - Villanos

module Villanos

  class Paso

      attr_reader :inversion, :ganancia
      attr_writer :terminado

      #Ojo con no poner atributos de instancia fuera de los métodos, entonces
      #no serían atributos de instancia, sino de instancia de la clase.

      def initialize(descripcion, fecha, inversion, ganacia)
        @descripcion = descripcion
        @fechaLimite = fecha
        @terminado = false
        @inversion = invesrion
        @ganacia = ganancia
      end

  end

end
