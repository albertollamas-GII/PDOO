class Padre
  @instanciaDeClase = 1
  @duda = 2
  @@deClase = 11
  @@duda = 22

  def initialize
    @deInstancia = 333
    @duda = 444
  end

  def self.salida
    puts @instanciaDeClase+1
    puts @duda+1 unless @duda.nil? # desde Hija?
    puts @@deClase+1
    puts @@duda+1
  end

  def salida
    puts @deInstancia+1
    puts @duda+1
    puts @@deClase+1
    puts @@duda+1
  end

  private
  def privado
  end

  def self.privado_clase # Por ahora este método es público
  end
  private_class_method :privado_clase # Atención a la sintaxis

  protected
  def protegido
  end

  public
  def publico
  end

  def test(p)
    privado
    self.privado
    #p.privado
    protegido
    self.protegido
    p.protegido

    #self.class.privado_clase
  end

  def self.test(p)
    #p.privado
  end
end


class Hija < Padre
  @instanciaDeClase = -1

  # Sobreescribimos el valor fijado anteriormente
  # Este atributo es compartido
  @@deClase = -11

  def modifica
    # Acceso a los atributos definidos en Padre
    @duda += 111
  end

  def test(p)
    privado
    self.privado
    #p.privado
    protegido
    self.protegido
    p.protegido
    publico
    self.publico
    p.publico
  end
end

# Fuera de cualquier clase
Padre.new.test(Padre.new)
p=Padre.new
Padre.test(Padre.new)

Padre.salida
Hija.salida # Atención a lo que ocurre con la segunda línea

# Receptor explícito fuera de la clase o subclases
#p.privado
#p.protegido
p.publico

# Fuera de cualquier clase
Hija.new.test(Hija.new)
Hija.new.test(Padre.new)
h=Hija.new
#h.privado
#h.protegido
h.publico

p.salida
h.salida
h.modifica
h.salida
