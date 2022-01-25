# Implementación del diagrama DC - Villanos

module Esbirros

  # El método to_s y el atributo nombre no están en el diagrama de clases,
  # se han añadido para que puedas probar el código en la clase Main,
  # viendo las implicaciones del uso de clases de módulos distintos

  class Mayordomo
    def initialize(n)
      @nombre = n
    end

    def to_s
      "#{@nombre}"
    end
  end

end
