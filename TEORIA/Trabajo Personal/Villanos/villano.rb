module Villanos
  class Villano
    def initialize(nombre, esconditeSecreto, fortuna,mayordomo)
      @nombre = nombre
      @esconditeSecreto = esconditeSecreto
      @fortuna = fortuna
      @mayordomo = mayordomo
      @planes = Array.new
    end

    attr_writer :fortuna

    def seguirPlanPrioritario
    end

    def primerPlanActivo
    end
  end
end