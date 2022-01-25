class Padre
  def initialize
    @atributo = 33
  end

  def metodo
    puts @atributo + 1
  end
end

class Hija < Padre
  def initialize
  end
end

Padre.new.metodo  #¿Qué ocurre aquí?
Hija.new.metodo   #¿Y aquí?
