class C
  def initialize(c)
    puts "Creando C"
    @c = c
  end
end

class D < C
  def initialize
    puts "Creando D"
    @d = 88
  end
end

C.new(99)
d = D.new
puts d.inspect
