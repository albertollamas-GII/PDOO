class Persona
  def andar
    "Ando como una persona"
  end
  def hablar
    "Hablo como una persona"
  end
end

class Profesor < Persona
  def hablar
    "Hablo como un profesor"
  end
  def impartir_clase
    "Impartiendo clase"
  end
end

puts Persona.new.andar
puts Persona.new.hablar
#puts Persona.new.impartir_clase
puts Profesor.new.andar
puts Profesor.new.hablar
puts Profesor.new.impartir_clase
