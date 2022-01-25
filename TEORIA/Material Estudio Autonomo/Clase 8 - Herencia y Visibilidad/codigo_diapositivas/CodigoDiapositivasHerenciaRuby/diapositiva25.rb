class Persona
  def initialize(n)
    @nombre = n
  end
  def andar
    "Ando como una persona "
  end
  def hablar
    "Hablo como una persona"
  end
end

class Profesor < Persona
  def hablar
    tmp = "Estimados alumnos: \n"
    tmp += "Me llamo #{@nombre} \n" # ¿En qué momento ha tomado valor @nombre?
    tmp += super
    tmp
  end
end

puts Profesor.new("Jaime").hablar # Si Profesor no tiene initialize, ¿qué va a ocurrir?
