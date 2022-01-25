class Persona
  def hablar
    "Hablo como una persona"
  end
end

class Profesor < Persona
  def hablar
    tmp = super
    tmp += ", y también como un profesor"
    tmp
  end
end
puts Profesor.new.hablar
