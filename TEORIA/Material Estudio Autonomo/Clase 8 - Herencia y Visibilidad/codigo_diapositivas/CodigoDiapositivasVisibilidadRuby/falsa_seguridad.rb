class FalsaSeguridad
  # Un consultor puede ser muy peligroso
  attr_reader :lista

  def initialize
    @lista = [1 ,2 ,3 ,4]
  end

  def info
    puts @lista.size
  end

end

# Fuera de cualquier clase
f = FalsaSeguridad.new
f.info #4

# Modificamos el estado interno
# Simplemente usando un consultor
# Aunque el atributo sea privado
# Cuidado con las referencias
f.lista.clear
f.info #0

