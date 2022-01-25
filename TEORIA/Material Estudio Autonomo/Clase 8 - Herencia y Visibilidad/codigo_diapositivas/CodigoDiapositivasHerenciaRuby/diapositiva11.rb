# encoding: utf-8
# Todas las clases están COMPLETAS
# no se ha omitido ninguna línea

class Persona
  attr_reader :nombre
  def initialize(n)
    @nombre = n
  end
end
class Empleado < Persona
end
class Director < Empleado
end

el_dire = Director.new("Joaquín")
puts el_dire.nombre
