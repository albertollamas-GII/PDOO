# Implementación del diagrama DC - Villanos

module Villanos

  class Villano

      attr_writer :fortuna #setFortuna

      #Ojo con no poner atributos de instancia fuera de los métodos, entonces
      #no serían atributos de instancia, sino de instancia de la clase.

      def initialize(nombre, escondite, fortuna, mayordomo)
        @nombre = nombre
        @esconditeSecreto = escondite
        @fortuna = fortuna
        @mayordomo = mayordomo
        @planes = Array.new
      end

      def seguirPlanPrioritario
      end

      def primerPlanActivo
      end

      # Este método no está en el diagrama de clases, se
      # ha añadido para que puedas probar el código en la clase Main,
      # viendo las implicaciones del uso de clases de módulos distintos
      def to_s
        "#{@nombre} servido por #{@mayordomo.to_s}"
      end

  end

end
