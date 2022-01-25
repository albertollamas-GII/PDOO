class E
  def initialize(e)
    puts "Creando E"
    @e = e
  end
end

class F < E
  def initialize
    puts "Creando F"
    @f = 88
    super (99) # Se llama al initialize del padre explícitamente
               # No tiene porqué ser la primera línea
  end
end

E.new(99)
f = F.new
puts f.inspect
